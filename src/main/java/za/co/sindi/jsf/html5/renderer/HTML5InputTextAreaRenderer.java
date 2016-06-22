/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.input.HTML5InputTextArea;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 17 August 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = HTML5InputTextArea.RENDERER_TYPE)
public class HTML5InputTextAreaRenderer extends HTML5BaseInputRenderer {
	
	private static final String ELEMENT_TEXTAREA = HTML5Elements.TEXTAREA;
	private static final String[] TEXTAREA_ATTRIBUTES = {
		HTML5Attributes.MAXLENGTH,
		HTML5Attributes.READONLY,
		HTML5Attributes.SIZE,
		HTML5Attributes.AUTOCOMPLETE,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.REQUIRED,
		HTML5Attributes.PLACEHOLDER,
		HTML5Attributes.DIRNAME,
		HTML5Attributes.ROWS,
		HTML5Attributes.WRAP,
		HTML5Attributes.COLS
	};

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeEnd(context, component);
		if (!shouldEncode(component)) {
			return ;
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		String clientId = component.getClientId(context);
		String value = getStringValue(context, component, getObjectValue(context, component));
		
		writer.startElement(ELEMENT_TEXTAREA, component);
		writeIdAttributeIfNecessary(writer, context, component);
		writer.writeAttribute(HTML5Attributes.NAME, clientId, JSFAttributes.CLIENTID);
		if (RendererUtils.isComponentDisabled(component)) {
			writer.writeAttribute(HTML5Attributes.DISABLED, HTML5Attributes.DISABLED, null);
		}
		writeStyleClassAttribute(writer, component);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, TEXTAREA_ATTRIBUTES);
		writeDataAttributes(context, component);
		
		// render default text specified
		writer.writeText(value, component, HTML5Attributes.VALUE);
        
        writer.endElement(ELEMENT_TEXTAREA);
	}
}
