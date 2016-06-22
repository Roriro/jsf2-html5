/**
 * 
 */
package za.co.sindi.jsf.html5.component;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;

/**
 * @author Bienfait Sindi
 * @since 09 September 2013
 *
 */
@FacesComponent(HTML5UISources.COMPONENT_TYPE)
public class HTML5UISources extends UIComponentBase {
	
	/**
     * <p>The standard component type for this component.</p>
     */
    public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.Sources";

    /**
     * <p>The standard component family for this component.</p>
     */
    public static final String COMPONENT_FAMILY = "za.co.sindi.jsf.html5.MediaSources";

    private enum PropertyKeys {
    	value;
    }
    
	/**
	 * 
	 */
	public HTML5UISources() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(null);
	}

	/**
	 * @return the value
	 */
	public Object getValue() {
		return getStateHelper().eval(PropertyKeys.value);
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(Object value) {
		getStateHelper().put(PropertyKeys.value, value);
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
