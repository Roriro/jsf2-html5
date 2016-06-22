/**
 * 
 */
package za.co.sindi.jsf.html5.component.command;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UICommand;

/**
 * @author Bienfait Sindi
 * @since 20 July 2013
 *
 */
@FacesComponent(HTML5Image.COMPONENT_TYPE)
public class HTML5Image extends HTML5UICommand {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5CommandImage";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.ButtonImage";
	
	private enum PropertyKeys {
		library,
		name,
		disabled,
		form,
		alt,
		formaction,
		autofocus,
		formenctype,
		formmethod,
		formtarget,
		formnovalidate,
		height,
		width,
	}
	
	/**
	 * 
	 */
	public HTML5Image() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * @return the library
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(PropertyKeys.library);
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(String library) {
		getStateHelper().put(PropertyKeys.library, library);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return (String) getStateHelper().eval(PropertyKeys.name);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		getStateHelper().put(PropertyKeys.name, name);
	}

	/**
	 * @return the disabled
	 */
	public boolean isDisabled() {
		return (Boolean) getStateHelper().eval(PropertyKeys.disabled, false);
	}

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled) {
		getStateHelper().put(PropertyKeys.disabled, disabled);
	}

	/**
	 * @return the form
	 */
	public String getForm() {
		return (String) getStateHelper().eval(PropertyKeys.form);
	}

	/**
	 * @param form the form to set
	 */
	public void setForm(String form) {
		getStateHelper().put(PropertyKeys.form, form);
	}

	/**
	 * @return the alt
	 */
	public String getAlt() {
		return (String) getStateHelper().eval(PropertyKeys.alt);
	}

	/**
	 * @param alt the alt to set
	 */
	public void setAlt(String alt) {
		getStateHelper().put(PropertyKeys.alt, alt);
	}

	/**
	 * @return the formaction
	 */
	public String getFormaction() {
		return (String) getStateHelper().eval(PropertyKeys.formaction);
	}

	/**
	 * @param formaction the formaction to set
	 */
	public void setFormaction(String formaction) {
		getStateHelper().put(PropertyKeys.formaction, formaction);
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
	 * @return the formenctype
	 */
	public String getFormenctype() {
		return (String) getStateHelper().eval(PropertyKeys.formenctype);
	}

	/**
	 * @param formenctype the formenctype to set
	 */
	public void setFormenctype(String formenctype) {
		getStateHelper().put(PropertyKeys.formenctype, formenctype);
	}

	/**
	 * @return the formmethod
	 */
	public String getFormmethod() {
		return (String) getStateHelper().eval(PropertyKeys.formmethod);
	}

	/**
	 * @param formmethod the formmethod to set
	 */
	public void setFormmethod(String formmethod) {
		getStateHelper().put(PropertyKeys.formmethod, formmethod);
	}

	/**
	 * @return the formtarget
	 */
	public String getFormtarget() {
		return (String) getStateHelper().eval(PropertyKeys.formtarget);
	}

	/**
	 * @param formtarget the formtarget to set
	 */
	public void setFormtarget(String formtarget) {
		getStateHelper().put(PropertyKeys.formtarget, formtarget);
	}

	/**
	 * @return the formnovalidate
	 */
	public boolean isFormnovalidate() {
		return (Boolean) getStateHelper().eval(PropertyKeys.formnovalidate, false);
	}

	/**
	 * @param formnovalidate the formnovalidate to set
	 */
	public void setFormnovalidate(boolean formnovalidate) {
		getStateHelper().put(PropertyKeys.formnovalidate, formnovalidate);
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return (Integer) getStateHelper().eval(PropertyKeys.height, Integer.MIN_VALUE);
	}

	/**
	 * @param height the height to set
	 */
	public void setHeight(int height) {
		getStateHelper().put(PropertyKeys.height, height);
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return (Integer) getStateHelper().eval(PropertyKeys.width, Integer.MIN_VALUE);
	}

	/**
	 * @param width the width to set
	 */
	public void setWidth(int width) {
		getStateHelper().put(PropertyKeys.width, width);
	}
}
