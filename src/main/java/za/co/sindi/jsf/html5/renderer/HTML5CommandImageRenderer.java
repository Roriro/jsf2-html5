/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.command.HTML5Image;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.exception.RendererException;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 14 September 2013
 *
 */
@FacesRenderer(componentFamily=UICommand.COMPONENT_FAMILY, rendererType=HTML5Image.RENDERER_TYPE)
public class HTML5CommandImageRenderer extends HTML5ResourceAwareRenderer {
	
	private static final String ELEMENT_INPUT = HTML5Elements.INPUT;
	private static final String[] INPUT_IMAGE_ATTRIBUTES = {
		HTML5Attributes.FORM,
		HTML5Attributes.ALT,
		HTML5Attributes.FORMACTION,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.FORMMETHOD,
		HTML5Attributes.FORMTARGET,
		HTML5Attributes.FORMNOVALIDATE,
		HTML5Attributes.HEIGHT,
		HTML5Attributes.WIDTH
	};
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
//		super.encodeBegin(context, component);
		RendererUtils.validateParameters(context, component, UICommand.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		if (RendererUtils.findParentComponent(component, UIForm.class) == null) {
			throw new RendererException("This input image type can only be rendered inside an HTML form.");
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		String clientId = component.getClientId(context);
		String value = super.getResourceURL(context, component, "value");
		
		writer.startElement(ELEMENT_INPUT, component);
		writer.writeAttribute(HTML5Attributes.TYPE, "image", null);
		writer.writeAttribute(HTML5Attributes.ID, clientId, JSFAttributes.CLIENTID);
		writer.writeAttribute(HTML5Attributes.NAME, clientId, JSFAttributes.CLIENTID);
		writer.writeAttribute(HTML5Attributes.SRC, value, HTML5Attributes.VALUE);
		writeStyleClassAttribute(writer, component);
		
		if (RendererUtils.isComponentDisabled(component)) {
			writer.writeAttribute(HTML5Attributes.DISABLED, HTML5Attributes.DISABLED, null);
		}
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, INPUT_IMAGE_ATTRIBUTES);
		writeDataAttributes(context, component);
		writer.endElement(ELEMENT_INPUT);
	}
}
