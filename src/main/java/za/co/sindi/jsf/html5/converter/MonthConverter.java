/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import za.co.sindi.jsf.html5.value.Month;
import za.co.sindi.jsf.html5.value.impl.MonthImpl;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesConverter(MonthConverter.CONVERTER_ID)
public class MonthConverter extends AbstractConverter {

	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.MonthConverter";
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return new MonthImpl(value);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (!(value instanceof Month)) {
			throw new IllegalArgumentException(String.valueOf(value) + " is not an instance of " + Month.class.getName());
		}
		
		Month month = (Month)value;
		return String.format("%04d", month.getYear()) + "-" + String.format("%02d", month.getMonth());
	}
}
