/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.form.HTML5Form;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 12 July 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Form", rendererType = HTML5Form.RENDERER_TYPE)
public class HTML5FormRenderer extends HTML5Renderer {
	
	private static final String JSF_HIDDEN_FORM_ATTRIBUTE_SUFFIX = "_FORMSUBMIT";
	private static final String FORM_ELEMENT_NAME = HTML5Elements.FORM;
	private static final String INPUT_ELEMENT_NAME = HTML5Elements.INPUT;
	private static final String[] FORM_ATTRIBUTES = {
		//HTML5Attributes.ACTION,
//		HTML5Attributes.METHOD,
		HTML5Attributes.ENCTYPE,
		//HTML5Attributes.ACCEPT_CHARSET,
		HTML5Attributes.NOVALIDATE,
		HTML5Attributes.TARGET,
		HTML5Attributes.AUTOCOMPLETE
	};

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#decode(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void decode(FacesContext context, UIComponent component) {
		// TODO Auto-generated method stub
		super.decode(context, component);
		RendererUtils.decodeClientBehaviours(context, component);
		
		//Flag to set UIForm.setSubmitted(boolean submitted); method
		String clientId = component.getClientId(context);
		Map<String, String> requestParameters = context.getExternalContext().getRequestParameterMap();
		String hiddenInputName = clientId + JSF_HIDDEN_FORM_ATTRIBUTE_SUFFIX;
		boolean submitted = requestParameters != null && requestParameters.containsKey(hiddenInputName) && clientId.equals(requestParameters.get(hiddenInputName));
		((UIForm)component).setSubmitted(submitted);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
//		super.encodeBegin(context, component);
		RendererUtils.validateParameters(context, component, UIForm.class);
		ResponseWriter writer = context.getResponseWriter();
		String clientId = component.getClientId(context);
		String actionURL = getActionURL(context);
		String encodedActionURL = context.getExternalContext().encodeActionURL(actionURL);
		String encodedPartialActionURL = context.getExternalContext().encodePartialActionURL(actionURL);
		String acceptCharset = (String) component.getAttributes().get(JSFAttributes.ACCEPTCHARSET);
		
		writer.write("\n");
		writer.startElement(FORM_ELEMENT_NAME, component);
		writer.writeAttribute(HTML5Attributes.ACTION, encodedActionURL, null);
		writer.writeAttribute(HTML5Attributes.ID, clientId, JSFAttributes.CLIENTID);
		writer.writeAttribute(HTML5Attributes.NAME, clientId, HTML5Attributes.NAME);
		writer.writeAttribute(HTML5Attributes.METHOD, "post", null);
		if (acceptCharset != null) {
			writer.writeAttribute(HTML5Attributes.ACCEPT_CHARSET, acceptCharset, JSFAttributes.ACCEPTCHARSET);
		}
		
		writeStyleClassAttribute(writer, component);
		renderPassThroughAttributes(context, component, FORM_ATTRIBUTES);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		writeDataAttributes(context, component);
		//Force end closing tag
		writer.writeText("\n", component, null);
		
		//We need to write a hidden attribute to help see if this form was submitted on decode() method.
		writer.startElement(INPUT_ELEMENT_NAME, component);
		writer.writeAttribute(HTML5Attributes.TYPE, "hidden", null);
		writer.writeAttribute(HTML5Attributes.NAME, clientId + JSF_HIDDEN_FORM_ATTRIBUTE_SUFFIX, null);
		writer.writeAttribute(HTML5Attributes.VALUE, clientId, JSFAttributes.CLIENTID);
		writer.endElement(INPUT_ELEMENT_NAME);
		writer.write("\n");
		
		//Write hidden field for partial submit
		if (encodedActionURL != null && encodedPartialActionURL != null && !encodedActionURL.equals(encodedPartialActionURL)) {
			writer.startElement(INPUT_ELEMENT_NAME, component);
			writer.writeAttribute(HTML5Attributes.TYPE, "hidden", null);
			writer.writeAttribute(HTML5Attributes.NAME, "javax.faces.encodedURL", null);
			writer.writeAttribute(HTML5Attributes.VALUE, encodedPartialActionURL, null);
			writer.endElement(INPUT_ELEMENT_NAME);
			writer.write("\n");
		}
	}

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
		
		ResponseWriter writer = context.getResponseWriter();
		
		//Encode all children...
		encodeResources(context, FORM_ELEMENT_NAME);
		
		//According to the JSF specification, this has to be done on encodeEnd().
		context.getApplication().getViewHandler().writeState(context);
		//End
		writer.write("\n");
		writer.endElement(FORM_ELEMENT_NAME);
	}

	private String getActionURL(FacesContext context) {
		String viewId = context.getViewRoot().getViewId();
		return context.getApplication().getViewHandler().getActionURL(context, viewId);
	}
}
