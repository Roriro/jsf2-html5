/**
 * 
 */
package za.co.sindi.jsf.html5.value;

import java.io.Serializable;
import java.util.regex.Pattern;

/**
 * @author Bienfait Sindi
 * @since 05 August 2013
 *
 */
public interface Color extends Serializable {

	public static final Pattern PATTERN = Pattern.compile("^#[0-9a-fA-F]{6}$");
	
	public int getRed();
	
	public int getBlue();
	
	public int getGreen();
	
	public int getRGB();
}
