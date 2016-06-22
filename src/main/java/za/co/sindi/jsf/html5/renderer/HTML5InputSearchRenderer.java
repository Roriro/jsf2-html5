/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import javax.faces.component.UIComponent;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.input.HTML5InputSearch;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;

/**
 * @author Bienfait Sindi
 * @since 19 August 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = HTML5InputSearch.RENDERER_TYPE)
public class HTML5InputSearchRenderer extends HTML5InputRenderer {
	
	private static final String[] INPUT_SEARCH_ATTRIBUTES = {
		HTML5Attributes.MAXLENGTH,
		HTML5Attributes.READONLY,
		HTML5Attributes.SIZE,
		HTML5Attributes.AUTOCOMPLETE,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.REQUIRED,
		HTML5Attributes.LIST,
		HTML5Attributes.PATTERN,
		HTML5Attributes.PLACEHOLDER,
		HTML5Attributes.DIRNAME,
	};

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getInputType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getInputType(UIComponent component) {
		// TODO Auto-generated method stub
		return "search";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return INPUT_SEARCH_ATTRIBUTES;
	}
}
