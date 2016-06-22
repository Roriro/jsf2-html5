/**
 * 
 */
package za.co.sindi.jsf.html5.exception;

import javax.faces.FacesException;

/**
 * @author Bienfait Sindi
 * @since 30 June 2013
 *
 */
public class RendererException extends FacesException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3671321566506967345L;

	/**
	 * 
	 */
	public RendererException() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 */
	public RendererException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param cause
	 */
	public RendererException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param message
	 * @param cause
	 */
	public RendererException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}
}
