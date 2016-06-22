/**
 * 
 */
package za.co.sindi.jsf.html5.model;

import java.io.Serializable;

/**
 * @author Bienfait Sindi
 * @since 09 September 2013
 *
 */
public class MediaSource implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -35976087044797014L;
	private String library;
	private String resourceName;
	private String value;
	private String type;
	private String media;
	
	/**
	 * @param value
	 * @param type
	 * @param media
	 */
	public MediaSource(String value, String type, String media) {
		this(null, null, type, media);
		this.value = value;
	}

	/**
	 * @param library
	 * @param resourceName
	 * @param type
	 * @param media
	 */
	public MediaSource(String library, String resourceName, String type, String media) {
		super();
		this.library = library;
		this.resourceName = resourceName;
		this.type = type;
		this.media = media;
	}

	/**
	 * @return the library
	 */
	public String getLibrary() {
		return library;
	}
	
	/**
	 * @param library the library to set
	 */
	public void setLibrary(String library) {
		this.library = library;
	}
	
	/**
	 * @return the resourceName
	 */
	public String getResourceName() {
		return resourceName;
	}
	
	/**
	 * @param resourceName the resourceName to set
	 */
	public void setResourceName(String resourceName) {
		this.resourceName = resourceName;
	}
	
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * @return the media
	 */
	public String getMedia() {
		return media;
	}
	
	/**
	 * @param media the media to set
	 */
	public void setMedia(String media) {
		this.media = media;
	}	
}
