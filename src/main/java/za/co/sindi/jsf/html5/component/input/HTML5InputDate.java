/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UInputDateTime;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputDate.COMPONENT_TYPE)
public class HTML5InputDate extends HTML5UInputDateTime {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputDate";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputDate";
	
	/**
	 * 
	 */
	public HTML5InputDate() {
		super(RENDERER_TYPE, "yyyy-MM-dd", null);
		// TODO Auto-generated constructor stub
	}
}
