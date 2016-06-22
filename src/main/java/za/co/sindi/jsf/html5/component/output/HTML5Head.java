/**
 * 
 */
package za.co.sindi.jsf.html5.component.output;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIOutput;


/**
 * @author Bienfait Sindi
 * @since 29 April 2013
 *
 */
@FacesComponent(HTML5Head.COMPONENT_TYPE)
public class HTML5Head extends HTML5UIOutput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Head";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Head";
	
	/**
	 * 
	 */
	public HTML5Head() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
}
