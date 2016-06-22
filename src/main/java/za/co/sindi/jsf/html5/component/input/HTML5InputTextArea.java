/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import java.util.Collection;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIInput;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputTextArea.COMPONENT_TYPE)
public class HTML5InputTextArea extends HTML5UIInput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputTextArea";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputTextArea";
	
	private enum PropertyKeys {
		maxlength,
		readonly,
		size,
		autocomplete,
		autofocus,
		placeholder,
		dirname,
		rows,
		wrap,
		cols
	}
	
	/**
	 * 
	 */
	public HTML5InputTextArea() {
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
	 * @return the dirname
	 */
	public String getDirname() {
		return (String) getStateHelper().eval(PropertyKeys.dirname);
	}

	/**
	 * @param dirname the dirname to set
	 */
	public void setDirname(String dirname) {
		getStateHelper().put(PropertyKeys.dirname, dirname);
	}

	/**
	 * @return the rows
	 */
	public Integer getRows() {
		return (Integer) getStateHelper().eval(PropertyKeys.rows);
	}

	/**
	 * @param rows the rows to set
	 */
	public void setRows(Integer rows) {
		getStateHelper().put(PropertyKeys.rows, rows);
	}

	/**
	 * @return the cols
	 */
	public Integer getCols() {
		return (Integer) getStateHelper().eval(PropertyKeys.cols);
	}

	/**
	 * @param cols the cols to set
	 */
	public void setCols(Integer cols) {
		getStateHelper().put(PropertyKeys.cols, cols);
	}

	/**
	 * @return the wrap
	 */
	public String getWrap() {
		return (String) getStateHelper().eval(PropertyKeys.wrap);
	}

	/**
	 * @param wrap the wrap to set
	 */
	public void setWrap(String wrap) {
		getStateHelper().put(PropertyKeys.wrap, wrap);
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
