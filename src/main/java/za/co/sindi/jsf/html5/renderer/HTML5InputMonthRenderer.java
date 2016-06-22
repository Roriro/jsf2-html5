/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.input.HTML5InputMonth;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;

/**
 * @author Bienfait Sindi
 * @since 19 August 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = HTML5InputMonth.RENDERER_TYPE)
public class HTML5InputMonthRenderer extends HTML5InputRenderer {
	
	private static final String[] INPUT_MONTH_ATTRIBUTES = {
		HTML5Attributes.READONLY,
		HTML5Attributes.AUTOCOMPLETE,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.REQUIRED,
		HTML5Attributes.LIST,
		HTML5Attributes.STEP
	};

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#renderAdditionalAttributes(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderAdditionalAttributes(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		Object value = component.getAttributes().get(HTML5Attributes.MIN);
		if (value != null) {
			//min attribute
			writer.writeAttribute(HTML5Attributes.MIN, getStringValue(context, component, value), HTML5Attributes.MIN);
		}
		
		value = component.getAttributes().get(HTML5Attributes.MAX);
		if (value != null) {
			//max attribute
			writer.writeAttribute(HTML5Attributes.MAX, getStringValue(context, component, value), HTML5Attributes.MAX);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getInputType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getInputType(UIComponent component) {
		// TODO Auto-generated method stub
		return "month";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return INPUT_MONTH_ATTRIBUTES;
	}
}
