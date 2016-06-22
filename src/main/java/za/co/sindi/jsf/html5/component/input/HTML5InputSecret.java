/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import java.util.Collection;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIInput;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesComponent(HTML5InputSecret.COMPONENT_TYPE)
public class HTML5InputSecret extends HTML5UIInput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputSecret";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputSecret";
	
	private enum PropertyKeys {
		maxlength,
		readonly,
		size,
		autocomplete,
		autofocus,
		pattern,
		placeholder
	}
	
	/**
	 * 
	 */
	public HTML5InputSecret() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * @return the maxlength
	 */
	public Integer getMaxlength() {
		return (Integer) getStateHelper().eval(PropertyKeys.maxlength);
	}

	/**
	 * @param maxlength the maxlength to set
	 */
	public void setMaxlength(Integer maxlength) {
		getStateHelper().put(PropertyKeys.maxlength, maxlength);
	}

	/**
	 * @return the readonly
	 */
	public boolean isReadonly() {
		return (Boolean) getStateHelper().eval(PropertyKeys.readonly, false);
	}

	/**
	 * @param readonly the readonly to set
	 */
	public void setReadonly(boolean readonly) {
		getStateHelper().put(PropertyKeys.readonly, readonly);
	}

	/**
	 * @return the size
	 */
	public Integer getSize() {
		return (Integer) getStateHelper().eval(PropertyKeys.size);
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(Integer size) {
		getStateHelper().put(PropertyKeys.size, size);
	}

	/**
	 * @return the autocomplete
	 */
	public String getAutocomplete() {
		return (String) getStateHelper().eval(PropertyKeys.autocomplete);
	}

	/**
	 * @param autocomplete the autocomplete to set
	 */
	public void setAutocomplete(String autocomplete) {
		getStateHelper().put(PropertyKeys.autocomplete, autocomplete);
	}

	/**
	 * @return the autofocus
	 */
	public boolean isAutofocus() {
		return (Boolean) getStateHelper().eval(PropertyKeys.autofocus, false);
	}

	/**
	 * @param autofocus the autofocus to set
	 */
	public void setAutofocus(boolean autofocus) {
		getStateHelper().put(PropertyKeys.autofocus, autofocus);
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return (String) getStateHelper().eval(PropertyKeys.pattern);
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		getStateHelper().put(PropertyKeys.pattern, pattern);
	}

	/**
	 * @return the placeholder
	 */
	public String getPlaceholder() {
		return (String) getStateHelper().eval(PropertyKeys.placeholder);
	}

	/**
	 * @param placeholder the placeholder to set
	 */
	public void setPlaceholder(String placeholder) {
		getStateHelper().put(PropertyKeys.placeholder, placeholder);
	}
	
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponentBase#getEventNames()
	 */
	@Override
	public Collection<String> getEventNames() {
		// TODO Auto-generated method stub
		return DEFAULT_VALUE_CHANGE_EVENT_NAMES;
	}
	
	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponentBase#getDefaultEventName()
	 */
	@Override
	public String getDefaultEventName() {
		// TODO Auto-generated method stub
		return "valueChange";
	}
}
