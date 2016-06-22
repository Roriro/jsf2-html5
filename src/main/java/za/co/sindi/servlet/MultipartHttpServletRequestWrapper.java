/**
 * 
 */
package za.co.sindi.servlet;

import java.util.Collections;
import java.util.Enumeration;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * @author Bienfait Sindi
 * @since 05 September 2013
 *
 */
public class MultipartHttpServletRequestWrapper extends HttpServletRequestWrapper implements MultipartRequestHandler {

	private Map<String, String[]> parameterMap;
	private Map<String, MultipartFile[]> fileMap;
	
	/**
	 * @param request
	 */
	public MultipartHttpServletRequestWrapper(HttpServletRequest request) {
		super(request);
		// TODO Auto-generated constructor stub
		parameterMap = new LinkedHashMap<String, String[]>();
		fileMap = new LinkedHashMap<String, MultipartFile[]>();
	}
	
	public void addParameter(String name, String value) {
		String[] values = parameterMap.get(name);
		String[] newValues = null;
		
		if (values == null) {
			newValues = new String[] { value };
		} else {
			newValues = new String[values.length + 1];
			System.arraycopy(values, 0, newValues, 0, values.length);
			newValues[values.length] = value;
		}
		
		parameterMap.put(name, newValues);
	}
	
	public void addFile(String name, MultipartFile file) {
		if (file == null) {
			return ;
		}
		
		MultipartFile[] files = fileMap.get(name);
		MultipartFile[] newFiles = null;
		
		if (files == null) {
			newFiles = new MultipartFile[] { file };
		} else {
			newFiles = new MultipartFile[files.length + 1];
			System.arraycopy(files, 0, newFiles, 0, files.length);
			newFiles[files.length] = file;
		}
		
		fileMap.put(name, newFiles);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameter(java.lang.String)
	 */
	@Override
	public String getParameter(String name) {
		// TODO Auto-generated method stub
		String[] values = parameterMap.get(name);
		if (values == null) {
			return null;
		}
		
		if (values.length > 0) {
			return values[0];
		}
		
		return "";
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameterMap()
	 */
	@Override
	public Map<String, String[]> getParameterMap() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableMap(parameterMap);
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameterNames()
	 */
	@Override
	public Enumeration<String> getParameterNames() {
		// TODO Auto-generated method stub
		return Collections.enumeration(parameterMap.keySet());
	}

	/* (non-Javadoc)
	 * @see javax.servlet.ServletRequestWrapper#getParameterValues(java.lang.String)
	 */
	@Override
	public String[] getParameterValues(String name) {
		// TODO Auto-generated method stub
		return parameterMap.get(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.servlet.MultipartRequestHandler#getFile(java.lang.String)
	 */
	public MultipartFile getFile(String name) {
		// TODO Auto-generated method stub
		MultipartFile[] files = fileMap.get(name);
		if (files != null && files.length > 0) {
			return files[0];
		}
		
		return null;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.servlet.MultipartRequestHandler#getFileMap()
	 */
	public Map<String, MultipartFile[]> getFileMap() {
		// TODO Auto-generated method stub
		return Collections.unmodifiableMap(fileMap);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.servlet.MultipartRequestHandler#getFileNames()
	 */
	public Enumeration<String> getFileNames() {
		// TODO Auto-generated method stub
		return Collections.enumeration(fileMap.keySet());
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.servlet.MultipartRequestHandler#getFiles(java.lang.String)
	 */
	public MultipartFile[] getFiles(String name) {
		// TODO Auto-generated method stub
		return fileMap.get(name);
	}
}
