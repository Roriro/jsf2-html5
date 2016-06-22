/**
 * 
 */
package za.co.sindi.jsf.html5.validator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.ValidatorException;

/**
 * Validates the email address with the regular expression defined <a href="http://www.w3.org/TR/html-markup/input.email.html#input.email">here</a>.
 * 
 * @author Bienfait Sindi
 * @since 22 August 2013
 *
 */
@FacesValidator(HTML5EmailValidator.VALIDATOR_ID)
public class HTML5EmailValidator extends AbstractValidator {
	
	public static final String VALIDATOR_ID = "za.co.sindi.jsf.html5.validator.EmailValidator";
	public static final String HTML5_EMAIL_REGEXP = "^[a-zA-Z0-9.!#$%&�*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$";

	/* (non-Javadoc)
	 * @see javax.faces.validator.Validator#validate(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	public void validate(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		// TODO Auto-generated method stub
		if (value == null) {
			throw new ValidatorException(new FacesMessage("No value specified."));
		}
		
		if (value instanceof String[]) {
			for (String v : (String[])value) {
				if (!isValid(v)) {
					throw new ValidatorException(new FacesMessage("Value containing string, " + v + ", is not a valid HTML5 email address."));
				}
			}
		}
		
		if (value instanceof String && !isValid((String)value)) {
			throw new ValidatorException(new FacesMessage("Value " + (String)value + " is not a valid HTML5 email address."));
		}
	}
	
	private boolean isValid(String value) {
		return value.matches(HTML5_EMAIL_REGEXP);
	}
}
