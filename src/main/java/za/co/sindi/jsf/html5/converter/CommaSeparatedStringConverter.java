/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

/**
 * @author Bienfait Sindi
 * @since 02 September 2013
 *
 */
@FacesConverter(CommaSeparatedStringConverter.CONVERTER_ID)
public class CommaSeparatedStringConverter extends AbstractConverter {

	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.CommaSeparatedStringConverter";
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		if (value instanceof String) {
			String[] values = value.split(",");
			if (values != null) {
				if (values.length > 1) {
					return values;
				}
			}
		}
		
		return value;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (value instanceof String[]) {
			StringBuffer sb = new StringBuffer();
			for (String v : (String[])value) {
				if (sb.length() > 0) {
					sb.append(",");
				}
				
				sb.append(v);
			}
			
			return sb.toString();
		}
		
		return value.toString();
	}
}
