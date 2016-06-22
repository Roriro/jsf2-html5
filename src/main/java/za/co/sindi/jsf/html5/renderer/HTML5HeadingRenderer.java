/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.javax.faces.component.UIHeading;
import za.co.sindi.jsf.html5.component.heading.HTML5Heading;
import za.co.sindi.jsf.html5.exception.RendererException;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 28 August 2013
 *
 */
@FacesRenderer(componentFamily = UIHeading.COMPONENT_FAMILY, rendererType = HTML5Heading.RENDERER_TYPE)
public class HTML5HeadingRenderer extends HTML5Renderer {

	private static final List<String> HEADING_LIST = Arrays.asList("h1", "h2", "h3", "h4", "h5", "h6");

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
//		super.encodeBegin(context, component);
		RendererUtils.validateParameters(context, component, UIHeading.class);
		String headingElement = (String) component.getAttributes().get("element");
		if (headingElement == null || !HEADING_LIST.contains(headingElement)) {
			throw new RendererException("Unknown HTML5 heading element " + headingElement);
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement(headingElement, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		writeDataAttributes(context, component);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component)	throws IOException {
		// TODO Auto-generated method stub
//		super.encodeChildren(context, component);
		RendererUtils.validateParameters(context, component, UIHeading.class);
		String headingElement = (String) component.getAttributes().get("element");
		
		final ResponseWriter writer = context.getResponseWriter();
		writer.endElement(headingElement);
		writer.writeText("\n", component, null);
	}
}
