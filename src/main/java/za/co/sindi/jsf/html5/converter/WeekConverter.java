/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import za.co.sindi.jsf.html5.value.Week;
import za.co.sindi.jsf.html5.value.impl.WeekImpl;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesConverter(WeekConverter.CONVERTER_ID)
public class WeekConverter extends AbstractConverter {

	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.WeekConverter";
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		return new WeekImpl(value);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (!(value instanceof Week)) {
			throw new IllegalArgumentException(String.valueOf(value) + " is not an instance of " + Week.class.getName());
		}
		
		Week week = (Week)value;
		return String.format("%04d", week.getYear()) + "-W" + String.format("%02d", week.getWeek());
	}
}
