/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.logging.Level;

import javax.faces.application.NavigationCase;
import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutcomeTarget;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.common.utils.Strings;
import za.co.sindi.jsf.html5.component.HTML5UIButton;
import za.co.sindi.jsf.html5.component.HTML5UIOutcomeTarget;
import za.co.sindi.jsf.html5.component.outcome.HTML5Button;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.utils.RendererUtils;


/**
 * @author Bienfait Sindi
 * @since 09 November 2015
 *
 */
@FacesRenderer(componentFamily = "javax.faces.OutcomeTarget", rendererType = HTML5Button.RENDERER_TYPE)
public class HTML5OutcomeTargetButtonRenderer extends HTML5OutcomeTargetRenderer {
	
	private static final String ELEMENT_INPUT = HTML5Elements.INPUT;
	private static final String ELEMENT_BUTTON = HTML5Elements.BUTTON;
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIOutcomeTarget.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		final ResponseWriter writer = context.getResponseWriter();
		boolean useButtonElement = HTML5ButtonRenderer.shouldRenderAsButtonElement(component);
		if (useButtonElement) {
			writer.startElement(ELEMENT_BUTTON, component);
		} else {
			writer.startElement(ELEMENT_INPUT, component);
			writer.writeAttribute(HTML5Attributes.TYPE, ELEMENT_BUTTON, null);
		}
		writeStyleClassAttribute(writer, component);
		writeIdAttributeIfNecessary(writer, context, component);
		
		if (isDisabled(component)) {
			writer.writeAttribute(HTML5Attributes.DISABLED, HTML5Attributes.DISABLED, null);
		} else {
			NavigationCase navigationCase = getNavigationCase(context, component);
			if (navigationCase == null) {
				writer.writeAttribute(HTML5Attributes.DISABLED, HTML5Attributes.DISABLED, null);
			} else {
				String href = getEncodedTargetURL(context, component, navigationCase);
				href += getFragment(component);
				writer.writeAttribute(HTML5Attributes.ONCLICK, buildOnclick(component, href), HTML5Attributes.ONCLICK);
			}
		}
		
		//Render value
		String value = getValue(component);
		if (!Strings.isNullOrEmpty(value)) {
			writer.writeAttribute(HTML5Attributes.VALUE, value, HTML5Attributes.VALUE);
		}
		
		renderPassThroughAttributes(context, component, HTML5ButtonRenderer.DEFAULT_BUTTON_ATTRIBUTES);
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
		boolean useButtonElement = HTML5ButtonRenderer.shouldRenderAsButtonElement(component);
		
		if (!useButtonElement) {
			if (context.isProjectStage(ProjectStage.Development) && LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("encodeEnd() must render nothing as the element is a HTML5 void element.");
			}
		} else {
			writer.endElement(ELEMENT_BUTTON);
		}
	}
	
	protected boolean isDisabled(UIComponent component) {
		if (component instanceof HTML5UIButton) {
			return ((HTML5UIButton)component).isDisabled();
		}
		
		return RendererUtils.isComponentDisabled(component);
	}
	
	protected String buildOnclick(UIComponent component, String href) {
		String onclick = null;
		if (component instanceof HTML5UIOutcomeTarget) {
			onclick = ((HTML5UIOutcomeTarget)component).getOnclick();
		}
		
		if (onclick == null) {
			onclick = (String) component.getAttributes().get("onclick");
		}
		
		if (onclick == null) {
			onclick = "";
		}
		
		onclick = onclick.trim();
		if (onclick.length() > 0 && !onclick.endsWith(";")) {
			onclick += ";";
		}
		
		if (href != null) {
			onclick += "window.location.href='" + href + "';";
		}
		
		onclick += "return false;";
		return onclick;
 	}
}
