/**
 * 
 */
package za.co.sindi.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.Serializable;
import java.util.Collection;

/**
 * @author Bienfait Sindi
 * @since 04 August 2013
 *
 */
public interface MultipartFile extends Serializable {

	public void delete() throws IOException;
	
	public String getContentType();
	
	public String getFileName();
	
	public String getHeader(String name);

    public Collection<String> getHeaders(String name);

    public Collection<String> getHeaderNames();
	
	public InputStream getInputStream() throws IOException;
	
	public long getSize();
	
	public void write(String fileName) throws IOException;
}
