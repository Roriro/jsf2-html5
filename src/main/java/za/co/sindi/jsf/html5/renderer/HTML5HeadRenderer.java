/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.output.HTML5Head;
import za.co.sindi.jsf.html5.constants.HTML5Elements;

/**
 * @author Bienfait Sindi
 * @since 24 April 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Output", rendererType = HTML5Head.RENDERER_TYPE)
public class HTML5HeadRenderer extends HTML5Renderer {
	
	private static final String ELEMENT_HEAD = HTML5Elements.HEAD;
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeBegin(context, component);
		final ResponseWriter writer = context.getResponseWriter();
		writer.write("\n");
		writer.startElement(ELEMENT_HEAD, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		writeDataAttributes(context, component);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeEnd(context, component);
		final ResponseWriter writer = context.getResponseWriter();
		encodeResources(context, ELEMENT_HEAD);
//		RendererUtils.renderUnhandledMessages(context);
        writer.endElement(ELEMENT_HEAD);
	}
}
