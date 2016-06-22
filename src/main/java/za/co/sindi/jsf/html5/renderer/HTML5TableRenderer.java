/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.faces.component.UIColumn;
import javax.faces.component.UIComponent;
import javax.faces.component.UIData;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.data.HTML5DataTable;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 06 September 2013
 *
 */
@FacesRenderer(componentFamily=UIData.COMPONENT_FAMILY, rendererType=HTML5DataTable.RENDERER_TYPE)
public class HTML5TableRenderer extends HTML5BaseTableRenderer {

	private static final String TBODY_ELEMENT_NAME = HTML5Elements.TBODY;
	private static final String THEAD_ELEMENT_NAME = HTML5Elements.THEAD;
	private static final String TFOOT_ELEMENT_NAME = HTML5Elements.TFOOT;
	private static final String TD_ELEMENT_NAME = HTML5Elements.TD;
	private static final String TH_ELEMENT_NAME = HTML5Elements.TH;
	private static final String TR_ELEMENT_NAME = HTML5Elements.TR;
	
	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeBegin(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeBegin(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIData.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		UIData table = (UIData) component;
		table.setRowIndex(-1);
		
		// Render the beginning of the table
        ResponseWriter writer = context.getResponseWriter();

        renderTableStart(context, component, writer);
        
        //Render caption facet (if any)
        renderCaption(context, table, writer);
        
        //Render colgroup facet (if any)
        renderColumnGroups(context, table, writer);
        
        //Render header facet (if any)
        renderHeader(context, table, writer);
        
        //Render footer facet (if any)
        renderFooter(context, table, writer);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeChildren(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIData.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		UIData data = (UIData) component;
		
		// Render the table body
        ResponseWriter writer = context.getResponseWriter();

        // Check if any columns are being rendered, if not
        // render the minimal markup and exit
        TableMetaInfo info = getMetaInfo(context, data);
        if(info.columns.isEmpty()) {
        	renderEmptyTableBody(writer,data);
        	return;
        }
        
        // Iterate over the rows of data that are provided
        int processed = 0;
        int rowIndex = data.getFirst() - 1;
        int rows = data.getRows();
        List<Integer> bodyRows = getBodyRows(data);
        boolean hasBodyRows = (bodyRows != null && !bodyRows.isEmpty());
        boolean wroteTableBody = false;
        if (!hasBodyRows) {
            renderTableBodyStart(context, component, writer);
        }
        boolean renderedRow = false;
        while (true) {
            // Have we displayed the requested number of rows?
            if ((rows > 0) && (++processed > rows)) {
                break;
            }
            // Select the current row
            data.setRowIndex(++rowIndex);
            if (!data.isRowAvailable()) {
                break; // Scrolled past the last row
            }

            // render any table body rows
            if (hasBodyRows && bodyRows.contains(data.getRowIndex())) {
                if (wroteTableBody) {
                    writer.endElement(TBODY_ELEMENT_NAME);
                }
                writer.startElement(TBODY_ELEMENT_NAME, data);
                wroteTableBody = true;
            }

            // Render the beginning of this row
            renderRowStart(context, component, writer);

            // Render the row content
            renderRow(context, component, null, writer);

            // Render the ending of this row
            renderRowEnd(context, component, writer);
            renderedRow = true;
        }

        // fill an empty tbody, if no row has been rendered
        if(!renderedRow) {
        	this.renderEmptyTableRow(writer, data);
        }
        renderTableBodyEnd(context, component, writer);

        // Clean up after ourselves
        data.setRowIndex(-1);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIData.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		 clearMetaInfo(context, component);
		 ((UIData) component).setRowIndex(-1);

		// Render the ending of this table
		 renderTableEnd(context, component, context.getResponseWriter());
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#getRendersChildren()
	 */
	@Override
	public boolean getRendersChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * Renders the colgroups element.
	 * 
	 * @param context
	 * @param component
	 * @param writer
	 * @throws IOException
	 */
	protected void renderColumnGroups(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		
		UIComponent columnGroups = RendererUtils.getFacet(component, "colgroups");
		if (columnGroups != null) {
			if (!shouldEncode(columnGroups)) {
				return ;
			}
			
			encodeRecursively(context, columnGroups);
		}
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BaseTableRenderer#renderHeader(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderHeader(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		TableMetaInfo info = getMetaInfo(context, table);
		UIComponent header = RendererUtils.getFacet(table, "header");
		// check if any header has to be rendered
		if(header==null && !info.hasHeaderFacets) {
			return;
		}
		
		writer.write("\n\t");
		writer.startElement(THEAD_ELEMENT_NAME, table);
		writer.writeText("\n\t", table, null);
		String headerClass = (String) table.getAttributes().get("headerClass");
		
		if (header != null) {
			writer.startElement(TR_ELEMENT_NAME, table);
            writer.writeText("\n\t", table, null);
			
            if (headerClass != null) {
                writer.writeAttribute(HTML5Attributes.CLASS, headerClass, "headerClass");
            }
            if(info.columns.size()>1) {
            	writer.writeAttribute(HTML5Attributes.COLSPAN, String.valueOf(info.columns.size()), null);
            }
            writer.writeAttribute(HTML5Attributes.SCOPE, "colgroup", null);
            encodeRecursively(context, header);
            writer.endElement(TH_ELEMENT_NAME);
            renderRowEnd(context, table, writer);
		}
		
		if (info.hasHeaderFacets) {
            writer.startElement(TR_ELEMENT_NAME, table);
            writer.writeText("\n", table, null);
            for (UIColumn column : info.columns) {
                String columnHeaderClass = (String) column.getAttributes().get("headerClass");
                writer.startElement(TH_ELEMENT_NAME, column);
                if (columnHeaderClass != null) {
                    writer.writeAttribute(HTML5Attributes.CLASS, columnHeaderClass, "columnHeaderClass");
                } else if (headerClass != null) {
                    writer.writeAttribute(HTML5Attributes.CLASS, headerClass, "headerClass");
                }
                writer.writeAttribute(HTML5Attributes.SCOPE, "col", null);
                UIComponent facet = RendererUtils.getFacet(column, "header");
                if (facet != null) {
                    encodeRecursively(context, facet);
                }
                writer.endElement(TH_ELEMENT_NAME);
                writer.writeText("\n", table, null);
            }
            renderRowEnd(context, table, writer);
        }
		
		writer.endElement(THEAD_ELEMENT_NAME);
        writer.writeText("\n", table, null);
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BaseTableRenderer#renderRow(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderRow(FacesContext context, UIComponent table, UIComponent row, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		// Iterate over the child UIColumn components for each row
        TableMetaInfo info = getMetaInfo(context, table);
        info.newRow();
		for (UIColumn column : info.columns) {
            // Render the beginning of this cell
            boolean isRowHeader = false;
            Object rowHeaderValue = column.getAttributes().get("rowHeader");
            if (null != rowHeaderValue) {
                isRowHeader = Boolean.valueOf(rowHeaderValue.toString());
            }
            if (isRowHeader) {
                writer.startElement(TH_ELEMENT_NAME, column);
                writer.writeAttribute(HTML5Attributes.SCOPE, "row", null);
            } else {
                writer.startElement(TD_ELEMENT_NAME, column);
            }

            String columnClass = info.getCurrentColumnClass();
            if (columnClass != null)  {
                writer.writeAttribute(HTML5Attributes.CLASS, columnClass, "columnClasses");
            }

            // Render the contents of this cell by iterating over
            // the kids of our kids
            if (column.getChildCount() > 0) {
            	for (UIComponent childColumn : column.getChildren()) {
            		encodeRecursively(context, childColumn);
            	}
            }

            // Render the ending of this cell
            if (isRowHeader) {
                writer.endElement(TH_ELEMENT_NAME);
            } else {
                writer.endElement(TD_ELEMENT_NAME);
            }
            writer.writeText("\n", table, null);
        }
	}
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BaseTableRenderer#renderFooter(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderFooter(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		TableMetaInfo info = getMetaInfo(context, table);
        UIComponent footer = RendererUtils.getFacet(table, "footer");
        // check if any footer has to be rendered
        if (footer == null && !info.hasFooterFacets) {
            return;
        }
		
		writer.write("\n\t");
		writer.startElement(TFOOT_ELEMENT_NAME, table);
		writer.writeText("\n\t", table, null);
		String footerClass = (String) table.getAttributes().get("footerClass");
		
		if (info.hasFooterFacets) {
			writer.startElement(TR_ELEMENT_NAME, table);
            writer.writeText("\n\t", table, null);
			
			for (UIColumn column : info.columns) {
				String columnFooterClass = (String) column.getAttributes().get("footerClass");
                writer.startElement(TD_ELEMENT_NAME, column);
                if (columnFooterClass != null) {
                    writer.writeAttribute(HTML5Attributes.CLASS, columnFooterClass, "columnFooterClass");
                } else if (footerClass != null) {
                    writer.writeAttribute(HTML5Attributes.CLASS, footerClass, "footerClass");
                }
                UIComponent facet = RendererUtils.getFacet(column, "footer");
                if (facet != null) {
                	writer.writeText("", table, null);
                    encodeRecursively(context, facet);
                }
                writer.endElement(TD_ELEMENT_NAME);
                writer.writeText("\n\t", table, null);
			}
			renderRowEnd(context, table, writer);
		}
		if (footer != null) {
            writer.startElement(TR_ELEMENT_NAME, footer);
            writer.startElement(TD_ELEMENT_NAME, footer);
            if (footerClass != null) {
                writer.writeAttribute(HTML5Attributes.CLASS, footerClass, "footerClass");
            }
            if(info.columns.size()>1) {
            	writer.writeAttribute(HTML5Attributes.COLSPAN, String.valueOf(info.columns.size()), null);
            }
            encodeRecursively(context, footer);
            writer.endElement(TD_ELEMENT_NAME);
            renderRowEnd(context, table, writer);
        }
		
		writer.endElement(TFOOT_ELEMENT_NAME);
        writer.writeText("\n", table, null);
	}
	
	/**
	 * Renders the &lt;/tr&gt; element.
	 * 
	 * @param context
	 * @param table
	 * @param writer
	 * @throws IOException
	 */
	protected void renderRowEnd(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {

		writer.endElement(TR_ELEMENT_NAME);
		writer.writeText("\n", table, null);
	}
	
	/**
	 * This renders an empty &lt;tr&gt; and &lt;td&gt; elements.
	 * @param component
	 * @param writer
	 * @throws IOException
	 */
	protected void renderEmptyTableRow(final UIComponent component, final ResponseWriter writer) throws IOException {
		writer.startElement(TR_ELEMENT_NAME, component);
		writer.startElement(TD_ELEMENT_NAME, component);
		writer.endElement(TD_ELEMENT_NAME);
		writer.endElement(TR_ELEMENT_NAME);
	}
	
	// ------------------------------------------------------- Private Methods
	
	private List<Integer> getBodyRows(UIData data) {

        List<Integer> result = null;
        String bodyRows = (String) data.getAttributes().get("bodyrows");
        if (bodyRows != null) {
            String [] rows = bodyRows.split(",");
            if (rows != null) {
                result = new ArrayList<Integer>(rows.length);
                for (String curRow : rows) {
                    result.add(Integer.valueOf(curRow));
                }
            }
        }

        return result;
     }
    
    private void renderEmptyTableBody(final ResponseWriter writer, final UIComponent component) throws IOException {
    	
    	writer.startElement("tbody", component);
    	this.renderEmptyTableRow(writer, component);
    	writer.endElement("tbody");
    
    }
    
    private void renderEmptyTableRow(final ResponseWriter writer, final UIComponent component) throws IOException {
    	
    	writer.startElement("tr", component);
        List<UIColumn> columns = getColumns(component);
        for (UIColumn column : columns) {
            if (column.isRendered()) {
                writer.startElement("td", component);
                writer.endElement("td");
            }
        }
    	writer.endElement("tr");
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
    private List<UIColumn> getColumns(UIComponent table) {
		int childCount = table.getChildCount();
		if (childCount > 0) {
		    List<UIColumn> results = new ArrayList<UIColumn>(childCount);
		    for (UIComponent kid : table.getChildren()) {
		        if ((kid instanceof UIColumn) && kid.isRendered()) {
		            results.add((UIColumn) kid);
		        }
		    }
		    return results;
		} else {
		    return Collections.emptyList();
		}
    }
}
