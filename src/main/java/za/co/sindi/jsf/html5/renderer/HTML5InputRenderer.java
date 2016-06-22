/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.exception.RendererException;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 31 July 2013
 *
 */
public abstract class HTML5InputRenderer extends HTML5BaseInputRenderer {

	private static final String ELEMENT_INPUT = HTML5Elements.INPUT;
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
//		super.encodeBegin(context, component);
		RendererUtils.validateParameters(context, component, UIInput.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		String type = getInputType(component);
		if (null == type || type.isEmpty()) {
			//According to HTML5 Spec, an empty type must be set to "text"
			type = "text";
			 // This is needed in the decode method
            component.getAttributes().put("type", type);
		}
		
		if (RendererUtils.findParentComponent(component, UIForm.class) == null) {
			throw new RendererException("This input (type = \"" + type + "\") can only be rendered inside an HTML form.");
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		String clientId = component.getClientId(context);
		String value = getStringValue(context, component, getObjectValue(context, component));
		
		writer.startElement(ELEMENT_INPUT, component);
		writer.writeAttribute(HTML5Attributes.TYPE, type, null);
		writer.writeAttribute(HTML5Attributes.ID, clientId, JSFAttributes.CLIENTID);
		writer.writeAttribute(HTML5Attributes.NAME, clientId, JSFAttributes.CLIENTID);
		writeStyleClassAttribute(writer, component);
		if (renderValueAttribute()) {
			writer.writeAttribute(HTML5Attributes.VALUE, value, HTML5Attributes.VALUE);
		}
		if (RendererUtils.isComponentDisabled(component)) {
			writer.writeAttribute(HTML5Attributes.DISABLED, HTML5Attributes.DISABLED, null);
		}
		renderAdditionalAttributes(context, component, writer);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, new String[] { HTML5Attributes.FORM });
		renderPassThroughAttributes(context, component, getPassthroughAttributes());
		writeDataAttributes(context, component);
		writer.endElement(ELEMENT_INPUT);
	}
	
	protected void renderAdditionalAttributes(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		//No op, for now, unless overridden
	}
	
	//This was added to support file input (which never renders value attribute)
	protected boolean renderValueAttribute() {
		return true;
	}
	
	protected abstract String getInputType(UIComponent component);
	protected abstract String[] getPassthroughAttributes();
}
