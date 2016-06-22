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
@FacesComponent(HTML5ButtonReset.COMPONENT_TYPE)
public class HTML5ButtonReset extends HTML5UICommand implements HTML5UIButton {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5CommandButtonReset";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.ButtonReset";
	
	private enum PropertyKeys {
		disabled,
		form,
		autofocus,
		useButtonElement
	};
	
	/**
	 * 
	 */
	public HTML5ButtonReset() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
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
