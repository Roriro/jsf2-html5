/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import java.util.Collection;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIInput;
import za.co.sindi.jsf.html5.converter.MonthConverter;
import za.co.sindi.jsf.html5.value.Month;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputMonth.COMPONENT_TYPE)
public class HTML5InputMonth extends HTML5UIInput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputMonth";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputMonth";
	
	private enum PropertyKeys {
		autocomplete,
		autofocus,
		list,
		min,
		max,
		step,
		readonly
	}

	/**
	 * 
	 */
	public HTML5InputMonth() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
		setConverter(new MonthConverter());
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
	public Month getMin() {
		return (Month) getStateHelper().eval(PropertyKeys.min);
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(Month min) {
		getStateHelper().put(PropertyKeys.min, min);
	}

	/**
	 * @return the max
	 */
	public Month getMax() {
		return (Month) getStateHelper().eval(PropertyKeys.max);
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Month max) {
		getStateHelper().put(PropertyKeys.max, max);
	}

	/**
	 * @return the step
	 */
	public String getStep() {
		return (String) getStateHelper().eval(PropertyKeys.step);
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(String step) {
		getStateHelper().put(PropertyKeys.step, step);
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
