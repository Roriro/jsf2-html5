/**
 * 
 */
package za.co.sindi.jsf.html5.component.ext;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIExtensions;

/**
 * @author Bienfait Sindi
 * @since 27 August 2013
 *
 */
@FacesComponent(HTML5DataList.COMPONENT_TYPE)
public class HTML5DataList extends HTML5UIExtensions {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5DataList";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.DataList";
	
	/**
	 * 
	 */
	public HTML5DataList() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
}
