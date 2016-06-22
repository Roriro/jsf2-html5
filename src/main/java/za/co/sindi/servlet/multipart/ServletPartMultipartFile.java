/**
 * 
 */
package za.co.sindi.servlet.multipart;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

import javax.servlet.http.Part;

import za.co.sindi.servlet.MultipartFile;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
public class ServletPartMultipartFile implements MultipartFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3601639694287869548L;
	private Part part;
	
	/**
	 * @param part
	 */
	public ServletPartMultipartFile(Part part) {
		super();
		if (part == null) {
			throw new IllegalArgumentException("Servlet Part may not be null.");
		}
		
		this.part = part;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#delete()
	 */
	public void delete() throws IOException {
		// TODO Auto-generated method stub
		part.delete();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getContentType()
	 */
	public String getContentType() {
		// TODO Auto-generated method stub
		return part.getContentType();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getFileName()
	 */
	public String getFileName() {
		// TODO Auto-generated method stub
		return part.getSubmittedFileName();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getHeader(java.lang.String)
	 */
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return part.getHeader(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getHeaders(java.lang.String)
	 */
	public Collection<String> getHeaders(String name) {
		// TODO Auto-generated method stub
		return part.getHeaders(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getHeaderNames()
	 */
	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		return part.getHeaderNames();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getInputStream()
	 */
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return part.getInputStream();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getSize()
	 */
	public long getSize() {
		// TODO Auto-generated method stub
		return part.getSize();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#write(java.lang.String)
	 */
	public void write(String fileName) throws IOException {
		// TODO Auto-generated method stub
		part.write(fileName);
	}
}
