/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import java.util.Collection;

import javax.faces.component.FacesComponent;
import javax.faces.convert.FloatConverter;

import za.co.sindi.jsf.html5.component.HTML5UIInput;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputNumber.COMPONENT_TYPE)
public class HTML5InputNumber extends HTML5UIInput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputNumber";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputNumber";
	
	private enum PropertyKeys {
		maxlength,
		readonly,
		step,
		autocomplete,
		autofocus,
		list,
		pattern,
		min,
		max,
		placeholder,
	}
	
	/**
	 * 
	 */
	public HTML5InputNumber() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
		setConverter(new FloatConverter());
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
	 * @return the list
	 */
	public String getList() {
		return (String) getStateHelper().eval(PropertyKeys.list);
	}

	/**
	 * @param list the list to set
	 */
	public void setList(String list) {
		getStateHelper().put(PropertyKeys.list, list);
	}
	
	/**
	 * @return the min
	 */
	public Float getMin() {
		return (Float) getStateHelper().eval(PropertyKeys.min);
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(Float min) {
		getStateHelper().put(PropertyKeys.min, min);
	}
	
	/**
	 * @return the max
	 */
	public Float getMax() {
		return (Float) getStateHelper().eval(PropertyKeys.max);
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Float max) {
		getStateHelper().put(PropertyKeys.max, max);
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
	
	/**
	 * @return the step
	 */
	public Float getStep() {
		return (Float) getStateHelper().eval(PropertyKeys.step);
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(Float step) {
		getStateHelper().put(PropertyKeys.step, step);
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
