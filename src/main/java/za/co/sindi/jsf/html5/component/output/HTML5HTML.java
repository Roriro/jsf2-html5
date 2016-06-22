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
@FacesComponent(HTML5HTML.COMPONENT_TYPE)
public class HTML5HTML extends HTML5UIOutput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5HTML";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.HTML";
//	private String manifest;
	
	protected enum PropertyKeys {
		manifest
	}
	
	/**
	 * 
	 */
	public HTML5HTML() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}
	
	/**
	 * @return the manifest
	 */
	public String getManifest() {
		return (String) getStateHelper().eval(PropertyKeys.manifest);
	}

	/**
	 * @param manifest the manifest to set
	 */
	public void setManifest(String manifest) {
		getStateHelper().put(PropertyKeys.manifest, manifest);
	}
}
