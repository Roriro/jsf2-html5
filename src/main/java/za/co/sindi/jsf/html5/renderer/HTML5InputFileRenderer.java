/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import javax.faces.component.UIComponent;
import javax.faces.component.UIInput;
import javax.faces.context.FacesContext;
import javax.faces.convert.ConverterException;
import javax.faces.render.FacesRenderer;
import javax.servlet.http.HttpServletRequest;

import za.co.sindi.jsf.html5.component.input.HTML5InputFile;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.utils.RendererUtils;
import za.co.sindi.servlet.MultipartFile;
import za.co.sindi.servlet.MultipartHttpServletRequestWrapper;

/**
 * @author Bienfait Sindi
 * @since 19 August 2013
 *
 */
@FacesRenderer(componentFamily = "javax.faces.Input", rendererType = HTML5InputFile.RENDERER_TYPE)
public class HTML5InputFileRenderer extends HTML5InputRenderer {
	
	private static final String[] INPUT_FILE_ATTRIBUTES = {
		HTML5Attributes.ACCEPT,
		HTML5Attributes.AUTOFOCUS,
		HTML5Attributes.REQUIRED,
		HTML5Attributes.MULTIPLE
	};

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BasicInputRenderer#decode(javax.faces.context.FacesContext, javax.faces.component.UIComponent)
	 */
	@Override
	public void decode(FacesContext context, UIComponent component) {
		// TODO Auto-generated method stub
		RendererUtils.validateParameters(context, component, UIInput.class);
		
		if (!shouldDecode(component)) {
			return ;
		}
		
		RendererUtils.decodeClientBehaviours(context, component);
		
		//Simplistic file uploading technique.
		HttpServletRequest request = (HttpServletRequest)FacesContext.getCurrentInstance().getExternalContext().getRequest();
		if (request != null && request instanceof MultipartHttpServletRequestWrapper) {
			MultipartHttpServletRequestWrapper multipartRequest = (MultipartHttpServletRequestWrapper) request;
			String clientId = component.getClientId(context);
			if (multipartRequest.getFileMap().containsKey(clientId)) {
				//There is a file...
				MultipartFile[] files = multipartRequest.getFiles(clientId);
				if (files.length > 1) {
					setSubmittedValue(component, files);
				} else {
					setSubmittedValue(component, files[0]);
				}
			}
		}
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5BasicInputRenderer#getConvertedValue(javax.faces.context.FacesContext, javax.faces.component.UIComponent, java.lang.Object)
	 */
	@Override
	public Object getConvertedValue(FacesContext context, UIComponent component, Object submittedValue) throws ConverterException {
		// TODO Auto-generated method stub
//		if (submittedValue != null) {
//			if (submittedValue instanceof MultipartFile) {
//				return (MultipartFile) submittedValue;
//			}
//			
//			if (submittedValue instanceof MultipartFile[]) {
//				return (MultipartFile[]) submittedValue;
//			}
//		}
//		
//		return null;
		return submittedValue;
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#renderValueAttribute()
	 */
	@Override
	protected boolean renderValueAttribute() {
		// TODO Auto-generated method stub
		return false;
	}

//	/* (non-Javadoc)
//	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#renderAdditionalAttributes(javax.faces.context.FacesContext, javax.faces.component.UIComponent, javax.faces.context.ResponseWriter)
//	 */
//	@Override
//	protected void renderAdditionalAttributes(FacesContext context, UIComponent component, ResponseWriter writer) throws IOException {
//		// TODO Auto-generated method stub
//		Object value = component.getAttributes().get(HTML5Attributes.MULTIPLE);
//		if (value != null && !RendererUtils.isDefaultAttributeValue(value)) {
//			//multiple attribute
//			writer.writeAttribute(HTML5Attributes.MULTIPLE, HTML5Attributes.MULTIPLE, null);
//		}
//	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getInputType(javax.faces.component.UIComponent)
	 */
	@Override
	protected String getInputType(UIComponent component) {
		// TODO Auto-generated method stub
		return "file";
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.renderer.HTML5InputRenderer#getPassthroughAttributes()
	 */
	@Override
	protected String[] getPassthroughAttributes() {
		// TODO Auto-generated method stub
		return INPUT_FILE_ATTRIBUTES;
	}
}
