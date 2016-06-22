/**
 * 
 */
package za.co.sindi.jsf.html5.component;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.faces.component.behavior.ClientBehaviorHolder;

import za.co.sindi.jsf.html5.HTML5AttributeProperties;

/**
 * @author Bienfait Sindi
 * @since 05 May 2013
 * 
 */
public interface HTML5UIComponent extends ClientBehaviorHolder, HTML5AttributeProperties {

	public static final String[] DEFAULT_HTML5_EVENT_NAMES = new String[] {
					"abort", "blur", "cancel", "canplay",
					"canplaythrough", "change", "click", "close", /*"contextmenu",*/ 
					"cuechange", "dblclick", "drag", "dragend",	"dragenter", 
					"dragleave", "dragover", "dragstart", "drop", "durationchange", 
					"emptied", "ended", "input", "invalid",	"keydown", "keypress",
					"keyup", "loadeddata", "loadedmetadata", "loadstart", "mousedown",
					"mouseenter", "mouseleave", "mousemove", "mouseout", "mouseover", 
					"mouseup", "mousewheel", "pause", "play", "playing", "progress",
					"ratechange", "reset", "resize", "scroll", "seeked", "seeking",
					"select", "show", "stalled", "submit", "suspend", "timeupdate", 
					"toggle", "volumechange", "waiting"};
	public static final Collection<String> DEFAULT_EVENT_NAMES = Collections
			.unmodifiableList(Arrays.asList(DEFAULT_HTML5_EVENT_NAMES));
	
//	public static final Collection<String> DEFAULT_VALUE_CHANGE_EVENT_NAMES = Collections
//			.unmodifiableCollection(CollectionUtils.newArray(DEFAULT_HTML5_EVENT_NAMES).append("valueChange"));
	
	public static final Collection<String> DEFAULT_VALUE_CHANGE_EVENT_NAMES = Collections
			.unmodifiableList(Arrays.asList(za.co.sindi.common.collection.Arrays.append(DEFAULT_HTML5_EVENT_NAMES, "valueChange")));
	
//	public static final Collection<String> DEFAULT_ACTION_EVENT_NAMES = Collections
//			.unmodifiableCollection(CollectionUtils.newArray(DEFAULT_HTML5_EVENT_NAMES).append("action"));
	public static final Collection<String> DEFAULT_ACTION_EVENT_NAMES = Collections
			.unmodifiableList(Arrays.asList(za.co.sindi.common.collection.Arrays.append(DEFAULT_HTML5_EVENT_NAMES, "action")));
}
