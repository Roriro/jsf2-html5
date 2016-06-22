/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UInputDateTime;
import za.co.sindi.jsf.html5.converter.CalendarConverter;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputDateTime.COMPONENT_TYPE)
public class HTML5InputDateTime extends HTML5UInputDateTime {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputDateTime";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.InputDateTime";
	
	/**
	 * 
	 */
	public HTML5InputDateTime() {
//		super(RENDERER_TYPE, "yyyy-MM-dd'T'HH:mm.ss.SSS'Z'", TimeZone.getTimeZone("UTC"));
		super(RENDERER_TYPE, new CalendarConverter());
		// TODO Auto-generated constructor stub
	}
}
