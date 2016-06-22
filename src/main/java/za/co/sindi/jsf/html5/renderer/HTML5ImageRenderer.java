/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIGraphic;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.graphic.HTML5GraphicImage;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 09 September 2013
 *
 */
@FacesRenderer(componentFamily=UIGraphic.COMPONENT_FAMILY, rendererType=HTML5GraphicImage.RENDERER_TYPE)
public class HTML5ImageRenderer extends HTML5ResourceAwareRenderer {
	
	private static final String IMG_ELEMENT_NAME = HTML5Elements.IMG;
	private static final String[] IMG_ATTRIBUTES = {
		HTML5Attributes.ALT,
		HTML5Attributes.HEIGHT,
		HTML5Attributes.WIDTH,
		HTML5Attributes.USEMAP,
		HTML5Attributes.ISMAP
	};

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIGraphic.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement(IMG_ELEMENT_NAME, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		writer.writeAttribute(HTML5Attributes.SRC, getResourceURL(context, component, "value"), null);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, IMG_ATTRIBUTES);
		writeDataAttributes(context, component);
		writer.endElement(IMG_ELEMENT_NAME);
	}
}
