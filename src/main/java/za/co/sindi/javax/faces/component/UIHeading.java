/**
 * 
 */
package za.co.sindi.javax.faces.component;

import javax.faces.component.UIComponentBase;

/**
 * @author Bienfait Sindi
 * @since 27 August 2013
 *
 */
public class UIHeading extends UIComponentBase {

	public static final String COMPONENT_FAMILY = "za.co.sindi.faces.Heading";
	
	private enum PropertyKeys {
		element
	}
	
	/**
	 * 
	 */
	public UIHeading() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(null);
	}

	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponent#getFamily()
	 */
	@Override
	public String getFamily() {
		// TODO Auto-generated method stub
		return COMPONENT_FAMILY;
	}

	/**
	 * @return the element
	 */
	public String getElement() {
		return (String) getStateHelper().eval(PropertyKeys.element);
	}

	/**
	 * @param element the element to set
	 */
	public void setElement(String element) {
		getStateHelper().put(PropertyKeys.element, element);
	}
}
