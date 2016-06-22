/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import javax.faces.component.UIComponent;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.HTML5InputRange;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;

/**
 * @author Bienfait Sindi
 * @since 02 September 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = HTML5InputRange.RENDERER_TYPE)
public class HTML5InputRangeRenderer extends HTML5InputRenderer {

	private static final String[] INPUT_RANGE_ATTRIBUTES = {
		HTML5Attributes.AUTOCOMPLETE,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.LIST,
		HTML5Attributes.MIN,
		HTML5Attributes.MAX,
		HTML5Attributes.STEP
	};
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getInputType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getInputType(UIComponent component) {
		// TODO Auto-generated method stub
		return "range";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return INPUT_RANGE_ATTRIBUTES;
	}
}
