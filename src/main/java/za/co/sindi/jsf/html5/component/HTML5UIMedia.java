/**
 * 
 */
package za.co.sindi.jsf.html5.component;

/**
 * @author Bienfait Sindi
 * @since 06 September 2013
 *
 */
public abstract class HTML5UIMedia extends HTML5UIOutput {
	
	private enum PropertyKeys {
		library,
		name,
		autoplay,
		preload,
		controls,
		loop,
		mediagroup,
		muted
	}
	
	/**
	 * @return the library
	 */
	public String getLibrary() {
		return (String) getStateHelper().eval(PropertyKeys.library);
	}

	/**
	 * @param library the library to set
	 */
	public void setLibrary(String library) {
		getStateHelper().put(PropertyKeys.library, library);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return (String) getStateHelper().eval(PropertyKeys.name);
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		getStateHelper().put(PropertyKeys.name, name);
	}

	/**
	 * @return the autoplay
	 */
	public boolean isAutoplay() {
		return (Boolean) getStateHelper().eval(PropertyKeys.autoplay, false);
	}
	
	/**
	 * @param autoplay the autoplay to set
	 */
	public void setAutoplay(boolean autoplay) {
		getStateHelper().add(PropertyKeys.autoplay, autoplay);
	}
	
	/**
	 * @return the preload
	 */
	public String getPreload() {
		return (String) getStateHelper().eval(PropertyKeys.preload);
	}
	
	/**
	 * @param preload the preload to set
	 */
	public void setPreload(String preload) {
		getStateHelper().put(PropertyKeys.preload, preload);
	}
	
	/**
	 * @return the controls
	 */
	public boolean isControls() {
		return (Boolean) getStateHelper().eval(PropertyKeys.controls, false);
	}
	
	/**
	 * @param controls the controls to set
	 */
	public void setControls(boolean controls) {
		getStateHelper().put(PropertyKeys.controls, controls);
	}
	
	/**
	 * @return the loop
	 */
	public boolean isLoop() {
		return (Boolean) getStateHelper().eval(PropertyKeys.loop, false);
	}
	
	/**
	 * @param loop the loop to set
	 */
	public void setLoop(boolean loop) {
		getStateHelper().put(PropertyKeys.loop, loop);
	}
	
	/**
	 * @return the mediagroup
	 */
	public String getMediagroup() {
		return (String) getStateHelper().eval(PropertyKeys.mediagroup);
	}
	
	/**
	 * @param mediagroup the mediagroup to set
	 */
	public void setMediagroup(String mediagroup) {
		getStateHelper().put(PropertyKeys.mediagroup, mediagroup);
	}
	
	/**
	 * @return the muted
	 */
	public boolean isMuted() {
		return (Boolean) getStateHelper().eval(PropertyKeys.muted, false);
	}
	
	/**
	 * @param muted the muted to set
	 */
	public void setMuted(boolean muted) {
		getStateHelper().put(PropertyKeys.muted, muted);
	}

	/* (non-Javadoc)
	 * @see javax.faces.component.UIComponentBase#getDefaultEventName()
	 */
	@Override
	public String getDefaultEventName() {
		// TODO Auto-generated method stub
		return "play";
	}
}
