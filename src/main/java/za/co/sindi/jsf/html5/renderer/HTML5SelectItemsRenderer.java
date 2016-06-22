/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Collection;
import java.util.Iterator;
import java.util.logging.Level;

import javax.el.ValueExpression;
import javax.faces.FacesException;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectMany;
import javax.faces.component.UISelectOne;
import javax.faces.component.ValueHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.utils.SelectItemsIterator;

/**
 * @author Bienfait Sindi
 * @since 29 August 2013
 *
 */
public abstract class HTML5SelectItemsRenderer extends HTML5Renderer {

	protected static final String OPTION_ELEMENT_NAME = HTML5Elements.OPTION;
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		super.encodeEnd(context, component);
		final ResponseWriter writer = context.getResponseWriter();
		
		//Begin
		renderStartElement(context, component, writer);
		
		//Select items.
		renderSelectItems(context, component, writer, getSelectItems(context, component));
		
		//End
		renderEndElement(context, component, writer);
	}
	
	protected Converter getConverter(FacesContext context, UIComponent component) {
		Converter converter = null;
		if (component instanceof ValueHolder) {
			converter = ((ValueHolder)component).getConverter();
		}
		
		if (converter == null) {
			ValueExpression expression = component.getValueExpression("value");
			if (expression != null) {
				Class<?> classType = expression.getType(context.getELContext());
				if (classType != null) {
					try {
						converter = context.getApplication().createConverter(classType);
					} catch (FacesException e) {
						if (LOGGER.isLoggable(Level.SEVERE)) {
							LOGGER.log(Level.SEVERE, "Error when creating converter for value type " + classType.getName(), e);
						}
					}
				}
			}
		}
		
		return converter;
	}
	
	protected Iterator<SelectItem> getSelectItems(FacesContext context, UIComponent component) {
		return new SelectItemsIterator(context, component);
	}
	
	protected Object[] getSelectedValues(UIComponent component) {
		Object[] values = null;
		
		if (component instanceof UISelectMany) {
			Object value = ((UISelectMany)component).getValue();
			if (value == null) {
				return null;
			}
			
			if (value instanceof Collection) {
				return ((Collection<?>)value).toArray();
			}
			
			if (value.getClass().isArray()) {
				if (Array.getLength(value) == 0) {
					return null;
				}
			} else {
				if (LOGGER.isLoggable(Level.WARNING)) {
					LOGGER.log(Level.WARNING, "UISelectMany value is neither a collection nor an array. It's actual type is " + value.getClass().getName());
				}
			}
			
			values = (Object[]) value;
		}
		
		if (component instanceof UISelectOne) {
			Object value = ((UISelectOne)component).getValue();
			if (value == null) {
				return null;
			} else {
				values = new Object[] { value };
			}
		}
		
		return values;
	}
	
	protected Object[] getSubmittedValues(UIComponent component) {
		if (component instanceof UISelectMany) {
			return (Object[]) ((UISelectMany)component).getSubmittedValue();
		}
		
		return new Object[] { ((UISelectOne)component).getSubmittedValue() };
	}
	
	protected abstract void renderStartElement(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException;
	protected abstract void renderEndElement(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException;
	protected abstract void renderSelectItems(FacesContext context, UIComponent component, ResponseWriter writer, Iterator<SelectItem> selectItemIterator) throws IOException;
}
