/**
 * 
 */
package za.co.sindi.jsf.html5.value.impl;

import za.co.sindi.jsf.html5.value.Color;

/**
 * @author Bienfait Sindi
 * @since 05 August 2013
 *
 */
public class ColorImpl implements Color {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3961817034237410160L;
	private int value;
	
	/**
	 * 
	 */
	public ColorImpl() {
		super();
		// TODO Auto-generated constructor stub
		value = 0;
	}

	public ColorImpl(String color) {
		if (!PATTERN.matcher(color).matches()) {
			throw new IllegalArgumentException("Value (" + color + ") doesn't match the value of pattern #RRGGBB.");
		}
		
		value = Integer.parseInt(color.substring(1), 16);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Color#getRed()
	 */
	public int getRed() {
		// TODO Auto-generated method stub
		return (value >> 16) & 0xFF;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Color#getBlue()
	 */
	public int getBlue() {
		// TODO Auto-generated method stub
		return (value & 0xFF);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Color#getGreen()
	 */
	public int getGreen() {
		// TODO Auto-generated method stub
		return (value >> 8) & 0xFF;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.value.Color#getRGB()
	 */
	public int getRGB() {
		// TODO Auto-generated method stub
		return value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String red = Integer.toHexString(getRed());
		String green = Integer.toHexString(getGreen());
		String blue = Integer.toHexString(getBlue());
		
		StringBuilder sb = new StringBuilder();
		if (red.length() < 2) {
			sb.append("0");
		}
		sb.append(red);
		
		if (green.length() < 2) {
			sb.append("0");
		}
		sb.append(green);
		
		if (blue.length() < 2) {
			sb.append("0");
		}
		sb.append(blue);
		
		return "#" + sb.toString();
	}
}
