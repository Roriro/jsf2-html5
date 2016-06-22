/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import javax.faces.component.UIComponent;
import javax.faces.component.UIOutput;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.media.HTML5Audio;

/**
 * @author Bienfait Sindi
 * @since 10 September 2013
 *
 */
@FacesRenderer(componentFamily=UIOutput.COMPONENT_FAMILY, rendererType=HTML5Audio.RENDERER_TYPE)
public class HTML5AudioRenderer extends HTML5MediaRenderer {

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5MediaRenderer#getElementName(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getElementName(UIComponent component) {
		// TODO Auto-generated method stub
		return "audio";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5MediaRenderer#getAdditionalPassthroughAttributes()
	 */
	@Override
	protected String[] getAdditionalPassthroughAttributes() {
		// TODO Auto-generated method stub
		return null;
	}
}
