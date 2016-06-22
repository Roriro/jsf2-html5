/**
 * 
 */
package za.co.sindi.jsf.html5.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import java.util.logging.Level;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import za.co.sindi.jsf.html5.utils.DatePatternUtils;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
@FacesConverter(DateTimeConverter.CONVERTER_ID)
public class DateTimeConverter extends AbstractConverter {
	
	public static final String CONVERTER_ID = "za.co.sindi.jsf.html5.converter.DateTimeConverter";
	private String pattern;
	private Locale locale;
	private TimeZone timeZone;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToObject(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.String)
	 */
	@Override
	protected Object convertToObject(FacesContext context, UIComponent component, String value) {
		// TODO Auto-generated method stub
		Date date = null;
		try {
			if (value != null) {
				if (pattern == null) {
					pattern = DatePatternUtils.determineDatePattern(value);
				}
				if (pattern == null) {
					throw new ConverterException("Could not determine date format pattern for value '" + value + "'.");
				}
				
				StringBuffer sb = new StringBuffer();
				if (value.charAt(value.length() - 1) != 'Z' && value.length() > 10) {
					char offsetIndicator = sb.charAt(value.length() - 6);
					if ((offsetIndicator == '+' || offsetIndicator == '-') && value.charAt(value.length() - 3) == ':') {
						sb.append(value.substring(0, value.length() - 3)).append(value.substring(value.length() - 2));
					}
				} else {
					sb.append(value);
				}
				
				if (LOGGER.isLoggable(Level.INFO)) {
					LOGGER.info("Parsing date " + sb.toString() + " with date pattern " + pattern + ".");
				}
				
				DateFormat df = (locale == null) ? new SimpleDateFormat(pattern) : new SimpleDateFormat(pattern, locale);
				
				if (timeZone != null) {
					df.setTimeZone(timeZone);
				}
				df.setLenient(false);
				date = df.parse(sb.toString());
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			throw new ConverterException("Error converting date '" + value + "'", e);
		}
		
		return date;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.converter.AbstractConverter#convertToString(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	protected String convertToString(FacesContext context, UIComponent component, Object value) {
		// TODO Auto-generated method stub
		Date date = null;
		if (value instanceof Date) {
			date = (Date) value;
		} else if (value instanceof Calendar) {
			date = ((Calendar)value).getTime();
		} else if (value instanceof Long) {
			date = new Date((Long)value);
		} else {
			throw new IllegalArgumentException("Value " + String.valueOf(value) + " cannot be converter to a valid Date object.");
		}
		
		DateFormat df = new SimpleDateFormat(pattern, getLocale(context));
		if (timeZone != null) {
			df.setTimeZone(timeZone);
		}
		df.setLenient(false);
		String dateString = df.format(date);
		StringBuffer sb = new StringBuffer();
		if (dateString.charAt(dateString.length() - 1) != 'Z' && dateString.length() > 10) {
			char offsetIndicator = sb.charAt(dateString.length() - 6);
			if ((offsetIndicator == '+' || offsetIndicator == '-') && dateString.charAt(dateString.length() - 3) == ':') {
				sb.append(dateString.substring(0, dateString.length() - 3)).append(dateString.substring(dateString.length() - 2));
			}
		} else {
			sb.append(dateString);
		}
		
		return sb.toString();
	}
	
	private Locale getLocale(FacesContext context) {
		if (locale == null) {
			locale = context.getViewRoot().getLocale();
		}
		
		return locale;
	}

	/**
	 * @return the pattern
	 */
	public String getPattern() {
		return pattern;
	}

	/**
	 * @param pattern the pattern to set
	 */
	public void setPattern(String pattern) {
		this.pattern = pattern;
	}

	/**
	 * @return the locale
	 */
	public Locale getLocale() {
		return locale;
	}

	/**
	 * @param locale the locale to set
	 */
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	/**
	 * @return the timeZone
	 */
	public TimeZone getTimeZone() {
		return timeZone;
	}

	/**
	 * @param timeZone the timeZone to set
	 */
	public void setTimeZone(TimeZone timeZone) {
		this.timeZone = timeZone;
	}
}
