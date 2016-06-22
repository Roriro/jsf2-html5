/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.util.Map;
import java.util.logging.Level;

import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.EditableValueHolder;
import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;

import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 31 July 2013
 *
 */
public abstract class HTML5BaseInputRenderer extends HTML5Renderer {
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#decode(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void decode(FacesContext context, UIComponent component) {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIInput.class);
		
		if (!shouldDecode(component)) {
			return ;
		}
		
		RendererUtils.decodeClientBehaviours(context, component);
		
		Map<String, String> requestMap = context.getExternalContext().getRequestParameterMap();
		String clientId = component.getClientId(context);
		if (clientId != null && requestMap.containsKey(clientId)) { //Though it should never be null
			setSubmittedValue(component, requestMap.get(clientId));
		}
	}
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#getConvertedValue(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		// TODO Auto-generated method stub
		String submittedStringValue = null;
		if (submittedValue != null) {
			if (submittedValue instanceof String) {
				submittedStringValue = (String)submittedValue;
			} else {
				submittedStringValue = submittedValue.toString();
			}
		}
		
		Converter converter = null;
		if (component instanceof ValueHolder) {
			converter = ((ValueHolder)component).getConverter();
		}
		
		if (converter == null) {
			ValueExpression expression = component.getValueExpression("value");
			if (expression != null) {
				Class<?> valueType = expression.getType(context.getELContext());
				if (valueType != null && Object.class != valueType) {
					try {
						converter = context.getApplication().createConverter(valueType);
					} catch (FacesException e) {
						if (LOGGER.isLoggable(Level.SEVERE)) {
							LOGGER.log(Level.SEVERE, "Error creating converter for value type " + valueType.getName(), e);
						}
					}
				}
			}
		}
		
		return (converter == null) ? submittedStringValue : converter.getAsObject(context, component, submittedStringValue);
	}

	protected Object getObjectValue(FacesContext context, UIComponent component) {
		if (!(component instanceof ValueHolder)) {
			throw new IllegalArgumentException("Component: " + RendererUtils.getPathToComponent(component) + " is not a ValueHolder.");
		}

		if (component instanceof EditableValueHolder) {
			EditableValueHolder holder = (EditableValueHolder) component;
			Object value = holder.getSubmittedValue();
			if (value != null) {
				if (value instanceof String) {
					return (String)value;
				}

				throw new IllegalArgumentException("Submitted value is not a String but a type of " + value.getClass().getName() + " (UIComponent: " + RendererUtils.getPathToComponent(component) + ").");
			}
			
			if (holder.isLocalValueSet()) {
				return holder.getLocalValue();
			}
		}
		
		return ((ValueHolder)component).getValue();
	}

	protected String getStringValue(FacesContext context, UIComponent component, Object value) {
		Converter converter = null;
		if (component instanceof ValueHolder) {
			converter = ((ValueHolder)component).getConverter();
		}
		
		if (converter == null) {
			if (value == null) {
				return "";
			}
			
			if (value instanceof String) {
				return (String)value;
			}
			
			try {
				converter = context.getApplication().createConverter(value.getClass());
			} catch (FacesException e) {
				// TODO Auto-generated catch block
				if (LOGGER.isLoggable(Level.SEVERE)) {
					LOGGER.log(Level.SEVERE, "Error creating converter for " + value.getClass().getName() + " (component id: " + component.getClientId(context) + ").", e);
				}
			}
		}
		
		if (converter == null) {
			return value.toString();
		}
		
		return converter.getAsString(context, component, value);
	}
	
	protected void setSubmittedValue(UIComponent component, Object value) {
		if (component instanceof EditableValueHolder) {
			((EditableValueHolder)component).setSubmittedValue(value);
			if (LOGGER.isLoggable(Level.FINE)) {
				LOGGER.fine("Submitted value " + value);
			}
		}
	}
}
