/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 * @author Bienfait Sindi
 * @since 22 August 2013
 *
 */
@FacesConverter(CalendarConverter.CONVERTER_ID)
public class CalendarConverter extends AbstractConverter {
	
	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.CalendarConverter";

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Calendar calendar = null;
		try {
			XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(value);
			if (xmlGregorianCalendar != null) {
				calendar = xmlGregorianCalendar.toGregorianCalendar(); //.getTime();
			}
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			throw new ConverterException("Error converting value '" + value + "'", e);
		}
		
		return calendar;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		GregorianCalendar gregorianCalendar = null;
		if (value instanceof GregorianCalendar) {
			gregorianCalendar = (GregorianCalendar)gregorianCalendar;
		} else {
			gregorianCalendar = new GregorianCalendar();
			gregorianCalendar.clear();
			if (value instanceof Date) {
				gregorianCalendar.setTime((Date)value);
			} else if (value instanceof Long) {
				gregorianCalendar.setTime(new Date((Long)value));
			} else {
				throw new IllegalArgumentException("Value " + String.valueOf(value) + " cannot be converter to a valid Calendar object.");
			}
		}
		
		try {
			return DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar).toString().toUpperCase();
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			throw new ConverterException("Error formatting value " + String.valueOf(value) + " to String.", e);
		}
	}
}
