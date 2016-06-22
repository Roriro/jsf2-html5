/**
 * 
 */
package za.co.sindi.jsf.html5.component;

import java.util.Collection;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.convert.Converter;

import za.co.sindi.jsf.html5.converter.DateTimeConverter;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
public abstract class HTML5UInputDateTime extends HTML5UIInput {

	private enum PropertyKeys {
		autocomplete,
		autofocus,
		list,
		min,
		max,
		step,
		readonly,
	}

	/**
	 * 
	 * @param rendererType
	 * @param datePattern
	 * @param timeZone
	 */
	protected HTML5UInputDateTime(String rendererType, String datePattern, TimeZone timeZone) {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(rendererType);
		DateTimeConverter dateTimeConverter = new DateTimeConverter();
		dateTimeConverter.setPattern(datePattern);
		dateTimeConverter.setTimeZone(timeZone);
		setConverter(dateTimeConverter);
	}
	
	/**
	 * 
	 * @param rendererType
	 * @param converter
	 */
	protected HTML5UInputDateTime(String rendererType, Converter converter) {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(rendererType);
		setConverter(converter);
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
	public Date getMin() {
		return (Date) getStateHelper().eval(PropertyKeys.min);
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(Date min) {
		getStateHelper().put(PropertyKeys.min, min);
	}

	/**
	 * @return the max
	 */
	public Date getMax() {
		return (Date) getStateHelper().eval(PropertyKeys.max);
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(Date max) {
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
