/**
 * 
 */
package za.co.sindi.jsf.html5.component;

/**
 * @author Bienfait Sindi
 * @since 27 July 2013
 *
 */
public interface HTML5UIButton {

	/**
	 * @return the disabled
	 */
	public boolean isDisabled();

	/**
	 * @param disabled the disabled to set
	 */
	public void setDisabled(boolean disabled);

	/**
	 * @return the form
	 */
	public String getForm();

	/**
	 * @param form the form to set
	 */
	public void setForm(String form);

	/**
	 * @return the autofocus
	 */
	public boolean isAutofocus();

	/**
	 * @param autofocus the autofocus to set
	 */
	public void setAutofocus(boolean autofocus);
	
	/**
	 * This tells the renderer to use &lt;button&gt; instead of the usual &lt;input type="button" /&gt;.
	 * @return
	 */
	public boolean isUseButtonElement();
	
	public void setUseButtonElement(boolean useButtonElement);
}
