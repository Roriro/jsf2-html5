/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;

import javax.faces.component.UIComponent;
import javax.faces.component.UIPanel;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.FacesRenderer;

import za.co.sindi.jsf.html5.component.panel.HTML5PanelGrid;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.utils.RendererUtils;

/**
 * @author Bienfait Sindi
 * @since 14 July 2015
 *
 */
@FacesRenderer(componentFamily=UIPanel.COMPONENT_FAMILY, rendererType=HTML5PanelGrid.RENDERER_TYPE)
public class HTML5GridRenderer extends HTML5BaseTableRenderer {

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
		RendererUtils.validateParameters(context, component, UIPanel.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		// Render the beginning of the table
        ResponseWriter writer = context.getResponseWriter();

        renderTableStart(context, component, writer);
        
        //Render caption facet (if any)
        renderCaption(context, component, writer);
        
        //Render header facet (if any)
        renderHeader(context, component, writer);
        
        //Render footer facet (if any)
        renderFooter(context, component, writer);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeChildren(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeChildren(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIPanel.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		 // Set up the variables we will need
        ResponseWriter writer = context.getResponseWriter();
        TableMetaInfo info = getMetaInfo(context, component);
        int columnCount = info.columns.size();
        boolean open = false;
        int i = 0;

        // Render our children, starting a new row as needed
        renderTableBodyStart(context, component, writer);
        boolean rowRendered = false;
        if (component.getChildCount() > 0) {
	        for (UIComponent child : component.getChildren()) {
	
	            if (!child.isRendered()) {
	                continue;
	            }
	            if ((i % columnCount) == 0) {
	                if (open) {
	                    renderRowEnd(context, component, writer);
	                }
	                renderRowStart(context, component, writer);
	                rowRendered = true;
	                open = true;
	                info.newRow();
	            }
	            renderRow(context, component, child, writer);
	            i++;
	        }
        }
        if (open) {
           renderRowEnd(context, component, writer);
        }
        if (!rowRendered) {
            this.renderEmptyTableRow(writer, component);
        }
        renderTableBodyEnd(context, component, writer);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#encodeEnd(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void encodeEnd(FacesContext context, UIComponent component) throws IOException {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIPanel.class);
		
		if (!shouldEncode(component)) {
			return ;
		}
		
		// Render the ending of this table
		 renderTableEnd(context, component, context.getResponseWriter());
		 
		 clearMetaInfo(context, component);
	}

	/* (non-Javadoc)
	 * @see javax.faces.render.Renderer#getRendersChildren()
	 */
	@Override
	public boolean getRendersChildren() {
		// TODO Auto-generated method stub
		return true;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BaseTableRenderer#renderHeader(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderHeader(FacesContext context, UIComponent table, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		TableMetaInfo info = getMetaInfo(context, table);
        UIComponent header = RendererUtils.getFacet(table, "header");
        String headerClass = (String) table.getAttributes().get("headerClass");
        if (header != null) {
            writer.startElement(THEAD_ELEMENT_NAME, table);
            writer.writeText("\n", table, null);
            writer.startElement(TR_ELEMENT_NAME, header);
            writer.startElement(TH_ELEMENT_NAME, header);
            if (headerClass != null) {
                writer.writeAttribute(HTML5Attributes.CLASS, headerClass, "headerClass");
            }
            writer.writeAttribute(HTML5Attributes.COLSPAN, String.valueOf(info.columns.size()), null);
            writer.writeAttribute(HTML5Attributes.SCOPE, "colgroup", null);
            encodeRecursively(context, header);
            writer.endElement(TH_ELEMENT_NAME);
            writer.endElement(TR_ELEMENT_NAME);
            writer.writeText("\n", table, null);
            writer.endElement(THEAD_ELEMENT_NAME);
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
        String footerClass = (String) table.getAttributes().get("footerClass");
        if (footer != null) {
            writer.startElement(TFOOT_ELEMENT_NAME, table);
            writer.writeText("\n", table, null);
            writer.startElement(TR_ELEMENT_NAME, footer);
            writer.startElement(TD_ELEMENT_NAME, footer);
            if (footerClass != null) {
                writer.writeAttribute(HTML5Attributes.CLASS, footerClass, "footerClass");
            }
            writer.writeAttribute(HTML5Attributes.COLSPAN, String.valueOf(info.columns.size()),null);
            encodeRecursively(context, footer);
            writer.endElement(TD_ELEMENT_NAME);
            writer.endElement(TR_ELEMENT_NAME);
            writer.writeText("\n", table, null);
            writer.endElement(TFOOT_ELEMENT_NAME);
            writer.writeText("\n", table, null);
        }
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BaseTableRenderer#renderRow(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderRow(FacesContext context, UIComponent table, UIComponent row, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		TableMetaInfo info = getMetaInfo(context, table);
        writer.startElement(TD_ELEMENT_NAME, table);
        String columnClass = info.getCurrentColumnClass();
        if (columnClass != null) {
            writer.writeAttribute(HTML5Attributes.CLASS, columnClass, "columns");
        }
        encodeRecursively(context, row);
        writer.endElement(TD_ELEMENT_NAME);
        writer.writeText("\n", table, null);
	}
	
	// ------------------------------------------------------- Private Methods


    private void renderEmptyTableRow(final ResponseWriter writer, final UIComponent component) throws IOException {

        writer.startElement(TR_ELEMENT_NAME, component);
        writer.startElement(TD_ELEMENT_NAME, component);
        writer.endElement(TD_ELEMENT_NAME);
        writer.endElement(TR_ELEMENT_NAME);

    }
}
