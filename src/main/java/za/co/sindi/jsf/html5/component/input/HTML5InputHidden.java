/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIInput;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputHidden.COMPONENT_TYPE)
public class HTML5InputHidden extends HTML5UIInput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputHidden";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputHidden";
	
	/**
	 * 
	 */
	public HTML5InputHidden() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
}
