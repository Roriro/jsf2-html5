/**
 * 
 */
package za.co.sindi.servlet;

import java.util.Enumeration;
import java.util.Map;

/**
 * @author Bienfait Sindi
 * @since 05 September 2013
 *
 */
public interface MultipartRequestHandler {

	public MultipartFile getFile(String name);
	public Map<String, MultipartFile[]> getFileMap();
	public Enumeration<String> getFileNames();
	public MultipartFile[] getFiles(String name);
}
