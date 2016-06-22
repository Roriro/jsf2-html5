/**
 * 
 */
package za.co.sindi.jsf.html5.component.form;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIForm;

/**
 * @author Bienfait Sindi
 * @since 09 July 2013
 *
 */
@FacesComponent(HTML5Form.COMPONENT_TYPE)
public class HTML5Form extends HTML5UIForm {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Form";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Form";
	
	protected enum PropertyKeys {
		enctype,
		acceptcharset,
		novalidate,
		target,
		autocomplete
	}
	
	/**
	 * 
	 */
	public HTML5Form() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
		setEnctype("application/x-www-form-urlencoded");
//		setMethod("post");
	}

//	/**
//	 * @return the method
//	 */
//	public String getMethod() {
//		return (String) getStateHelper().eval(PropertyKeys.method, "post");
//	}
//	
//	/**
//	 * @param method the method to set
//	 */
//	public void setMethod(String method) {
//		getStateHelper().put(PropertyKeys.method, method);
//	}
	
	/**
	 * @return the enctype
	 */
	public String getEnctype() {
		return (String) getStateHelper().eval(PropertyKeys.enctype, "application/x-www-form-urlencoded");
	}
	
	/**
	 * @param enctype the enctype to set
	 */
	public void setEnctype(String enctype) {
		getStateHelper().put(PropertyKeys.enctype, enctype);
	}
	
	/**
	 * @return the acceptcharset
	 */
	public String getAcceptcharset() {
		return (String) getStateHelper().eval(PropertyKeys.acceptcharset);
	}
	
	/**
	 * @param acceptcharset the acceptcharset to set
	 */
	public void setAcceptcharset(String acceptcharset) {
		getStateHelper().put(PropertyKeys.acceptcharset, acceptcharset);
	}
	
	/**
	 * @return the novalidate
	 */
	public String getNovalidate() {
		return (String) getStateHelper().eval(PropertyKeys.novalidate);
	}
	
	/**
	 * @param novalidate the novalidate to set
	 */
	public void setNovalidate(String novalidate) {
		getStateHelper().put(PropertyKeys.novalidate, novalidate);
	}
	
	/**
	 * @return the target
	 */
	public String getTarget() {
		return (String) getStateHelper().eval(PropertyKeys.target);
	}
	
	/**
	 * @param target the target to set
	 */
	public void setTarget(String target) {
		getStateHelper().put(PropertyKeys.target, target);
	}
	
	/**
	 * @return the autocomplete
	 */
	public String getAutocomplete() {
		return (String) getStateHelper().eval(PropertyKeys.autocomplete);
	}
	
	/**
	 * @param autocomplete the autocomplete to set
	 */
	public void setAutocomplete(String autocomplete) {
		getStateHelper().put(PropertyKeys.autocomplete, autocomplete);
	}
}
