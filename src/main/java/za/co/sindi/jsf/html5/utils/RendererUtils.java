/**
 * 
 */
package za.co.sindi.jsf.html5.utils;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.application.ProjectStage;
import javax.faces.application.Resource;
import javax.faces.component.UIComponent;
import javax.faces.component.UIViewRoot;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorHint;
import javax.faces.component.behavior.ClientBehaviorHolder;
import javax.faces.component.html.HtmlMessages;
import javax.faces.context.FacesContext;
import javax.faces.render.Renderer;

import za.co.sindi.jsf.html5.constants.HTML5Attributes;

/**
 * @author Bienfait Sindi
 * @since 07 May 2013
 * 
 */
public final class RendererUtils {

	private static final Logger LOGGER = Logger.getLogger(RendererUtils.class.getName());
	
	private RendererUtils() {
		// TODO: DO nothing
	}
	
	public static void validateParameters(FacesContext context, UIComponent component, Class<? extends UIComponent> componentClass) {
		if (context == null) {
			throw new NullPointerException("FacesContext may not be null.");
		}
		
		if (component == null) {
			throw new NullPointerException("UIComponent may not be null.");
		}
		
		if (componentClass != null && !componentClass.isInstance(component)) {
			throw new IllegalArgumentException("UIComponent " + getPathToComponent(component) + " is not an instanceof " + componentClass.getName());
		}
	}

	public static String getPathToComponent(UIComponent component) {
		StringBuilder buf = new StringBuilder();

		if (component == null) {
			buf.append("{Component-Path : ");
			buf.append("[null]}");
			return buf.toString();
		}

		getPathToComponent(component, buf);

		buf.insert(0, "{Component-Path : ");
		Object location = component.getAttributes().get(UIComponent.VIEW_LOCATION_KEY);
		if (location != null) {
			buf.append(" Location: ").append(location);
		}
		buf.append("}");

		return buf.toString();
	}

	public static void getPathToComponent(UIComponent component, StringBuilder buf) {
		if (component == null) {
			return;
		}

		StringBuilder intBuf = new StringBuilder();

		intBuf.append("[Class: ");
		intBuf.append(component.getClass().getName());
		if (component instanceof UIViewRoot) {
			intBuf.append(", ViewId: ");
			intBuf.append(((UIViewRoot) component).getViewId());
		} else {
			intBuf.append(",Id: ");
			intBuf.append(component.getId());
		}
		intBuf.append("]");

		buf.insert(0, intBuf.toString());

		getPathToComponent(component.getParent(), buf);
	}

//	public static Object getObjectValue(UIComponent component) {
//		if (!(component instanceof ValueHolder)) {
//			throw new IllegalArgumentException("Component : " + getPathToComponent(component) + " is not a ValueHolder.");
//		}
//
//		if (component instanceof EditableValueHolder) {
//			Object value = ((EditableValueHolder) component).getSubmittedValue();
//			if (value != null) {
//				return value;
//			}
//		}
//
//		return ((ValueHolder)component).getValue();
//	}

	public static boolean isDefaultAttributeValue(Object value) {
		if (value == null) {
			return true;
		}

		if (value instanceof Boolean) {
			return !((Boolean) value).booleanValue();
		}

		if (value instanceof Number) {
			if (value instanceof Integer) {
				return ((Number) value).intValue() == Integer.MIN_VALUE;
			}

			if (value instanceof Double) {
				return ((Number) value).doubleValue() == Double.MIN_VALUE;
			}

			if (value instanceof Long) {
				return ((Number) value).longValue() == Long.MIN_VALUE;
			}

			if (value instanceof Byte) {
				return ((Number) value).byteValue() == Byte.MIN_VALUE;
			}

			if (value instanceof Float) {
				return ((Number) value).floatValue() == Float.MIN_VALUE;
			}

			if (value instanceof Short) {
				return ((Number) value).shortValue() == Short.MIN_VALUE;
			}
		}

		return false;
	}
	
	public static boolean isAttributeValueRenderable(String attribute, Object value) {
		if (attribute == null || attribute.isEmpty() || value == null) {
			return false;
		}
		
//		if (HTML5Attributes.AUTOFOCUS.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
		if (HTML5Attributes.AUTOCOMPLETE.equals(attribute)) {
			return "on".equals(value) || "off".equals(value);
		}
		
//		if (HTML5Attributes.AUTOPLAY.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.CONTENTEDITABLE.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.CONTROLS.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
		if (HTML5Attributes.DIR.equals(attribute)) {
			return "ltr".equals(value) || "rtl".equals(value) || "auto".equals(value);
		}
		
//		if (HTML5Attributes.DRAGGABLE.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
		if (HTML5Attributes.HIDDEN.equals(attribute)) {
			return HTML5Attributes.HIDDEN.equals(value);
		}
		
//		if (HTML5Attributes.ISMAP.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.MULTIPLE.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.MUTED.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.LOOP.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.REQUIRED.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
//		if (HTML5Attributes.SPELLCHECK.equals(attribute)) {
//			return Boolean.TRUE.equals(value);
//		}
		
		if (HTML5Attributes.TRANSLATE.equals(attribute)) {
			return "yes".equals(value);
		}
		
		if (HTML5Attributes.WRAP.equals(attribute)) {
			return "soft".equals(value) || "hard".equals(value);
		}
		
		return true;
	}

	public static boolean isComponentDisabled(UIComponent component) {
		Object value = component.getAttributes().get("disabled");
		if (value == null) {
			return false;
		}
		
		if (value instanceof Boolean) {
			return (Boolean) value;
		}
		
		if (value instanceof String) {
			return "".equals(value) || "disabled".equals(value);
		}
		
		return false; //Boolean.valueOf(String.valueOf(value));
	}

	public static boolean isComponentReadOnly(UIComponent component) {
		Object value = component.getAttributes().get("readonly");
		if (value == null) {
			return false;
		}
		
		if (value instanceof Boolean) {
			return (Boolean) value;
		}
		
		if (value instanceof String) {
			return "".equals(value) || "readonly".equals(value);
		}
		
		return false; //Boolean.valueOf(String.valueOf(value));
	}
	
	public static boolean isSubmitting(ClientBehavior behavior) {
        return behavior.getHints().contains(ClientBehaviorHint.SUBMITTING);
    }
	
	@SuppressWarnings("unchecked")
	public static <T extends UIComponent> T findParentComponent(UIComponent component, Class<T> componentClass) {
		UIComponent parent = null;
		if (component != null && componentClass != null) {
			parent = component.getParent();
			while (parent != null && !componentClass.isInstance(parent)) {
				parent = parent.getParent();
			}
		}
		
		return (T) parent;
	}
	
//	public static List<ClientBehavior> getClientBehaviours(UIComponent component, String eventName) {
//		List<ClientBehavior> clientBehaviours = null;
//		
//		if (component instanceof ClientBehaviorHolder) {
//			ClientBehaviorHolder holder = (ClientBehaviorHolder) component;
//			if (holder.getClientBehaviors() != null && holder.getClientBehaviors().containsKey(eventName)) {
//				clientBehaviours = holder.getClientBehaviors().get(eventName);
//			}
//		}
//		
//		return clientBehaviours;
//	}
	
	public static void decodeClientBehaviours(FacesContext context, UIComponent component) {
		if (component instanceof ClientBehaviorHolder) {
			ClientBehaviorHolder clientBehaviorHolder = (ClientBehaviorHolder) component;
			Map<String, List<ClientBehavior>> clientBehaviours = clientBehaviorHolder.getClientBehaviors();
			if (clientBehaviours != null && !clientBehaviours.isEmpty()) {
				Map<String, String> requestParameters = context.getExternalContext().getRequestParameterMap();
				String behaviourEventName = requestParameters.get("javax.faces.behavior.event");
				
				if (behaviourEventName != null) {
					List<ClientBehavior> eventClientBehaviours = clientBehaviours.get(behaviourEventName);
					if (eventClientBehaviours != null && !eventClientBehaviours.isEmpty()) {
						String clientId = component.getClientId();
						String behaviourSource = requestParameters.get("javax.faces.source");
						
						if (clientId.equals(behaviourSource)) {
							for (ClientBehavior clientBehaviour : eventClientBehaviours) {
								clientBehaviour.decode(context, component);
							}
						}
					}
				}
			}
		}
	}
	
	public static UIComponent getFacet(UIComponent component, String name) {
		UIComponent facet = null;
		if (component.getFacetCount() > 0) {
			facet = component.getFacet(name);
		}
		
		return facet;
	}
	
	public static Resource getResource(FacesContext context, String libraryName, String resourceName) {
		return context.getApplication().getResourceHandler().createResource(resourceName, libraryName);
	}
	
	public static String getResourceURL(FacesContext context, Resource resource) {
		if (resource == null) {
			return null;
		}
		
		return context.getExternalContext().encodeResourceURL(resource.getRequestPath());
	}
	
	/**
	 * Copied from the Mojarra source.
	 * @param ctx
	 */
	public static void renderUnhandledMessages(FacesContext ctx) {

        if (ctx.isProjectStage(ProjectStage.Development)) {
            Application app = ctx.getApplication();
            HtmlMessages messages = (HtmlMessages) app.createComponent(HtmlMessages.COMPONENT_TYPE);
            messages.setId("javax_faces_developmentstage_messages");
            Renderer messagesRenderer = ctx.getRenderKit().getRenderer(HtmlMessages.COMPONENT_FAMILY, "javax.faces.Messages");
            messages.setErrorStyle("Color: red");
            messages.setWarnStyle("Color: orange");
            messages.setInfoStyle("Color: blue");
            messages.setFatalStyle("Color: red");
            messages.setTooltip(true);
            messages.setTitle("Project Stage[Development]: Unhandled Messages");
            messages.setRedisplay(false);
            try {
                messagesRenderer.encodeBegin(ctx, messages);
                messagesRenderer.encodeEnd(ctx, messages);
            } catch (IOException ioe) {
                if (LOGGER.isLoggable(Level.SEVERE)) {
                    LOGGER.log(Level.SEVERE, ioe.toString(), ioe);
                }
            }
        } else {
            Iterator<String> clientIds = ctx.getClientIdsWithMessages();
            int messageCount = 0;
            if (clientIds.hasNext()) {
                //Display each message possibly not displayed.
                StringBuilder builder = new StringBuilder();
                while (clientIds.hasNext()) {
                    String clientId = clientIds.next();
                    Iterator<FacesMessage> messages =
                          ctx.getMessages(clientId);
                    while (messages.hasNext()) {
                        FacesMessage message = messages.next();
                        if (message.isRendered()) {
                            continue;
                        }
                        messageCount++;
                        builder.append("\n");
                        builder.append("sourceId=").append(clientId);
                        builder.append("[severity=(")
                              .append(message.getSeverity());
                        builder.append("), summary=(")
                              .append(message.getSummary());
                        builder.append("), detail=(")
                              .append(message.getDetail()).append(")]");
                    }
                }
                if (messageCount > 0) {
                	if (LOGGER.isLoggable(Level.INFO)) {
                		LOGGER.log(Level.INFO, "jsf.non_displayed_message", builder.toString());
                	}
                }
            }
        }
    }
}
