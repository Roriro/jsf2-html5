/**
 * 
 */
package za.co.sindi.jsf.html5.value;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * @author Bienfait Sindi
 * @since 04 August 2013
 *
 */
public interface Month extends Serializable {

	public static final Pattern PATTERN = Pattern.compile("^[0-9]{3}[1-9]-(0[1-9]|1[0-2])$");
	
	public int getYear();
	
	public int getMonth();
}
