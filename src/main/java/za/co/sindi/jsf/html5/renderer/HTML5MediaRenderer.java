/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.faces.application.Resource;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import za.co.sindi.jsf.html5.component.HTML5UIMedia;
import za.co.sindi.jsf.html5.component.HTML5UISource;
import za.co.sindi.jsf.html5.component.HTML5UISources;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.exception.RendererException;
import za.co.sindi.jsf.html5.model.MediaSource;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 09 September 2013
 *
 */
public abstract class HTML5MediaRenderer extends HTML5ResourceAwareRenderer {

	private static final String SOURCE_ELEMENT_NAME = HTML5Elements.SOURCE;
	
	private static final String[] MEDIA_ATTRIBUTES = {
		HTML5Attributes.AUTOPLAY,
		HTML5Attributes.PRELOAD,
		HTML5Attributes.CONTROLS,
		HTML5Attributes.LOOP,
		HTML5Attributes.MEDIAGROUP,
		HTML5Attributes.MUTED,
	};
	
	private static final String[] SOURCE_ATTRIBUTES = {
		HTML5Attributes.TYPE,
		HTML5Attributes.MEDIA
	};
	
	protected void renderMediaSources(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		if (component.getChildCount() > 0) {
			List<UIComponent> children = component.getChildren();
			for (UIComponent child : children) {
				if (child instanceof HTML5UISource) {
					renderSource(context, (HTML5UISource) child, writer);
				} else if (child instanceof HTML5UISources) {
					renderSources(context, ((HTML5UISources)child).getValue(), component, writer);
				}
			}
		}
	}
	
	protected void renderSource(FacesContext context, HTML5UISource component, ResponseWriter writer) throws IOException {
		writer.write("\n\t");
		writer.startElement(SOURCE_ELEMENT_NAME, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		writer.writeAttribute(HTML5Attributes.SRC, getResourceURL(context, component, "value"), null);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, SOURCE_ATTRIBUTES);
		writer.endElement(SOURCE_ELEMENT_NAME);
	}
	
	private void renderSources(FacesContext context, Object value, UIComponent component, ResponseWriter writer) throws IOException {
		MediaSource[] sources = null;
		if (value != null) {
			if (value instanceof Collection<?>) {
				@SuppressWarnings("unchecked")
				Collection<MediaSource> collection = Collections.checkedCollection((Collection<MediaSource>)value, MediaSource.class);
				sources = collection.toArray(new MediaSource[collection.size()]);
			} else if (value.getClass().isArray() && value.getClass().getComponentType().equals(MediaSource.class)) {
				sources = (MediaSource[]) value;
			} else {
				throw new RendererException("Component value is neither a collection, an array nor contains any value of type " + MediaSource.class.getName());
			}
		}
		
		if (sources != null) {
			for (MediaSource source : sources) {
				writer.write("\n\t");
				writer.startElement(SOURCE_ELEMENT_NAME, component);
				String src = "";
				if (source.getResourceName() != null && !source.getResourceName().isEmpty()) {
					Resource resource = RendererUtils.getResource(context, source.getLibrary(), source.getResourceName());
					src = RendererUtils.getResourceURL(context, resource);
				} else if (source.getValue() != null) {
					src = source.getValue();
				}
				writer.writeAttribute(HTML5Attributes.SRC, src, null);
				if (source.getType() != null) {
					writer.writeAttribute(HTML5Attributes.TYPE, source.getType(), null);
				}
				if (source.getMedia() != null) {
					writer.writeAttribute(HTML5Attributes.MEDIA, source.getMedia(), null);
				}
				writer.endElement(SOURCE_ELEMENT_NAME);
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, HTML5UIMedia.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		String elementName = getElementName(component); 
		writer.startElement(elementName, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		String source = getResourceURL(context, component, "value");
		boolean renderSource = (source != null && !source.isEmpty() && !"RES_NO_FOUND".equals(source));
		if (renderSource) {
			writer.writeAttribute(HTML5Attributes.SRC, source, null);
		}
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, MEDIA_ATTRIBUTES);
		renderPassThroughAttributes(context, component, getAdditionalPassthroughAttributes());
		writeDataAttributes(context, component);
		
		if (!renderSource) {
			renderMediaSources(context, component, writer);
			writer.append("\n");
		}
		writer.endElement(elementName);
	}

	protected abstract String getElementName(UIComponent component);
	protected abstract String[] getAdditionalPassthroughAttributes();
}
