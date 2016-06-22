/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.output.HTML5HTML;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.exception.RendererException;

/**
 * @author Bienfait Sindi
 * @since 24 April 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Output", rendererType = HTML5HTML.RENDERER_TYPE)
public class HTML5HTMLRenderer extends HTML5Renderer {

	private static final String ELEMENT_HTML = HTML5Elements.HTML;
	private static final String[] HTML_ATTRIBUTES = new String[] {HTML5Attributes.MANIFEST};
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeBegin(context, component);
		if (!(component.getParent() instanceof UIViewRoot)) {
			throw new RendererException("<" + ELEMENT_HTML + "> tag must be a root element.");
		}
		final ResponseWriter writer = context.getResponseWriter();
		writer.startElement(ELEMENT_HTML, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, HTML_ATTRIBUTES);
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
		writer.write("\n");
        writer.endElement(ELEMENT_HTML);
	}
}
