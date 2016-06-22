/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import javax.faces.component.UIComponent;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.command.HTML5Button;

/**
 * @author Bienfait Sindi
 * @since 21 July 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Command", rendererType = HTML5Button.RENDERER_TYPE)
public class HTML5CommandButtonRenderer extends HTML5ButtonRenderer {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5CommandRenderer#getButtonType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getButtonType(UIComponent component) {
		// TODO Auto-generated method stub
//		return (String) component.getAttributes().get(HTML5Attributes.TYPE);
		return "button";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5CommandRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
}
