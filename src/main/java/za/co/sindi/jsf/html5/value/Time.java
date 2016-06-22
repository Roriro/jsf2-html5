/**
 * 
 */
package za.co.sindi.jsf.html5.value;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * A valid <i>partial-time</i> as defined in <a href="http://tools.ietf.org/html/rfc3339">RFC3339</a>.
 * 
 * @author Bienfait Sindi
 * @since 04 August 2013
 *
 */
public interface Time extends Serializable {

	public static final Pattern PATTERN = Pattern.compile("^([0-1][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])(\\.\\d+)?$");
	
	public int getHour();
	
	public int getMinute();
	
	public int getSecond();
	
	public BigDecimal getFractionalSecond();
}
