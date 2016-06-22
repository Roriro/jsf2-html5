/**
 * 
 */
package za.co.sindi.jsf.html5.value.impl;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import za.co.sindi.jsf.html5.value.Time;

/**
 * @author Bienfait Sindi
 * @since 05 August 2013
 *
 */
public class TimeImpl implements Time {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6725848394311082651L;
	private static final Logger LOGGER = Logger.getLogger(TimeImpl.class.getName());
	private int hour;
	private int minute;
	private int second;
	private BigDecimal fractionalSecond = null;;
	
	/**
	 * 
	 */
	public TimeImpl() {
		super();
		// TODO Auto-generated constructor stub
		Calendar calendar = Calendar.getInstance();
		hour = calendar.get(Calendar.HOUR_OF_DAY);
		minute = calendar.get(Calendar.MINUTE);
		second = calendar.get(Calendar.SECOND);
		
		try {
			//Let's try and get fractional second
			if (calendar instanceof GregorianCalendar) {
				XMLGregorianCalendar xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar((GregorianCalendar)calendar);
				fractionalSecond = xmlCalendar.getFractionalSecond();
			}
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			if (LOGGER.isLoggable(Level.SEVERE)) {
				LOGGER.log(Level.SEVERE, "Error getting fractional second from Gregorian Calendar " + calendar, e);
			}
		}
	}

	/**
	 * Create a time based on the provided partial-time format.
	 * @param time
	 */
	public TimeImpl(String time) {
		if (!PATTERN.matcher(time).matches()) {
			throw new IllegalArgumentException("Value '" + time +"' doesn't match the partial-time format as specified in RFC3339.");
		}
		
		synchronized (this) {
			hour = Integer.parseInt(time.substring(0, 2));
			minute = Integer.parseInt(time.substring(3, 5));
			second = Integer.parseInt(time.substring(6, 8));
			if (time.length() >= 8) {
				int fractionPos = time.indexOf('.', 8);
				if (fractionPos != -1) {
					fractionalSecond = new BigDecimal(time.substring(fractionPos + 1));
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Time#getHour()
	 */
	public int getHour() {
		// TODO Auto-generated method stub
		return hour;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Time#getMinute()
	 */
	public int getMinute() {
		// TODO Auto-generated method stub
		return minute;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Time#getSecond()
	 */
	public int getSecond() {
		// TODO Auto-generated method stub
		return second;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Time#getFractionalSecond()
	 */
	public BigDecimal getFractionalSecond() {
		// TODO Auto-generated method stub
		return fractionalSecond;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.format("%02d", hour) + ":" + String.format("%02d", minute) + String.format("%02d", second) + "." + String.valueOf(fractionalSecond);
	}
}
