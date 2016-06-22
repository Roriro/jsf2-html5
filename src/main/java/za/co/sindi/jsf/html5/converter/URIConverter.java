/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import java.net.URI;
import java.net.URISyntaxException;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesConverter(URIConverter.CONVERTER_ID)
public class URIConverter extends AbstractConverter {

	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.URIConverter";
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		try {
			return new URI(value);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			throw new ConverterException("Error converting to URI.", e);
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		if (!(value instanceof URI)) {
			throw new IllegalArgumentException(String.valueOf(value) + " is not an instance of " + URI.class.getName());
		}
		
		return ((URI)value).toString();
	}
}
