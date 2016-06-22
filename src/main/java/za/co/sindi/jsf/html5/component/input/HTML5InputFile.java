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
@FacesComponent(HTML5InputFile.COMPONENT_TYPE)
public class HTML5InputFile extends HTML5UIInput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputFile";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputFile";
	
	private enum PropertyKeys {
		accept,
		autofocus,
		multiple
	}
	
	/**
	 * 
	 */
	public HTML5InputFile() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * @return the accept
	 */
	public String getAccept() {
		return (String) getStateHelper().eval(PropertyKeys.accept);
	}

	/**
	 * @param accept the accept to set
	 */
	public void setAccept(String accept) {
		getStateHelper().put(PropertyKeys.accept, accept);
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
	 * @return the multiple
	 */
	public boolean isMultiple() {
		return (Boolean) getStateHelper().eval(PropertyKeys.multiple, false);
	}

	/**
	 * @param multiple the multiple to set
	 */
	public void setMultiple(boolean multiple) {
		getStateHelper().put(PropertyKeys.multiple, multiple);
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
