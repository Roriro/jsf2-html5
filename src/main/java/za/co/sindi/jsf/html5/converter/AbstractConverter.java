/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.ProjectStage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
public abstract class AbstractConverter implements Converter {

	protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());
	
	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (context == null) {
			throw new IllegalArgumentException("FacesContext may not be null.");
		}
		
		if (component == null) {
			throw new IllegalArgumentException("UIComponent may not be null.");
		}
		
		if (value == null) {
			return null;
		}
		
		if (context.isProjectStage(ProjectStage.Development) && LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("About to convert string " + value);
		}
		
		return convertToObject(context, component, value);
	}

	/* (non-Javadoc)
	 * @see javax.faces.convert.Converter#getAsString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (context == null) {
			throw new IllegalArgumentException("FacesContext may not be null.");
		}
		
		if (component == null) {
			throw new IllegalArgumentException("UIComponent may not be null.");
		}
		
		if (value == null) {
			return "";
		}
		
		if (value instanceof String) {
			return (String) value;
		}
		
		if (context.isProjectStage(ProjectStage.Development) && LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("About to convert value " + String.valueOf(value) + ", class: " + value.getClass().getName() + " to a string.");
		}
		
		return convertToString(context, component, value);
	}
	
	protected abstract Object convertToObject(FacesContext context, UIComponent component, String value);
	protected abstract String convertToString(FacesContext context, UIComponent component, Object value);
}
