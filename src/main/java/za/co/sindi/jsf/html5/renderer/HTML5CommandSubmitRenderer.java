/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.command.HTML5ButtonSubmit;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;

/**
 * @author Bienfait Sindi
 * @since 21 July 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Command", rendererType = HTML5ButtonSubmit.RENDERER_TYPE)
public class HTML5CommandSubmitRenderer extends HTML5ButtonRenderer {

	private static final String[] BUTTON_SUBMIT_ATTRIBUTES = {
		HTML5Attributes.FORMACTION,
		HTML5Attributes.FORMENCTYPE,
		HTML5Attributes.FORMMETHOD,
		HTML5Attributes.FORMTARGET
	};
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5ButtonRenderer#renderAdditionalPassthroughAttributes(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	protected void renderAdditionalPassthroughAttributes(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		ResponseWriter writer = context.getResponseWriter();
		boolean formnovalidate = (Boolean) component.getAttributes().get(HTML5Attributes.FORMNOVALIDATE);
		if (formnovalidate) {
			writer.writeAttribute(HTML5Attributes.FORMNOVALIDATE, HTML5Attributes.FORMNOVALIDATE, null);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5CommandRenderer#getButtonType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getButtonType(UIComponent component) {
		// TODO Auto-generated method stub
		return "submit";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5CommandRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return BUTTON_SUBMIT_ATTRIBUTES;
	}
}
