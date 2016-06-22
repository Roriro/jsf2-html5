/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import java.math.BigDecimal;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import za.co.sindi.jsf.html5.value.Time;
import za.co.sindi.jsf.html5.value.impl.TimeImpl;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesConverter(TimeConverter.CONVERTER_ID)
public class TimeConverter extends AbstractConverter {

	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.TimeConverter";
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return new TimeImpl(value);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (!(value instanceof Time)) {
			throw new IllegalArgumentException(String.valueOf(value) + " is not an instance of " + Time.class.getName());
		}
		
		Time time = (Time)value;
		StringBuffer sb = new StringBuffer();
		sb.append(String.format("%02d", time.getHour()) + ":" + String.format("%02d", time.getMinute()) + String.format("%02d", time.getSecond()));
		if (time.getFractionalSecond() != null && time.getFractionalSecond().compareTo(BigDecimal.ZERO) > 0) {
			sb.append(".").append(time.getFractionalSecond());
		}
		return sb.toString();
	}
}
