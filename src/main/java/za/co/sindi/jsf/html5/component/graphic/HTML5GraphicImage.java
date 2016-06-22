/**
 * 
 */
package za.co.sindi.jsf.html5.component.graphic;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIGraphic;

/**
 * @author Bienfait Sindi
 * @since 07 September 2013
 *
 */
@FacesComponent(HTML5GraphicImage.COMPONENT_TYPE)
public class HTML5GraphicImage extends HTML5UIGraphic {
	
	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5GraphicImage";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Image";

	private enum PropertyKeys {
		library,
		name,
		alt,
		height,
		width,
		usemap,
		ismap
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
	
	/**
	 * @return the usemap
	 */
	public String getUsemap() {
		return (String) getStateHelper().eval(PropertyKeys.usemap);
	}
	
	/**
	 * @param usemap the usemap to set
	 */
	public void setUsemap(String usemap) {
		getStateHelper().put(PropertyKeys.usemap, usemap);
	}
	
	/**
	 * @return the ismap
	 */
	public boolean isIsmap() {
		return (Boolean) getStateHelper().eval(PropertyKeys.ismap, false);
	}
	
	/**
	 * @param ismap the ismap to set
	 */
	public void setIsmap(boolean ismap) {
		getStateHelper().put(PropertyKeys.ismap, ismap);
	}
}
