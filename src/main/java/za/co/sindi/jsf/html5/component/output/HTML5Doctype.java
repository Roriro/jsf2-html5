/**
 * 
 */
package za.co.sindi.jsf.html5.component.output;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIOutput;

/**
 * @author Bienfait Sindi
 * @since 24 April 2013
 *
 */
@FacesComponent(HTML5Doctype.COMPONENT_TYPE)
public class HTML5Doctype extends UIOutput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Doctype";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Doctype";
	
	/**
	 * 
	 */
	public HTML5Doctype() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
}
