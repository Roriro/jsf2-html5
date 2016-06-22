/**
 * 
 */
package za.co.sindi.jsf.html5.component.output;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

import javax.faces.component.FacesComponent;

import za.co.sindi.common.collection.Lists;
import za.co.sindi.jsf.html5.component.HTML5UIOutput;


/**
 * @author Bienfait Sindi
 * @since 06 July 2013
 *
 */
@FacesComponent(HTML5Body.COMPONENT_TYPE)
public class HTML5Body extends HTML5UIOutput {

	public static final String COMPONENT_TYPE = "za.co.sindi.jsf.html5.HTML5Body";
	public static final String RENDERER_TYPE = "za.co.sindi.jsf.html5.Body";
//	private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(CollectionUtils.newArray(DEFAULT_EVENT_NAMES.toArray(new String[DEFAULT_EVENT_NAMES.size()])).concat(CollectionUtils.newArray("afterprint", "beforeprint", "beforeunload", "hashchange", "message", "offline", "online", "pagehide", "pageshow", "popstate", "resize", "storage", "unload")));
	private static final Collection<String> EVENT_NAMES = Collections.unmodifiableCollection(Lists.concat(DEFAULT_EVENT_NAMES, Arrays.asList("afterprint", "beforeprint", "beforeunload", "hashchange", "message", "offline", "online", "pagehide", "pageshow", "popstate", "resize", "storage", "unload")));
	
	protected enum PropertyKeys {
		onafterprint,
		onbeforeprint,
		onbeforeunload,
		onhashchange,
		onmessage,
		onoffline,
		ononline,
		onpagehide,
		onpageshow,
		onpopstate,
		onresize,
		onstorage,
		onunload
	}
	
	/**
	 * 
	 */
	public HTML5Body() {
		super();
		// TODO Auto-generated constructor stub
		setRendererType(RENDERER_TYPE);
	}

	/**
	 * @return the onafterprint
	 */
	public String getOnafterprint() {
		return (String) getStateHelper().eval(PropertyKeys.onafterprint);
	}

	/**
	 * @param onafterprint the onafterprint to set
	 */
	public void setOnafterprint(String onafterprint) {
		getStateHelper().put(PropertyKeys.onafterprint, onafterprint);
	}

	/**
	 * @return the onbeforeprint
	 */
	public String getOnbeforeprint() {
		return (String) getStateHelper().eval(PropertyKeys.onbeforeprint);
	}

	/**
	 * @param onbeforeprint the onbeforeprint to set
	 */
	public void setOnbeforeprint(String onbeforeprint) {
		getStateHelper().put(PropertyKeys.onbeforeprint, onbeforeprint);
	}

	/**
	 * @return the onbeforeunload
	 */
	public String getOnbeforeunload() {
		return (String) getStateHelper().eval(PropertyKeys.onbeforeunload);
	}

	/**
	 * @param onbeforeunload the onbeforeunload to set
	 */
	public void setOnbeforeunload(String onbeforeunload) {
		getStateHelper().put(PropertyKeys.onbeforeunload, onbeforeunload);
	}

	/**
	 * @return the onhashchange
	 */
	public String getOnhashchange() {
		return (String) getStateHelper().eval(PropertyKeys.onhashchange);
	}

	/**
	 * @param onhashchange the onhashchange to set
	 */
	public void setOnhashchange(String onhashchange) {
		getStateHelper().put(PropertyKeys.onhashchange, onhashchange);
	}

	/**
	 * @return the onmessage
	 */
	public String getOnmessage() {
		return (String) getStateHelper().eval(PropertyKeys.onmessage);
	}

	/**
	 * @param onmessage the onmessage to set
	 */
	public void setOnmessage(String onmessage) {
		getStateHelper().put(PropertyKeys.onmessage, onmessage);
	}

	/**
	 * @return the onoffline
	 */
	public String getOnoffline() {
		return (String) getStateHelper().eval(PropertyKeys.onoffline);
	}

	/**
	 * @param onoffline the onoffline to set
	 */
	public void setOnoffline(String onoffline) {
		getStateHelper().put(PropertyKeys.onoffline, onoffline);
	}

	/**
	 * @return the ononline
	 */
	public String getOnonline() {
		return (String) getStateHelper().eval(PropertyKeys.ononline);
	}

	/**
	 * @param ononline the ononline to set
	 */
	public void setOnonline(String ononline) {
		getStateHelper().put(PropertyKeys.ononline, ononline);
	}

	/**
	 * @return the onpagehide
	 */
	public String getOnpagehide() {
		return (String) getStateHelper().eval(PropertyKeys.onpagehide);
	}

	/**
	 * @param onpagehide the onpagehide to set
	 */
	public void setOnpagehide(String onpagehide) {
		getStateHelper().put(PropertyKeys.onpagehide, onpagehide);
	}

	/**
	 * @return the onpageshow
	 */
	public String getOnpageshow() {
		return (String) getStateHelper().eval(PropertyKeys.onpageshow);
	}

	/**
	 * @param onpageshow the onpageshow to set
	 */
	public void setOnpageshow(String onpageshow) {
		getStateHelper().put(PropertyKeys.onpageshow, onpageshow);
	}

	/**
	 * @return the onpopstate
	 */
	public String getOnpopstate() {
		return (String) getStateHelper().eval(PropertyKeys.onpopstate);
	}

	/**
	 * @param onpopstate the onpopstate to set
	 */
	public void setOnpopstate(String onpopstate) {
		getStateHelper().put(PropertyKeys.onpopstate, onpopstate);
	}

	/**
	 * @return the onresize
	 */
	public String getOnresize() {
		return (String) getStateHelper().eval(PropertyKeys.onresize);
	}

	/**
	 * @param onresize the onresize to set
	 */
	public void setOnresize(String onresize) {
		getStateHelper().put(PropertyKeys.onresize, onresize);
	}

	/**
	 * @return the onstorage
	 */
	public String getOnstorage() {
		return (String) getStateHelper().eval(PropertyKeys.onstorage);
	}

	/**
	 * @param onstorage the onstorage to set
	 */
	public void setOnstorage(String onstorage) {
		getStateHelper().put(PropertyKeys.onstorage, onstorage);
	}

	/**
	 * @return the onunload
	 */
	public String getOnunload() {
		return (String) getStateHelper().eval(PropertyKeys.onunload);
	}

	/**
	 * @param onunload the onunload to set
	 */
	public void setOnunload(String onunload) {
		getStateHelper().put(PropertyKeys.onunload, onunload);
	}

	/* (non-Javadoc)
	 * @see za.co.sindi.jsf.html5.component.HTML5UIOutput#getEventNames()
	 */
	@Override
	public Collection<String> getEventNames() {
		// TODO Auto-generated method stub
		return EVENT_NAMES;
	}
}
