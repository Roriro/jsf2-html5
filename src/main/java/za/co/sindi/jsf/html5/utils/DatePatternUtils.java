/**
 * 
 */
package za.co.sindi.jsf.html5.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.TimeZone;
import java.util.Map.Entry;

/**
 * This only determines the possible date patterns used by HTML5.
 * Shout-out to Bauke Scholtz (@balusc) for <a href="http://balusc.blogspot.com/2007/09/dateutil.html">this blog.</a>
 * 
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
public final class DatePatternUtils {

	private static final String T_PATTERN = "(T)";
	private static final String Z_PATTERN = "(Z)";
	private static final String TIME_NUMOFFSET_PATTERN = "[+-]([0-1][0-9]|2[0-3]):([0-5][0-9])";
	
	private static final String DATE_PATTERN = "\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[1-2])";
	private static final String TIME_PATTERN = "([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])";
//	private static final String PARTIAL_TIME_PATTERN = TIME_PATTERN + "(\\.\\d+)";

	private static final Map<String, String> DATE_FORMAT_PATTERN;
	
	static {
		Map<String, String> dateFormatPattern = new HashMap<String, String>();
		//Date
		dateFormatPattern.put("^" + DATE_PATTERN + "$", "yyy-MM-dd");
		
		//Datetime
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d)$", "yyyy-MM-dd'T'HH:mm:ss.S");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d{2})$", "yyyy-MM-dd'T'HH:mm:ss.SS");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d{3})$", "yyyy-MM-dd'T'HH:mm:ss.SSS");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + Z_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss'Z'");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d)" + Z_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss.S'Z'");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d{2})" + Z_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss.SS'Z'");
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d{3})" + Z_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");		
		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + TIME_NUMOFFSET_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ssZ");
		//Disabling as we are using XMLGregorianCalendar.
//		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d)" + TIME_NUMOFFSET_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss.SZ");
//		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d{2})" + TIME_NUMOFFSET_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss.SSZ");
//		dateFormatPattern.put("^" + DATE_PATTERN + T_PATTERN + TIME_PATTERN + "(\\.\\d{3})" + TIME_NUMOFFSET_PATTERN + "$", "yyyy-MM-dd'T'HH:mm:ss.SSSZ");
		
		DATE_FORMAT_PATTERN = Collections.unmodifiableMap(dateFormatPattern);
	}
	
	/**
	 * 
	 */
	private DatePatternUtils() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static String determineDatePattern(String dateString) {
		if (dateString != null) {		
			for (Entry<String, String> entry : DATE_FORMAT_PATTERN.entrySet()) {
				if (dateString.matches(entry.getKey())) {
					return entry.getValue();
				}
			}
		}
		
		return null;
	}
	
	public static String format(Date date, String pattern) {
		return format(date, pattern, null);
	}
	
	public static String format(Date date, String pattern, TimeZone timeZone) {
		DateFormat format = new SimpleDateFormat(pattern);
		if (timeZone != null) {
			format.setTimeZone(timeZone);
		}
		format.setLenient(false);
		return format.format(date);
	}
}
