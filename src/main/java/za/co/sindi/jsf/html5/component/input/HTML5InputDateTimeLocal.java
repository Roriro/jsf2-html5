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
@FacesComponent(HTML5InputDateTimeLocal.COMPONENT_TYPE)
public class HTML5InputDateTimeLocal extends HTML5UInputDateTime {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputDateTimeLocal";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputDateTimeLocal";
	
	/**
	 * 
	 */
	public HTML5InputDateTimeLocal() {
		super(RENDERER_TYPE, "yyyy-MM-dd'T'HH:mm:ss", null);
		// TODO Auto-generated constructor stub
	}
}
