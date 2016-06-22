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
public class UIExtensions extends UIComponentBase {

	public static final String COMPONENT_FAMILY = "za.co.sindi.faces.Extensions";
	
	/**
	 * 
	 */
	public UIExtensions() {
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
}
