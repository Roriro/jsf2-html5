/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.Map;
import java.util.logging.Level;

import javax.faces.application.ProjectStage;
import javax.faces.component.UICommand;
import javax.faces.component.UIComponent;
import javax.faces.component.UIForm;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.event.ActionEvent;

import za.co.sindi.jsf.html5.component.HTML5UIButton;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.exception.RendererException;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 18 July 2013
 *
 */
public abstract class HTML5ButtonRenderer extends HTML5Renderer {
	
	private static final String ELEMENT_INPUT = HTML5Elements.INPUT;
	private static final String ELEMENT_BUTTON = HTML5Elements.BUTTON;
//	private static final String IMAGE_BUTTON_SUFFIX_X = ".x";
//	private static final String IMAGE_BUTTON_SUFFIX_Y = ".y";
	public static final String[] DEFAULT_BUTTON_ATTRIBUTES = new String[] {
		HTML5Attributes.FORM,
		HTML5Attributes.AUTOFOCUS
	};
	
	public static boolean shouldRenderAsButtonElement(UIComponent component) {
		if (component == null) {
			return false;
		}
		
		if (component instanceof HTML5UIButton) {
			return ((HTML5UIButton)component).isUseButtonElement();
		}
		
		Boolean result = (Boolean) component.getAttributes().get("useButtonElement");
		return (result == null) ? false : result;
	}

	protected String getValue(UIComponent component) {
		Object value = null;
		if (component != null) {
			if (component instanceof UICommand) {
				value = ((UICommand)component).getValue();
			}
			
			if (value == null) {
				value = component.getAttributes().get(HTML5Attributes.VALUE);
			}
		}
		
		return value == null ? null : String.valueOf(value);
	}
	
	protected boolean isDisabled(UIComponent component) {
		if (component instanceof HTML5UIButton) {
			return ((HTML5UIButton)component).isDisabled();
		}
		
//		Boolean disabled = (Boolean) component.getAttributes().get(HTML5Attributes.DISABLED);
//		return ((disabled == null) ? false : disabled);
		return RendererUtils.isComponentDisabled(component);
	}
	
	protected boolean isReset(UIComponent component) {
		return "reset".equalsIgnoreCase(getButtonType(component));
	}
	
	protected boolean isClicked(FacesContext context, UIComponent component) {
		String clientId = component.getClientId(context);
		Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
		return (requestMap.containsKey(clientId) /*|| requestMap.containsKey(clientId + IMAGE_BUTTON_SUFFIX_X) || requestMap.containsKey(clientId + IMAGE_BUTTON_SUFFIX_Y)*/);
	}
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#decode(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void decode(FacesContext context, UIComponent component) {
		// TODO Auto-generated method stub
//		super.decode(context, component);
		RendererUtils.validateParameters(context, component, UICommand.class);
		
		if (!shouldDecode(component)) {
			return ;
		}
		
		RendererUtils.decodeClientBehaviours(context, component);
		
		if (!isReset(component) && isClicked(context, component)) {
			component.queueEvent(new ActionEvent(component));
			
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("End decoding " + RendererUtils.getPathToComponent(component));
			}
		}
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
//		super.encodeBegin(context, component);
		RendererUtils.validateParameters(context, component, UICommand.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		if (RendererUtils.findParentComponent(component, UICommand.class) != null) {
			throw new RendererException("Cannot nest a button inside another button.");
		}
		
		if (RendererUtils.findParentComponent(component, UIForm.class) == null) {
			throw new RendererException("This button is not rendered inside a form (" + RendererUtils.getPathToComponent(component) + ").");
		}

		final ResponseWriter writer = context.getResponseWriter();
		boolean useButtonElement = HTML5ButtonRenderer.shouldRenderAsButtonElement(component);
		String clientId = component.getClientId(context);
		String value = getValue(component);
		String type = getButtonType(component);
		if (type == null || (!"reset".equals(type) && !"submit".equals(type) && !"button".equals(type))) {
            type = "submit";
            // This is needed in the decode method
            component.getAttributes().put("type", type);
        }
		
		if (useButtonElement) {
			writer.startElement(ELEMENT_BUTTON, component);
		} else {
			writer.startElement(ELEMENT_INPUT, component);
		}
		writer.writeAttribute(HTML5Attributes.ID, clientId, JSFAttributes.CLIENTID);
		writer.writeAttribute(HTML5Attributes.NAME, clientId, JSFAttributes.CLIENTID);
		writer.writeAttribute(HTML5Attributes.TYPE, type, null);
		if (value != null && !useButtonElement) {
			writer.writeAttribute(HTML5Attributes.VALUE, value, HTML5Attributes.VALUE);
		}
		if (isDisabled(component)) {
			writer.writeAttribute(HTML5Attributes.DISABLED, HTML5Attributes.DISABLED, null);
		}
		writeStyleClassAttribute(writer, component);
		renderPassThroughAttributes(context, component, DEFAULT_BUTTON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		renderPassThroughAttributes(context, component, getPassthroughAttributes());
		renderAdditionalPassthroughAttributes(context, component);
		writeDataAttributes(context, component);
		if (value != null && useButtonElement) {
			writer.write(value);
		}
		if (!useButtonElement) {
			writer.endElement(ELEMENT_INPUT);
		}
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeEnd(context, component);
		final ResponseWriter writer = context.getResponseWriter();
		boolean useButtonElement = shouldRenderAsButtonElement(component);
		
		if (!useButtonElement) {
			if (context.isProjectStage(ProjectStage.Development) && LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("encodeEnd() must render nothing as the element is a HTML5 void element.");
			}
		} else {
			writer.endElement(ELEMENT_BUTTON);
		}
	}
	
	protected void renderAdditionalPassthroughAttributes(FacesContext context, UIComponent component) throws IOException {
		
	}

	protected abstract String getButtonType(UIComponent component);
	protected abstract String[] getPassthroughAttributes();
}
