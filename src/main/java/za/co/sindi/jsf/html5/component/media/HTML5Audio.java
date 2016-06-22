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
@FacesComponent(HTML5Audio.COMPONENT_TYPE)
public class HTML5Audio extends HTML5UIMedia {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Audio";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Audio";
	
	/**
	 * 
	 */
	public HTML5Audio() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}	
}
