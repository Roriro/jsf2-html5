/**
 * 
 */
package za.co.sindi.jsf.html5.component.heading;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIHeading;

/**
 * @author Bienfait Sindi
 * @since 27 August 2013
 *
 */
@FacesComponent(HTML5Heading.COMPONENT_TYPE)
public class HTML5Heading extends HTML5UIHeading {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Heading";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Heading";
	
	/**
	 * 
	 */
	public HTML5Heading() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
}
