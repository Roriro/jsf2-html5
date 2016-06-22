/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Level;

import javax.faces.application.ConfigurableNavigationHandler;
import javax.faces.application.NavigationCase;
import javax.faces.application.NavigationHandler;
import javax.faces.component.UIComponent;
import javax.faces.component.UIOutcomeTarget;
import javax.faces.component.UIParameter;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionListener;
import javax.faces.lifecycle.ClientWindow;

import za.co.sindi.jsf.html5.component.HTML5UIOutcomeTarget;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;

/**
 * @author Bienfait Sindi
 * @since 09 November 2015
 *
 */
public abstract class HTML5OutcomeTargetRenderer extends HTML5Renderer {
	
	protected String getFragment(UIComponent component) {
		String fragment = null;
		if (component instanceof HTML5UIOutcomeTarget) {
			fragment = ((HTML5UIOutcomeTarget)component).getFragment();
		}
		
		if (fragment == null) {
			fragment = (String) component.getAttributes().get("fragment");
		}
		
		fragment = (fragment != null ? fragment.trim() : "");
		if (fragment.length() > 0) {
			fragment += "#" + fragment;
		}
		
		return fragment;
	}
	
	protected String getValue(UIComponent component) {
		Object value = null;
		if (component != null) {
			if (component instanceof UIOutcomeTarget) {
				value = ((UIOutcomeTarget)component).getValue();
			}
			
			if (value == null) {
				value = component.getAttributes().get(HTML5Attributes.VALUE);
			}
		}
		
		return value == null ? "" : String.valueOf(value);
	}
	
	protected NavigationCase getNavigationCase(FacesContext context, UIComponent component) {
		NavigationHandler navigationHandler = context.getApplication().getNavigationHandler();
		if (!(navigationHandler instanceof ConfigurableNavigationHandler)) {
			if (LOGGER.isLoggable(Level.WARNING)) {
				LOGGER.log(Level.WARNING, "jsf.outcome.target.invalid.navigationhandler.type", component.getClientId());
			}
			
			return null;
		}
		
		String outcome = ((UIOutcomeTarget) component).getOutcome();
		if (outcome == null) {
			outcome = component.getClientId();
		}
		
		String toFlowDocumentId = (String) component.getAttributes().get(ActionListener.TO_FLOW_DOCUMENT_ID_ATTR_NAME);
		NavigationCase navigationCase = null;
		if (null == toFlowDocumentId) {
			navigationCase = ((ConfigurableNavigationHandler)navigationHandler).getNavigationCase(context, null, outcome);
		} else {
			navigationCase = ((ConfigurableNavigationHandler)navigationHandler).getNavigationCase(context, null, outcome, toFlowDocumentId);
		}
		
		if (navigationCase == null && LOGGER.isLoggable(Level.WARNING)) {
			if (LOGGER.isLoggable(Level.WARNING)) {
				LOGGER.log(Level.WARNING, "jsf.outcometarget.navigation.case.not.resolved", component.getClientId());
			}
		}
			
		return navigationCase;
	}

	protected boolean isIncludeViewParams(UIComponent component, NavigationCase navigationCase) {
		return (((UIOutcomeTarget)component).isIncludeViewParams() || navigationCase.isIncludeViewParams());
	}
	
	/**
	 * Taken from the following Oracle document on <a href="http://docs.oracle.com/javaee/6/javaserverfaces/2.1/docs/vdldocs/facelets/h/button.html">&lth:button /&gt;</a>.
	 * 
	 * @param context
	 * @param component
	 * @param navigationCase
	 * @return
	 */
	protected String getEncodedTargetURL(FacesContext context, UIComponent component, NavigationCase navigationCase) {
		String toViewId = navigationCase.getToViewId(context);
		Map<String, List<String>> params = getParameters(navigationCase, component);
		boolean disableclientWindowRendering = false;
		ClientWindow clientWindow = null;
		
		try {
			if (component instanceof UIOutcomeTarget) {
				disableclientWindowRendering = ((UIOutcomeTarget)component).isDisableClientWindow();
			} else {
				Object value = component.getAttributes().get("disableClientWindow");
				if (value != null) {
					disableclientWindowRendering = "true".equalsIgnoreCase(String.valueOf(value));
				}
			}
			
			if (disableclientWindowRendering) {
				clientWindow = context.getExternalContext().getClientWindow();
				if (clientWindow != null && clientWindow.isClientWindowRenderModeEnabled(context)) {
					clientWindow.disableClientWindowRenderMode(context);
				}
			}
			
			return context.getApplication().getViewHandler().getBookmarkableURL(context, toViewId, params, isIncludeViewParams(component, navigationCase));
		} finally {
			if (disableclientWindowRendering && clientWindow != null) {
				clientWindow.enableClientWindowRenderMode(context);
			}
		}
	}
	
	private Map<String, List<String>> getParameters(UIComponent component) {
		Map<String, List<String>> params = new LinkedHashMap<>();
		if (component.getChildCount() > 0) {
			for (UIComponent childComponent : component.getChildren()) {
				if (childComponent instanceof UIParameter) {
					UIParameter child = ((UIParameter)childComponent);
					String name = child.getName().trim();
					if (!params.containsKey(name)) {
						params.put(name, new ArrayList<String>());
					}
						
					Object value = child.getValue();
					if (value != null) {
						//Add
						params.get(name).add(String.valueOf(value));
					}
				}
			}
		}
		
		return params;
	}
	
	private Map<String, List<String>> getParameters(NavigationCase navigationCase, UIComponent component) {
		Map<String, List<String>> params = getParameters(component);
		Map<String, List<String>> navigationParams = navigationCase.getParameters();
		
		if (navigationParams != null && !navigationParams.isEmpty()) {
			for (Entry<String, List<String>> entry : navigationParams.entrySet()) {
				String name = entry.getKey();
				
				if (!params.containsKey(name)) {
					params.put(name, entry.getValue());
				}
			}
		}
		
		return params;
	}
}
