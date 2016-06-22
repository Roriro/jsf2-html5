/**
 * 
 */
package za.co.sindi.servlet.filter;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import za.co.sindi.servlet.MultipartHttpServletRequestWrapper;
import za.co.sindi.servlet.multipart.FileItemMultipartFile;

/**
 * @author Bienfait Sindi
 * @since 05 September 2013
 *
 */
public class MultipartServletFilter implements Filter {

	private static final Logger LOGGER = Logger.getLogger(MultipartServletFilter.class.getName());
	private static final long DEFAULT_MAX_FILE_SIZE = 256* 1024 * 1024;
	private long maxFileSize;
	private String repositoryPath;
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		maxFileSize = getMaxFileSize(filterConfig);
		repositoryPath = getRepositoryPath(filterConfig);
	}
	
	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub

	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		chain.doFilter((request instanceof HttpServletRequest) ? parseRequest((HttpServletRequest) request) : request, response);
//		if (request instanceof HttpServletRequest) {
//			HttpServletRequest httpServletRequest = parseRequest((HttpServletRequest) request);
//			
//			//Finally, pass the request through the chain.
//			chain.doFilter(httpServletRequest, response);
//		} else {
//			//request is not a HttpServletRequest, just pass it through the chain.
//			chain.doFilter(request, response);
//		}
	}
	
	private HttpServletRequest parseRequest(HttpServletRequest request) throws ServletException {
		if (!ServletFileUpload.isMultipartContent(request)) {
			//No need to to continue as there is no multipart content...
			return request;
		}
		
		MultipartHttpServletRequestWrapper multipartRequest = new MultipartHttpServletRequestWrapper(request);
		
		// Create a factory for disk-based file items
		DiskFileItemFactory factory = new DiskFileItemFactory();
		
		//Set factory constraint
		factory.setRepository(new File(repositoryPath));
		
		// Create a new file upload handler
		ServletFileUpload upload = new ServletFileUpload(factory);
		
		//Maximum uploadable file size
		if (maxFileSize > 0) {
			upload.setSizeMax(maxFileSize);
		}

		// Parse the request
		List<FileItem> items = null;
		try {
			items = upload.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			throw new ServletException("Error parsing request using Apache Commons FileUpload.", e);
		}
		
		if (items != null) {
			for (FileItem item : items) {
				if (item.isFormField()) {
					try {
						processFormField(item, multipartRequest);
					} catch (UnsupportedEncodingException e) {
						// TODO Auto-generated catch block
						throw new ServletException("Unsupported encoding exception encountered.", e);
					}
				} else {
					processFileUpload(item, multipartRequest);
				}
			}
		}
		
		return multipartRequest;
	}
	
	private void processFormField(FileItem item, MultipartHttpServletRequestWrapper request) throws UnsupportedEncodingException {
//		if (!item.isFormField()) {
//			return ;
//		}
		
		String name = item.getFieldName();
		String value = null;
		String encoding = null;
		
		if (item instanceof DiskFileItem) {
			encoding = ((DiskFileItem)item).getCharSet();
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info("DiskFileItem.getCharSet() = " + encoding);
			}
		}
		
		if (encoding == null) {
			encoding = request.getCharacterEncoding();
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info("HttpServletRequest.getCharacterEncoding() = " + encoding);
			}
		}
		
		if (encoding == null) {
			encoding = "ISO-8859-1";
			if (LOGGER.isLoggable(Level.INFO)) {
				LOGGER.info("Defaulting to default " + encoding);
			}
		}
		
		if (encoding != null) {
			value = item.getString(encoding);
		}
		
		request.addParameter(name, value);
	}
	
	private void processFileUpload(FileItem item, MultipartHttpServletRequestWrapper request) {
//		if (item.isFormField()) {
//			return ;
//		}
		
		request.addFile(item.getFieldName(), new FileItemMultipartFile(item));
	}
	
	private long getMaxFileSize(FilterConfig filterConfig) throws ServletException {
		String value = filterConfig.getInitParameter("maxFileSize");
		if (value != null && !value.matches("^\\d+$")) {
			throw new ServletException("maxFileSize value is not numeric.");
		}
		
		long fileSize = DEFAULT_MAX_FILE_SIZE;
		if (value != null) {
			fileSize = Long.parseLong(value);
		}
		
		//Is this possible?
		if (fileSize > Long.MAX_VALUE) {
			fileSize = DEFAULT_MAX_FILE_SIZE;
		}
		
		return fileSize; 
	}
	
	private String getRepositoryPath(FilterConfig filterConfig) {
		String repositoryPath = filterConfig.getInitParameter("repositoryPath");
		if (repositoryPath == null) {
			//try it from a ServletContext
			File contextTempDir = (File) filterConfig.getServletContext().getAttribute("javax.servlet.context.tempdir");
			repositoryPath = contextTempDir.getAbsolutePath();
			
			if (repositoryPath == null || repositoryPath.trim().isEmpty()) {
				repositoryPath = System.getProperty("java.io.tmpdir");
			}
		}
		
		if (LOGGER.isLoggable(Level.INFO)) {
			LOGGER.info("Repository path is set to " + repositoryPath);
		}
		
		return repositoryPath;
	}
}
