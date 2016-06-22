/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesConverter(URLConverter.CONVERTER_ID)
public class URLConverter extends AbstractConverter {

	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.URLConverter";
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		try {
			return new URL(value);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			throw new ConverterException("Error converting to URL.", e);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (!(value instanceof URL)) {
			throw new IllegalArgumentException(String.valueOf(value) + " is not an instance of " + URL.class.getName());
		}
		
		try {
			return ((URL)value).toURI().toString();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new ConverterException("Error converting URL to String.", e);
		}
	}
}
