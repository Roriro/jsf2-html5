/**
 * 
 */
package za.co.sindi.jsf.html5.value.impl;

import java.util.Calendar;

import za.co.sindi.jsf.html5.value.Month;

/**
 * @author Bienfait Sindi
 * @since 05 August 2013
 *
 */
public class MonthImpl implements Month {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7035090287681041301L;
	private int year;
	private int month;
	
	/**
	 * Creates a current month using system Calendar.
	 */
	public MonthImpl() {
		super();
		// TODO Auto-generated constructor stub
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		month = calendar.get(Calendar.MONTH) + 1;
	}

	/**
	 * 
	 * @param month
	 */
	public MonthImpl(String month) {
		if (!PATTERN.matcher(month).matches()) {
			throw new IllegalArgumentException("Value '" + month + "' doesn't match pattern yyyy-MM.");
		}
		
		synchronized (this) {
			year = Integer.parseInt(month.substring(0, 4));
			this.month = Integer.parseInt(month.substring(5));
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Month#getYear()
	 */
	public int getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Month#getMonth()
	 */
	public int getMonth() {
		// TODO Auto-generated method stub
		return month;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%04d", year) + "-" + String.format("%02d", month);
	}
}
