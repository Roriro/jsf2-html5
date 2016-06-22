/**
 * 
 */
package za.co.sindi.jsf.html5.value;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * This value returns a Week number within a given year. 
 * This can be compared to Java's Calendar.WEEK_OF_YEAR.
 * 
 * @author Bienfait Sindi
 * @since 05 August 2013
 *
 */
public interface Week extends Serializable {

	public static final Pattern PATTERN = Pattern.compile("^[0-9]{3}[1-9]\\Q-W\\E(0[1-9]|[1-4][0-9]|5[0-3])$");

	public int getYear();
	
	public int getWeek();
}
