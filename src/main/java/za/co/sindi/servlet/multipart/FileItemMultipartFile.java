/**
 * 
 */
package za.co.sindi.servlet.multipart;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.fileupload.FileItem;

import za.co.sindi.servlet.MultipartFile;

/**
 * @author Bienfait Sindi
 * @since 10 August 2013
 *
 */
public class FileItemMultipartFile implements MultipartFile {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1239105004330418893L;
	private FileItem fileItem;
	
	/**
	 * @param fileItem
	 */
	public FileItemMultipartFile(FileItem fileItem) {
		super();
		if (fileItem == null) {
			throw new IllegalArgumentException("Apache Commons FileUpload FileItem may not be null.");
		}
		
		this.fileItem = fileItem;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#delete()
	 */
	public void delete() throws IOException {
		// TODO Auto-generated method stub
		fileItem.delete();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getContentType()
	 */
	public String getContentType() {
		// TODO Auto-generated method stub
		return fileItem.getContentType();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getFileName()
	 */
	public String getFileName() {
		// TODO Auto-generated method stub
		return fileItem.getName();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getHeader(java.lang.String)
	 */
	public String getHeader(String name) {
		// TODO Auto-generated method stub
		return fileItem.getHeaders().getHeader(name);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getHeaders(java.lang.String)
	 */
	public Collection<String> getHeaders(String name) {
		// TODO Auto-generated method stub
		Iterator<String> iterator = fileItem.getHeaders().getHeaders(name);
		if (iterator == null) {
			return null;
		}
		
		List<String> headers = new ArrayList<String>();
		while (iterator.hasNext()) {
			headers.add(iterator.next());
		}
		
		return Collections.unmodifiableList(headers);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getHeaderNames()
	 */
	public Collection<String> getHeaderNames() {
		// TODO Auto-generated method stub
		Iterator<String> iterator = fileItem.getHeaders().getHeaderNames();
		if (iterator == null) {
			return null;
		}
		
		List<String> headers = new ArrayList<String>();
		while (iterator.hasNext()) {
			headers.add(iterator.next());
		}
		
		return Collections.unmodifiableList(headers);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getInputStream()
	 */
	public InputStream getInputStream() throws IOException {
		// TODO Auto-generated method stub
		return fileItem.getInputStream();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#getSize()
	 */
	public long getSize() {
		// TODO Auto-generated method stub
		return fileItem.getSize();
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.File#write(java.lang.String)
	 */
	public void write(String fileName) throws IOException {
		// TODO Auto-generated method stub
		try {
			fileItem.write(new java.io.File(fileName));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new IOException(e);
		}
	}
}
