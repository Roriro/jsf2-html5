/**
 * 
 */
package za.co.sindi.jsf.html5.utils;

/**
 * @author Bienfait Sindi
 * @since 04 May 2013
 *
 */
public final class StringUtils {

	private StringUtils() {
		//TODO: Nothing
	}

	public static boolean isNullOrEmpty(String s) {
		return (ObjectUtils.isNull(s) || s.isEmpty());
	}
}
