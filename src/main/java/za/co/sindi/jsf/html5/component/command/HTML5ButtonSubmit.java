/**
 * 
 */
package za.co.sindi.jsf.html5.component.command;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIButton;
import za.co.sindi.jsf.html5.component.HTML5UICommand;

/**
 * @author Bienfait Sindi
 * @since 20 July 2013
 *
 */
@FacesComponent(HTML5ButtonSubmit.COMPONENT_TYPE)
public class HTML5ButtonSubmit extends HTML5UICommand implements HTML5UIButton {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5CommandButtonSubmit";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.ButtonSubmit";
	
	private enum PropertyKeys {
		autofocus,
		disabled,
		form,
		formaction,
		formenctype,
		formmethod,
		formtarget,
		formnovalidate,
		useButtonElement
	}
	
	/**
	 * 
	 */
	public HTML5ButtonSubmit() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
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
	 * @return the formenctype
	 */
	public String getFormenctype() {
		return (String) getStateHelper().eval(PropertyKeys.formenctype);
	}
	
	/**
	 * @param formenctype the formenctype to set
	 */
	public void setFormenctype(String formenctype) {
		getStateHelper().put(PropertyKeys.formaction, formenctype);
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
		getStateHelper().put(PropertyKeys.formaction, formmethod);
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
		getStateHelper().put(PropertyKeys.formaction, formtarget);
	}
	
	/**
	 * @return the formnovalidate
	 */
	public boolean getFormnovalidate() {
		return (Boolean) getStateHelper().eval(PropertyKeys.formnovalidate, false);
	}
	
	/**
	 * @param formnovalidate the formnovalidate to set
	 */
	public void setFormnovalidate(boolean formnovalidate) {
		getStateHelper().put(PropertyKeys.formaction, formnovalidate);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.component.HTML5UIButton#isUseButtonElement()
	 */
	public boolean isUseButtonElement() {
		// TODO Auto-generated method stub
		return (Boolean) getStateHelper().eval(PropertyKeys.useButtonElement, false);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.component.HTML5UIButton#setUseButtonElement(boolean)
	 */
	public void setUseButtonElement(boolean useButtonElement) {
		// TODO Auto-generated method stub
		getStateHelper().put(PropertyKeys.useButtonElement, useButtonElement);
	}
}
