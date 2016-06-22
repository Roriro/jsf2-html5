/**
 * 
 */
package za.co.sindi.jsf.html5.validator;

import java.util.logging.Logger;

import javax.faces.validator.Validator;

/**
 * @author Bienfait Sindi
 * @since 22 August 2013
 *
 */
public abstract class AbstractValidator implements Validator {

	protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());
}
