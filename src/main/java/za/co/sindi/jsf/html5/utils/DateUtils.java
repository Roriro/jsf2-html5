/**
 * 
 */
package za.co.sindi.jsf.html5.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * @author Bienfait Sindi
 * @since 20 August 2013
 *
 */
public final class DateUtils {

	private DateUtils() {
		//Nothing...
	}
	
	public static Date parse(String dateString, String pattern) throws ParseException {
		return parse(dateString, pattern, null);
	}
	
	public static Date parse(String dateString, String pattern, TimeZone timeZone) throws ParseException {
		DateFormat format = new SimpleDateFormat(pattern);
		if (timeZone != null) {
			format.setTimeZone(timeZone);
		}
		format.setLenient(false);
		return format.parse(dateString);
	}
}
