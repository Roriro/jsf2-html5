/**
 * 
 */
package za.co.sindi.jsf.html5.component.media;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIMedia;

/**
 * @author Bienfait Sindi
 * @since 06 September 2013
 *
 */
@FacesComponent(HTML5Video.COMPONENT_TYPE)
public class HTML5Video extends HTML5UIMedia {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Video";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Video";
	
	/**
	 * 
	 */
	public HTML5Video() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}

	private enum PropertyKeys {
		poster,
		height,
		width
	}
	
	/**
	 * @return the poster
	 */
	public String getPoster() {
		return (String) getStateHelper().eval(PropertyKeys.poster);
	}
	
	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		getStateHelper().put(PropertyKeys.poster, poster);
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
