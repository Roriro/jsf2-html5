/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.exception.RendererException;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * <i>Note:</i> Most, if not all, code copied from <code>com.sun.faces.renderkit.html_basic.BaseTableRenderer</code> class.
 * 
 * @author Bienfait Sindi
 * @since 12 July 2015
 *
 */
public abstract class HTML5BaseTableRenderer extends HTML5Renderer {
	
	protected static final String CAPTION_ELEMENT_NAME = HTML5Elements.CAPTION;
	protected static final String TABLE_ELEMENT_NAME = HTML5Elements.TABLE;
	protected static final String TBODY_ELEMENT_NAME = HTML5Elements.TBODY;
	protected static final String TR_ELEMENT_NAME = HTML5Elements.TR;
	
	private static final String[] TABLE_ATTRIBUTES = {
		HTML5Attributes.BORDER,
		"role"
	};

	protected void renderTableStart(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {
		
		String border = (String) table.getAttributes().get(HTML5Attributes.BORDER);
		if (border != null && !("1".equals(border) || "".equals(border))) {
			throw new RendererException("The value of the 'border' attribute on the table element must be either \"1\" or the empty string. To regulate the thickness of table borders, Use CSS instead.");
		}
        writer.startElement(TABLE_ELEMENT_NAME, table);
        writeIdAttributeIfNecessary(writer, context, table);
        String styleClass = (String) table.getAttributes().get(JSFAttributes.STYLECLASS);
        if (styleClass != null) {
            writer.writeAttribute(HTML5Attributes.CLASS, styleClass, JSFAttributes.STYLECLASS);
        }
        renderPassThroughAttributes(context, table, TABLE_ATTRIBUTES);
        renderPassThroughAttributes(context, table, COMMON_ATTRIBUTES);
        writeDataAttributes(context, table);
        writer.writeText("\n", table, null);
	}
	
	protected void renderTableEnd(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {
		
		 writer.endElement(TABLE_ELEMENT_NAME);
		 writer.writeText("\n", table, null);
	}
	
	/**
	 * Renders the &lt;caption&gt; element.
	 * 
	 * @param context
	 * @param table
	 * @param writer
	 * @throws IOException
	 */
	protected void renderCaption(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {
		
		UIComponent caption = RendererUtils.getFacet(table, CAPTION_ELEMENT_NAME);
		if (caption != null) {
			if (!shouldEncode(caption)) {
				return ;
			}
			
			String captionClass = (String) table.getAttributes().get("captionClass");
			String captionStyle = (String) table.getAttributes().get("captionStyle");
			writer.startElement(CAPTION_ELEMENT_NAME, table);
			if (captionClass != null) {
                writer.writeAttribute(HTML5Attributes.CLASS, captionClass, "captionClass");
            }
            if (captionStyle != null) {
                writer.writeAttribute(HTML5Attributes.STYLE, captionStyle, "captionStyle");
            }
			encodeRecursively(context, caption);
			writer.endElement(CAPTION_ELEMENT_NAME);
		}
	}
	
    /**
     * Renders the starting <code>tbody</code> element.
     * @param context the <code>FacesContext</code> for the current request
     * @param table the table that's being rendered
     * @param writer the current writer
     * @throws IOException if content cannot be written
     */
    protected void renderTableBodyStart(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {

		writer.startElement(TBODY_ELEMENT_NAME, table);
		writer.writeText("\n", table, null);

    }


    /**
     * Renders the closing <code>tbody</code> element.
     * @param context the <code>FacesContext</code> for the current request
     * @param table the table that's being rendered
     * @param writer the current writer
     * @throws IOException if content cannot be written
     */
    protected void renderTableBodyEnd(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {

        writer.endElement(TBODY_ELEMENT_NAME);
        writer.writeText("\n", table, null);

    }


    /**
     * Renders the starting <code>tr</code> element applying any values
     * from the <code>rowClasses</code> attribute.
     * @param context the <code>FacesContext</code> for the current request
     * @param table the table that's being rendered
     * @param writer the current writer
     * @throws IOException if content cannot be written
     */
    protected void renderRowStart(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {

        TableMetaInfo info = getMetaInfo(context, table);
        writer.startElement(TR_ELEMENT_NAME, table);
        if (info.rowClasses.length > 0) {
            writer.writeAttribute(HTML5Attributes.CLASS, info.getCurrentRowClass(), "rowClasses");
        }
        
        writer.writeText("\n", table, null);
    }


    /**
     * Renders the closing <code>tr</code> element.
     * @param context the <code>FacesContext</code> for the current request
     * @param table the table that's being rendered
     * @param writer the current writer
     * @throws IOException if content cannot be written
     */
    protected void renderRowEnd(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {

        writer.endElement(TR_ELEMENT_NAME);
        writer.writeText("\n", table, null);

    }


    /**
     * Returns a <code>TableMetaInfo</code> object containing details such
     * as row and column classes, columns, and a mechanism for scrolling through
     * the row/column classes.
     * @param context the <code>FacesContext</code> for the current request
     * @param table the table that's being rendered
     * @return the <code>TableMetaInfo</code> for provided table
     */
    protected TableMetaInfo getMetaInfo(FacesContext context, UIComponent table) {

        String key = createKey(table);
        Map<Object,Object> attributes = context.getAttributes();
        TableMetaInfo info = (TableMetaInfo) attributes.get(key);
        if (info == null) {
            info = new TableMetaInfo(table);
            attributes.put(key, info);
        }
        
        return info;
    }


    /**
     * Removes the cached TableMetaInfo from the specified component.
     * @param context the <code>FacesContext</code> for the current request
     * @param table the table from which the TableMetaInfo will be removed
     */
    protected void clearMetaInfo(FacesContext context, UIComponent table) {

        context.getAttributes().remove(createKey(table));

    }


    /**
     * Creates a unique key based on the provided <code>UIComponent</code> with
     *  which the TableMetaInfo can be looked up.
     *
     * @param table the table that's being rendered
     * @return a unique key to store the metadata in the request and still have
     *  it associated with a specific component.
     */
    protected String createKey(UIComponent table) {

        return TableMetaInfo.KEY + '_' + table.hashCode();

    }
	
	protected abstract void renderHeader(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException;
	protected abstract void renderFooter(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException;
	protected abstract void renderRow(FacesContext context, UIComponent table, UIComponent row, ResponseWriter writer) throws IOException;
	
	// ----------------------------------------------------------- Inner Classes


    protected static class TableMetaInfo {

        private static final String[] EMPTY_STRING_ARRAY = new String[0];
        public static final String KEY = TableMetaInfo.class.getName();

        public final String[] rowClasses;
        public final String[] columnClasses;
        public final List<UIColumn> columns;
        public final boolean hasHeaderFacets;
        public final boolean hasFooterFacets;
        public final int columnCount;
        public int columnStyleCounter;
        public int rowStyleCounter;


        // -------------------------------------------------------- Constructors


        public TableMetaInfo(UIComponent table) {
            rowClasses = getRowClasses(table);
            columnClasses = getColumnClasses(table);
            columns = getColumns(table);
            columnCount = columns.size();
            hasHeaderFacets = hasFacet("header", columns);
            hasFooterFacets = hasFacet("footer", columns);
        }


        // ------------------------------------------------------ Public Methods


        /**
         * Reset the counter used to apply column styles.
         */
        public void newRow() {

            columnStyleCounter = 0;

        }


        /**
         * Obtain the column class based on the current counter.  Calling this
         * method automatically moves the pointer to the next style.  If the
         * counter is larger than the number of total classes, the counter will
         * be reset.
         * @return the current style
         */
        public String getCurrentColumnClass() {

            String style = null;
            if (columnStyleCounter < columnClasses.length
                 && columnStyleCounter <= columnCount) {
                style = columnClasses[columnStyleCounter++];
            }
            return ((style != null && style.length() > 0) ? style : null);

        }


        /**
         * Obtain the row class based on the current counter.  Calling this
         * method automatically moves the pointer to the next style.  If the
         * counter is larger than the number of total classes, the counter will
         * be reset.
         * @return the current style
         */
        public String getCurrentRowClass() {
            String style = rowClasses[rowStyleCounter++];
            if (rowStyleCounter >= rowClasses.length) {
                rowStyleCounter = 0;
            }
            return style;
        }


        // ----------------------------------------------------- Private Methods

        /**
         * <p>Return an array of stylesheet classes to be applied to each column in
         * the table in the order specified. Every column may or may not have a
         * stylesheet.</p>
         *
         * @param table {@link javax.faces.component.UIComponent} component being rendered
         *
         * @return an array of column classes
         */
        private static String[] getColumnClasses(UIComponent table) {

            String values = (String) table.getAttributes().get("columnClasses");
            if (values == null) {
                return EMPTY_STRING_ARRAY;
            }
//            Map<String, Object> appMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
//            return Util.split(appMap, values.trim(), ",");
            return values.split(",");
        }

        /**
         * <p>Return an Iterator over the <code>UIColumn</code> children of the
         * specified <code>UIData</code> that have a <code>rendered</code> property
         * of <code>true</code>.</p>
         *
         * @param table the table from which to extract children
         *
         * @return the List of all UIColumn children
         */
        private static List<UIColumn> getColumns(UIComponent table) {

            if (table instanceof UIData) {
                int childCount = table.getChildCount();
                if (childCount > 0) {
                    List<UIColumn> results =
                          new ArrayList<UIColumn>(childCount);
                    for (UIComponent kid : table.getChildren()) {
                        if ((kid instanceof UIColumn) && kid.isRendered()) {
                            results.add((UIColumn) kid);
                        }
                    }
                    return results;
                } else {
                    return Collections.emptyList();
                }
            } else {
                int count;
                Object value = table.getAttributes().get("columns");
                if ((value != null) && (value instanceof Integer)) {
                    count = ((Integer) value);
                } else {
                    count = 2;
                }
                if (count < 1) {
                    count = 1;
                }
                List<UIColumn> result = new ArrayList<UIColumn>(count);
                for (int i = 0; i < count; i++) {
                    result.add(new UIColumn());
                }
                return result;
            }
        }

        /**
         * <p>Return the number of child <code>UIColumn</code> components nested in
         * the specified <code>UIData</code> that have a facet with the specified
         * name.</p>
         *
         * @param name    Name of the facet being analyzed
         * @param columns the columns to search
         *
         * @return the number of columns associated with the specified Facet name
         */
        private static boolean hasFacet(String name, List<UIColumn> columns) {

            if (!columns.isEmpty()) {
                for (UIColumn column : columns) {
                    if (column.getFacetCount() > 0) {
                        if (column.getFacets().containsKey(name)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }


        /**
         * <p>Return an array of stylesheet classes to be applied to each row in the
         * table, in the order specified.  Every row may or may not have a
         * stylesheet.</p>
         *
         * @param table {@link javax.faces.component.UIComponent} component being rendered
         *
         * @return an array of row classes
         */
        private static String[] getRowClasses(UIComponent table) {

            String values = (String) table.getAttributes().get("rowClasses");
            if (values == null) {
                return (EMPTY_STRING_ARRAY);
            }
//            Map<String, Object> appMap = FacesContext.getCurrentInstance().getExternalContext().getApplicationMap();
//            return Util.split(appMap, values.trim(), ",");
            return values.split(",");
        }

    } // END UIDataMetaInfo
}
