/**
 * 
 */
package za.co.sindi.jsf.html5.value.impl;

import java.util.Calendar;

import za.co.sindi.jsf.html5.value.Week;

/**
 * @author Bienfait Sindi
 * @since 07 August 2013
 *
 */
public class WeekImpl implements Week {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4661342686490686059L;
	private int year;
	private int week;
	
	/**
	 * 
	 */
	public WeekImpl() {
		super();
		// TODO Auto-generated constructor stub
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		week = calendar.get(Calendar.WEEK_OF_YEAR);
	}

	/**
	 * 
	 * @param week
	 */
	public WeekImpl(String week) {
		if (!PATTERN.matcher(week).matches()) {
			throw new IllegalArgumentException("Value '" + week + "' doesn't match pattern yyyy-W<week>");
		}
		
		synchronized (this) {
			year = Integer.parseInt(week.substring(0, 4));
			this.week = Integer.parseInt(week.substring(6));
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Week#getYear()
	 */
	public int getYear() {
		// TODO Auto-generated method stub
		return year;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Week#getWeek()
	 */
	public int getWeek() {
		// TODO Auto-generated method stub
		return week;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%04d", year) + "-W" + String.format("%02d", week);
	}
}
