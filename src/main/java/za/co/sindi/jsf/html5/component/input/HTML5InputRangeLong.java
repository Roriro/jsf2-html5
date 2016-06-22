/**
 * 
 */
package za.co.sindi.jsf.html5.component.input;

import javax.faces.component.FacesComponent;
import javax.faces.convert.LongConverter;

import za.co.sindi.jsf.html5.component.HTML5InputRange;

/**
 * @author Bienfait Sindi
 * @since 03 August 2013
 *
 */
@FacesComponent(HTML5InputRangeLong.COMPONENT_TYPE)
public class HTML5InputRangeLong extends HTML5InputRange {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5InputRangeLong";
	
	private enum PropertyKeys {
		min,
		max,
		step
	}
	
	/**
	 * 
	 */
	public HTML5InputRangeLong() {
		super();
		// TODO Auto-generated constructor stub
		setConverter(new LongConverter());
	}
	
	/**
	 * @return the min
	 */
	public long getMin() {
		return (Long) getStateHelper().eval(PropertyKeys.min, Long.MIN_VALUE);
	}

	/**
	 * @param min the min to set
	 */
	public void setMin(long min) {
		getStateHelper().put(PropertyKeys.min, min);
	}
	
	/**
	 * @return the max
	 */
	public long getMax() {
		return (Long) getStateHelper().eval(PropertyKeys.max, Long.MIN_VALUE);
	}

	/**
	 * @param max the max to set
	 */
	public void setMax(long max) {
		getStateHelper().put(PropertyKeys.max, max);
	}
	
	/**
	 * @return the step
	 */
	public long getStep() {
		return (Long) getStateHelper().eval(PropertyKeys.step);
	}

	/**
	 * @param step the step to set
	 */
	public void setStep(long step) {
		getStateHelper().put(PropertyKeys.step, step);
	}
}
