/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.input.HTML5InputEmail;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 19 August 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = HTML5InputEmail.RENDERER_TYPE)
public class HTML5InputEmailRenderer extends HTML5InputRenderer {
	
	private static final String[] INPUT_EMAIL_ATTRIBUTES = {
		HTML5Attributes.MAXLENGTH,
		HTML5Attributes.READONLY,
		HTML5Attributes.SIZE,
		HTML5Attributes.AUTOCOMPLETE,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.REQUIRED,
		HTML5Attributes.LIST,
		HTML5Attributes.PATTERN,
		HTML5Attributes.PLACEHOLDER,
		HTML5Attributes.MULTIPLE
	};

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#renderAdditionalAttributes(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderAdditionalAttributes(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		Object value = component.getAttributes().get(HTML5Attributes.MULTIPLE);
		if (value != null && !RendererUtils.isDefaultAttributeValue(value)) {
			//multiple attribute
			writer.writeAttribute(HTML5Attributes.MULTIPLE, HTML5Attributes.MULTIPLE, null);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getInputType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getInputType(UIComponent component) {
		// TODO Auto-generated method stub
		return "email";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return INPUT_EMAIL_ATTRIBUTES;
	}
}
