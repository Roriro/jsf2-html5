/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.Iterator;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.model.SelectItem;
import javax.faces.render.FacesRenderer;

import za.co.sindi.javax.faces.component.UIExtensions;
import za.co.sindi.jsf.html5.component.ext.HTML5DataList;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.HTML5Elements;
import za.co.sindi.jsf.html5.constants.JSFAttributes;

/**
 * @author Bienfait Sindi
 * @since 28 August 2013
 *
 */
@FacesRenderer(componentFamily = UIExtensions.COMPONENT_FAMILY, rendererType = HTML5DataList.RENDERER_TYPE)
public class HTML5DataListRenderer extends HTML5SelectItemsRenderer {

	private static final String DATALIST_ELEMENT_NAME = HTML5Elements.DATALIST;
	
	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5SelectItemsRenderer#renderStartElement(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderStartElement(FacesContext context,	UIComponent component, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		if (writer == null) {
			writer = context.getResponseWriter();
		}
		
		writer.startElement(DATALIST_ELEMENT_NAME, component);
		writer.writeAttribute(HTML5Attributes.ID, component.getClientId(context), JSFAttributes.CLIENTID);
		writeStyleClassAttribute(writer, component);
		
		renderPassThroughAttributes(context, component, COMMON_ATTRIBUTES);
		writeDataAttributes(context, component);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5SelectItemsRenderer#renderEndElement(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
	 */
	@Override
	protected void renderEndElement(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
		// TODO Auto-generated method stub
		if (writer == null) {
			writer = context.getResponseWriter();
		}
		
		writer.write("\n");
		writer.endElement(DATALIST_ELEMENT_NAME);
		
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5SelectItemsRenderer#renderSelectItems(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter, java.util.Iterator)
	 */
	@Override
	protected void renderSelectItems(FacesContext context, UIComponent component, ResponseWriter writer, Iterator<SelectItem> selectItemIterator) throws IOException {
		// TODO Auto-generated method stub
		if (writer == null) {
			writer = context.getResponseWriter();
		}
		
		if (selectItemIterator != null) {
			while (selectItemIterator.hasNext()) {
				SelectItem item = selectItemIterator.next();
				if (item instanceof SelectItem) {
					if (item.getValue() != null) {
						writer.write("\n");
						writer.writeText("\t", component, null);
						writer.startElement(OPTION_ELEMENT_NAME, component);
						writer.writeAttribute(HTML5Attributes.VALUE, item.getValue().toString(), null);
						//Force closing the element.
						writer.endElement(OPTION_ELEMENT_NAME);
						writer.write("\n");
					}
				} //We don't render SelectItemGroup
			}
		}
	}
}
