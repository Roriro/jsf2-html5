/**
 * 
 */
package za.co.sindi.jsf.html5.component.output;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIOutput;


/**
 * @author Bienfait Sindi
 * @since 09 February 2015
 *
 */
@FacesComponent(HTML5Div.COMPONENT_TYPE)
public class HTML5Div extends HTML5UIOutput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Div";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Div";
	
	/**
	 * 
	 */
	public HTML5Div() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
}
