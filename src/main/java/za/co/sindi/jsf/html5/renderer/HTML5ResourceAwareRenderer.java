/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import javax.faces.application.FacesMessage;
import javax.faces.application.ProjectStage;
import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 09 September 2013
 *
 */
public abstract class HTML5ResourceAwareRenderer extends HTML5Renderer {

	protected String getResourceURL(FacesContext context, UIComponent component, String valueAttributeName) {
		String resourceName = (String) component.getAttributes().get("name");
		if (resourceName != null && !resourceName.isEmpty()) {
			String libraryName = (String) component.getAttributes().get("library");
			Resource resource = RendererUtils.getResource(context, libraryName, resourceName);
			if (resource == null) {
                if (context.isProjectStage(ProjectStage.Development)) {
                    String message = "Unable to find resource " + resourceName;
                    context.addMessage(component.getClientId(context), new FacesMessage(FacesMessage.SEVERITY_ERROR, message, message));
                }
                return "RES_NOT_FOUND";
            } else {
            	return RendererUtils.getResourceURL(context, resource);
            }
		} else {
			String value = (String) component.getAttributes().get(valueAttributeName);
            if (value == null || value.isEmpty()) {
                return "";
            } else if (value.contains(ResourceHandler.RESOURCE_IDENTIFIER)) {
                return value;
            } else {
                value = context.getApplication().getViewHandler().getResourceURL(context, value);
                return context.getExternalContext().encodeResourceURL(value);
            }
		}
	}
}
