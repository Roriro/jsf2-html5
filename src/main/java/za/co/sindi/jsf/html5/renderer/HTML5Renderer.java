/**
 * 
 */
package za.co.sindi.jsf.html5.renderer;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.logging.Logger;

import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import javax.faces.render.Renderer;

import za.co.sindi.common.collection.Arrays;
import za.co.sindi.jsf.html5.constants.HTML5Attributes;
import za.co.sindi.jsf.html5.constants.JSFAttributes;
import za.co.sindi.jsf.html5.utils.ObjectUtils;
import za.co.sindi.jsf.html5.utils.RendererUtils;
import za.co.sindi.jsf.html5.utils.StringUtils;

/**
 * @author Bienfait Sindi
 * @since 04 May 2013
 *
 */
public abstract class HTML5Renderer extends Renderer {

	protected final Logger LOGGER = Logger.getLogger(this.getClass().getName());
//	protected static final String[] COMMON_ATTRIBUTES = CollectionUtils.newArray(HTML5Attributes.JSF_HTML5_COMMON_ATTRIBUTES_CORE).flatten(CollectionUtils.newArray(HTML5Attributes.COMMON_ATTRIBUTES_EVENT_HANDLER)).toArray(new String[HTML5Attributes.JSF_HTML5_COMMON_ATTRIBUTES_CORE.length + HTML5Attributes.COMMON_ATTRIBUTES_EVENT_HANDLER.length]);
	protected static final String[] COMMON_ATTRIBUTES = Arrays.concat(HTML5Attributes.JSF_HTML5_COMMON_ATTRIBUTES_CORE, HTML5Attributes.COMMON_ATTRIBUTES_EVENT_HANDLER);
	
	/**
     * @param component the component of interest
     *
     * @return true if this renderer should render an id attribute.
     */
    protected boolean shouldWriteIdAttribute(UIComponent component) {

        // By default we only write the id attribute if:
        //
        // - We have a non-auto-generated id, or...
        // - We have client behaviors.
        //
        // We assume that if client behaviors are present, they
        // may need access to the id (AjaxBehavior certainly does).

        String id;
        return (null != (id = component.getId()) &&
                    (!id.startsWith(UIViewRoot.UNIQUE_ID_PREFIX) ||
                        ((component instanceof ClientBehaviorHolder) &&
                          !((ClientBehaviorHolder)component).getClientBehaviors().isEmpty())));
    }

    protected void writeIdAttributeIfNecessary(ResponseWriter writer, FacesContext context, UIComponent component) throws IOException {

        if (shouldWriteIdAttribute(component)) {
        	writer.writeAttribute(HTML5Attributes.ID, component.getClientId(context), HTML5Attributes.ID);
        }
    }
    
    /**
     * We decode {@link UIComponent} that is not <code>disabled</code> <b>and</b> <code>readonly</code>.
     * @param component
     * @return
     */
    protected boolean shouldDecode(UIComponent component) {
    	return !RendererUtils.isComponentDisabled(component) && !RendererUtils.isComponentReadOnly(component);
    }
    
    protected boolean shouldEncode(UIComponent component) {
    	return component.isRendered();
    }
    
    /**
     * We don't render default JSF values.
     * @param attributeValue
     * @return
     */
    protected boolean shouldRenderAttribute(Object attributeValue) {
    	return !RendererUtils.isDefaultAttributeValue(attributeValue);
    }
    
    protected void writeStyleClassAttribute(ResponseWriter writer, UIComponent component) throws IOException {
    	String styleClass = (String) component.getAttributes().get(JSFAttributes.STYLECLASS);
		if (!StringUtils.isNullOrEmpty(styleClass)) {
			writer.writeAttribute(HTML5Attributes.CLASS, styleClass, JSFAttributes.STYLECLASS);
		}
    }
    
    protected void encodeResources(FacesContext context, String target) throws IOException {
    	UIViewRoot viewRoot = context.getViewRoot();
        ListIterator<UIComponent> iter = (viewRoot.getComponentResources(context, target)).listIterator();
        while (iter.hasNext()) {
            UIComponent resource = iter.next();
            resource.encodeAll(context);
        }
    }
    
    protected void encodeRecursively(FacesContext context, UIComponent component) throws IOException {
    	if (!shouldEncode(component)) {
    		return ;
    	}
    	
    	// Render this component and its children recursively
        component.encodeBegin(context);
        if (component.getRendersChildren()) {
            component.encodeChildren(context);
        } else {
            List<UIComponent> children = Collections.<UIComponent>emptyList();
            if (component.getChildCount() > 0) {
            	children = component.getChildren();
            }
            
            for (UIComponent child : children) {
            	encodeRecursively(context, child);
            }
        }
        
        component.encodeEnd(context);
    }
	
	protected void renderPassThroughAttributes(FacesContext context, UIComponent component, String[] attributes) throws IOException {
		if (attributes == null || attributes.length == 0) {
			return ;
		}
		
		Map<String, List<ClientBehavior>> clientBehavioursMap = null;
		ResponseWriter writer = context.getResponseWriter();
		
        if (component instanceof ClientBehaviorHolder) {
            clientBehavioursMap = ((ClientBehaviorHolder)component).getClientBehaviors();
        }

        // Don't render behaviour scripts if component is disabled
        if (clientBehavioursMap!= null && !clientBehavioursMap.isEmpty() && RendererUtils.isComponentDisabled(component)) {
            clientBehavioursMap = null;
        }
        
        if (clientBehavioursMap == null) {
        	clientBehavioursMap = Collections.emptyMap();
        }
        
        for (String attribute : attributes) {
        	Object value = component.getAttributes().get(attribute);
        	String eventName = (!ObjectUtils.isNull(attribute) && attribute.startsWith("on")) ? attribute.substring(2) : null;
        	boolean hasBehaviour = !StringUtils.isNullOrEmpty(eventName) && clientBehavioursMap.containsKey(eventName);
        	//Other event name should onclick event not found....
        	if (HTML5Attributes.ONCLICK.equals(attribute) && !hasBehaviour) {
        		eventName = "action";
        		hasBehaviour = clientBehavioursMap.containsKey(eventName);
        	}
        	
        	//Other event name should onchange event not found
        	if (HTML5Attributes.ONCHANGE.equals(attribute) && !hasBehaviour) {
        		eventName = "valueChange";
        		hasBehaviour = clientBehavioursMap.containsKey(eventName);
        	}
        	
        	if (value != null && shouldRenderAttribute(value) && RendererUtils.isAttributeValueRenderable(attribute, value) && !hasBehaviour) {
        		//Convert to appropriate value
        		if (HTML5Attributes.AUTOFOCUS.equals(attribute)) {
        			value = HTML5Attributes.AUTOFOCUS;
        		} else if (HTML5Attributes.AUTOPLAY.equals(attribute)) {
        			value = HTML5Attributes.AUTOPLAY;
        		} else if (HTML5Attributes.CONTROLS.equals(attribute)) {
        			value = HTML5Attributes.CONTROLS;
        		} else if (HTML5Attributes.DISABLED.equals(attribute)) {
        			value = HTML5Attributes.DISABLED;
        		} else if (HTML5Attributes.ISMAP.equals(attribute)) {
        			value = HTML5Attributes.ISMAP;
        		} else if (HTML5Attributes.LOOP.equals(attribute)) {
        			value = HTML5Attributes.LOOP;
        		} else if (HTML5Attributes.MULTIPLE.equals(attribute)) {
        			value = HTML5Attributes.MULTIPLE;
        		} else if (HTML5Attributes.REQUIRED.equals(attribute)) {
        			value = HTML5Attributes.REQUIRED;
        		}
        		
        		writer.writeAttribute(attribute, value, attribute);
        	} else if (hasBehaviour) {
    			List<ClientBehavior> behaviours = clientBehavioursMap.get(eventName);
				Collection<ClientBehaviorContext.Parameter> eventParameters = Collections.emptyList();
				ClientBehaviorContext clientBehaviorContext = ClientBehaviorContext.createClientBehaviorContext(context, component, eventName, component.getClientId(context), eventParameters);
				StringBuilder stringBuilder = new StringBuilder();
				
				if (behaviours.size() == 1) {
					stringBuilder.append(behaviours.get(0).getScript(clientBehaviorContext));
				} else {
					for (ClientBehavior behaviour : behaviours) {
						stringBuilder.append(behaviour.getScript(clientBehaviorContext));
						stringBuilder.append(";");
					}
				}
				
				writer.writeAttribute(attribute, stringBuilder.toString(), null);
    		}
        }
	}
	
	protected void writeDataAttributes(FacesContext context, UIComponent component) throws IOException {
		if (component.getAttributes().isEmpty()) {
			return ;
		}
		
		ResponseWriter writer = context.getResponseWriter();
		for (Entry<String, Object> entry : component.getAttributes().entrySet()) {
			String attributeName = entry.getKey();
			Object attributeValue = entry.getValue();
			if (attributeName != null && attributeName.startsWith("data-") && attributeValue != null) {
				writer.writeAttribute(attributeName, attributeValue, null);
			}
		}
	}
}
