/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import javax.faces.component.FacesComponent;
import javax.faces.convert.IntegerConverter;

import za.co.sindi.jsf.html5.component.HTML5InputRange;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputRangeInt.COMPONENT_TYPE)
public class HTML5InputRangeInt extends HTML5InputRange {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputRangeInt";
	
	private enum PropertyKeys {
		min,
		max,
		step
	}
	
	/**
	 * 
	 */
	public HTML5InputRangeInt() {
		super();
		// TODO Auto-generated constructor stub
		setConverter(new IntegerConverter());
	}
	
	/**
	 * @return the min
	 */
	public int getMin() {
		return (Integer) getStateHelper().eval(PropertyKeys.min, Integer.MIN_VALUE);
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(int min) {
		getStateHelper().put(PropertyKeys.min, min);
	}
	
	/**
	 * @return the max
	 */
	public int getMax() {
		return (Integer) getStateHelper().eval(PropertyKeys.max, Integer.MIN_VALUE);
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(int max) {
		getStateHelper().put(PropertyKeys.max, max);
	}
	
	/**
	 * @return the step
	 */
	public int getStep() {
		return (Integer) getStateHelper().eval(PropertyKeys.step);
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(int step) {
		getStateHelper().put(PropertyKeys.step, step);
	}
}
