/**
 * 
 */
package za.co.sindi.jsf.html5.component;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIComponentBase;

/**
 * @author Bienfait Sindi
 * @since 09 September 2013
 *
 */
@FacesComponent(HTML5UISource.COMPONENT_TYPE)
public class HTML5UISource extends HTML5UIComponentBase {

	/**
     * <p>The standard component type for this component.</p>
     */
    public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.Source";

    /**
     * <p>The standard component family for this component.</p>
     */
    public static final String COMPONENT_FAMILY = "za.co.sindi.jsf.html5.MediaSource";
    
    private enum PropertyKeys {
    	value,
    	library,
    	name,
    	type,
    	media
    }
    
	/**
	 * 
	 */
	public HTML5UISource() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(null);
	}

	/**
	 * @return the value
	 */
	public String getValue() {
		return (String) getStateHelper().eval(PropertyKeys.value);
	}

	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		getStateHelper().put(PropertyKeys.value, value);
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
	 * @return the type
	 */
	public String getType() {
		return (String) getStateHelper().eval(PropertyKeys.type);
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		getStateHelper().put(PropertyKeys.type, type);
	}

	/**
	 * @return the media
	 */
	public String getMedia() {
		return (String) getStateHelper().eval(PropertyKeys.media);
	}

	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		getStateHelper().put(PropertyKeys.media, media);
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
