/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.output.HTML5Body;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 07 July 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Output", rendererType = HTML5Body.RENDERER_TYPE)
public class HTML5BodyRenderer extends HTML5Renderer {

	private static final String ELEMENT_BODY = HTML5Elements.BODY;
	private static final String[] BODY_ATTRIBUTES = { 
		HTML5Attributes.ONAFTERPRINT,
		HTML5Attributes.ONBEFOREPRINT,
		HTML5Attributes.ONBEFOREUNLOAD,
		HTML5Attributes.ONHASHCHANGE,
		HTML5Attributes.ONMESSAGE,
		HTML5Attributes.ONOFFLINE,
		HTML5Attributes.ONPAGEHIDE,
		HTML5Attributes.ONPAGESHOW,
		HTML5Attributes.ONPOPSTATE,
		HTML5Attributes.ONRESIZE,
		HTML5Attributes.ONSTORAGE,
		HTML5Attributes.ONUNLOAD
	};
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeBegin(context, component);
		final ResponseWriter writer = context.getResponseWriter();
		writer.write("\n");
		writer.startElement(ELEMENT_BODY, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writeStyleClassAttribute(writer, component);
		
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, BODY_ATTRIBUTES);
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
		encodeResources(context, ELEMENT_BODY);
		RendererUtils.renderUnhandledMessages(context);
		writer.write("\n");
        writer.endElement(ELEMENT_BODY);
	}
}
