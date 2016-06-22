/**
 * 
 */
package za.co.sindi.jsf.html5.component.data;

import javax.faces.component.FacesComponent;

import za.co.sindi.jsf.html5.component.HTML5UIData;

/**
 * @author Bienfait Sindi
 * @since 26 August 2013
 *
 */
@FacesComponent(HTML5DataTable.COMPONENT_TYPE)
public class HTML5DataTable extends HTML5UIData {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5DataTable";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Table";
	
	protected enum PropertyKeys {
		bodyrows,
        border,
        captionClass,
        captionStyle,
        columnClasses,
        footerClass,
        headerClass,
        role,
        rowClasses,
	}

	/**
	 * 
	 */
	public HTML5DataTable() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * @return the bodyrows
	 */
	public String getBodyrows() {
		return (String) getStateHelper().eval(PropertyKeys.bodyrows);
	}

	/**
	 * @param bodyrows the bodyrows to set
	 */
	public void setBodyrows(String bodyrows) {
		getStateHelper().put(PropertyKeys.bodyrows, bodyrows);
	}

	/**
	 * @return the border
	 */
	public String getBorder() {
		return (String) getStateHelper().eval(PropertyKeys.border);
	}

	/**
	 * @param border the border to set
	 */
	public void setBorder(String border) {
		getStateHelper().put(PropertyKeys.border, border);
	}

	/**
	 * @return the captionClass
	 */
	public String getCaptionClass() {
		return (String) getStateHelper().eval(PropertyKeys.captionClass);
	}

	/**
	 * @param captionClass the captionClass to set
	 */
	public void setCaptionClass(String captionClass) {
		getStateHelper().put(PropertyKeys.captionClass, captionClass);
	}

	/**
	 * @return the captionStyle
	 */
	public String getCaptionStyle() {
		return (String) getStateHelper().eval(PropertyKeys.captionStyle);
	}

	/**
	 * @param captionStyle the captionStyle to set
	 */
	public void setCaptionStyle(String captionStyle) {
		getStateHelper().put(PropertyKeys.captionStyle, captionStyle);
	}

	/**
	 * @return the columnClasses
	 */
	public String getColumnClasses() {
		return (String) getStateHelper().eval(PropertyKeys.columnClasses);
	}

	/**
	 * @param columnClasses the columnClasses to set
	 */
	public void setColumnClasses(String columnClasses) {
		getStateHelper().put(PropertyKeys.columnClasses, columnClasses);
	}

	/**
	 * @return the footerClass
	 */
	public String getFooterClass() {
		return (String) getStateHelper().eval(PropertyKeys.footerClass);
	}

	/**
	 * @param footerClass the footerClass to set
	 */
	public void setFooterClass(String footerClass) {
		getStateHelper().put(PropertyKeys.footerClass, footerClass);
	}

	/**
	 * @return the headerClass
	 */
	public String getHeaderClass() {
		return (String) getStateHelper().eval(PropertyKeys.headerClass);
	}

	/**
	 * @param headerClass the headerClass to set
	 */
	public void setHeaderClass(String headerClass) {
		getStateHelper().put(PropertyKeys.headerClass, headerClass);
	}

	/**
	 * @return the rowClasses
	 */
	public String getRowClasses() {
		return (String) getStateHelper().eval(PropertyKeys.rowClasses);
	}

	/**
	 * @param rowClasses the rowClasses to set
	 */
	public void setRowClasses(String rowClasses) {
		getStateHelper().put(PropertyKeys.rowClasses, rowClasses);
	}
}
