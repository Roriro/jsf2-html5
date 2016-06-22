/**
 * 
 */
package za.co.sindi.jsf.html5.constants;

/**
 * These HTML5 attributes are defined from:
 * <ul>
 * 	<li><a href="http://dev.w3.org/html5/markup/global-attributes.html">HTML: The Markup Language (an HTML language reference)</a>
 * </ul>
 * 
 * @author Bienfait Sindi
 * @since 21 April 2013
 *
 */
public final class HTML5Attributes {

	/**
	 * Private Constructor
	 */
	private HTML5Attributes() {
		// TODO Auto-generated constructor stub
	}
	
	//Common attributes core
	public static final String ACCESSKEY = "accesskey";
	public static final String CLASS = "class";
	public static final String CONTENTEDITABLE = "contenteditable";
	public static final String CONTEXTMENU = "contextmenu";
	public static final String DIR = "dir";
	public static final String DRAGGABLE = "draggable";
	public static final String DROPZONE = "dropzone";
	public static final String HIDDEN = "hidden";
	public static final String ID = "id";
	public static final String LANG = "lang";
	public static final String SPELLCHECK = "spellcheck";
	public static final String STYLE = "style";
	public static final String TABINDEX = "tabindex";
	public static final String TITLE = "title";
	public static final String TRANSLATE = "translate";
	public static final String[] COMMON_ATTRIBUTES_CORE = {ACCESSKEY, CLASS, CONTENTEDITABLE, CONTEXTMENU, DIR, DRAGGABLE, DROPZONE, HIDDEN, ID, LANG, SPELLCHECK, STYLE, TABINDEX, TITLE, TRANSLATE };
	/**
	 * These are the same common attributes as the Common Attributes Core without the <code>class</code> and <code>id</code> attributes.
	 */
	public static final String[] JSF_HTML5_COMMON_ATTRIBUTES_CORE = {ACCESSKEY, CONTENTEDITABLE, CONTEXTMENU, DIR, DRAGGABLE, DROPZONE, HIDDEN, LANG, SPELLCHECK, STYLE, TABINDEX, TITLE, TRANSLATE };
	
	//Event Handler Attributes
	public static final String ONABORT = "onabort";
	public static final String ONBLUR = "onblur";
	public static final String ONCANCEL = "oncancel";
	public static final String ONCANPLAY = "oncanplay";
	public static final String ONCANPLAYTHROUGH = "oncanplaythrough";
	public static final String ONCHANGE = "onchange";
	public static final String ONCLICK = "onclick";
	public static final String ONCLOSE = "onclose";
	public static final String ONCONTEXTMENU = "oncontextmenu";
	public static final String ONCUECHANGE = "oncuechange";
	public static final String ONDBLCLICK = "ondblclick";
	public static final String ONDRAG = "ondrag";
	public static final String ONDRAGEND = "ondragend";
	public static final String ONDRAGENTER = "ondragenter";
	public static final String ONDRAGLEAVE = "ondragleave";
	public static final String ONDRAGOVER = "ondragover";
	public static final String ONDRAGSTART = "ondragstart";
	public static final String ONDROP = "ondrop";
	public static final String ONDURATIONCHANGE = "ondurationchange";
	public static final String ONEMPTIED = "onemptied";
	public static final String ONENDED = "onended";
	public static final String ONERROR = "onerror";
	public static final String ONFOCUS = "onfocus";
	public static final String ONFORMCHANGE = "onformchange";
	public static final String ONFORMINPUT = "onforminput";
	public static final String ONINPUT = "oninput";
	public static final String ONINVALID = "oninvalid";
	public static final String ONKEYDOWN = "onkeydown";
	public static final String ONKEYPRESS = "onkeypress";
	public static final String ONKEYUP = "onkeyup";
	public static final String ONLOAD = "onload";
	public static final String ONLOADEDDATA = "onloadeddata";
	public static final String ONLOADEDMETADATA = "onloadedmetadata";
	public static final String ONLOADSTART = "onloadstart";
	public static final String ONMOUSEDOWN = "onmousedown";
	public static final String ONMOUSEENTER = "onmouseenter";
	public static final String ONMOUSELEAVE = "onmouseleave";
	public static final String ONMOUSEMOVE = "onmousemove";
	public static final String ONMOUSEOUT = "onmouseout";
	public static final String ONMOUSEOVER = "onmouseover";
	public static final String ONMOUSEUP = "onmouseup";
	public static final String ONMOUSEWHEEL = "onmousewheel";
	public static final String ONPAUSE = "onpause";
	public static final String ONPLAY = "onplay";
	public static final String ONPLAYING = "onplaying";
	public static final String ONPROGRESS = "onprogress";
	public static final String ONRATECHANGE = "onratechange";
	public static final String ONREADYSTATECHANGE = "onreadystatechange";
	public static final String ONRESET = "onreset";
	public static final String ONRESIZE = "onresize";
	public static final String ONSCROLL = "onscroll";
	public static final String ONSEEKED = "onseeked";
	public static final String ONSEEKING = "onseeking";
	public static final String ONSELECT = "onselect";
	public static final String ONSHOW = "onshow";
	public static final String ONSTALLED = "onstalled";
	public static final String ONSUBMIT = "onsubmit";
	public static final String ONSUSPEND = "onsuspend";
	public static final String ONTIMEUPDATE = "ontimeupdate";
	public static final String ONTOGGLE = "ontoggle";
	public static final String ONVOLUMECHANGE = "onvolumechange";
	public static final String ONWAITING = "onwaiting";
	public static final String[] COMMON_ATTRIBUTES_EVENT_HANDLER = {ONABORT, ONBLUR, ONCANCEL, ONCANPLAY, ONCANPLAYTHROUGH, ONCHANGE, ONCLICK, ONCLOSE, /*ONCONTEXTMENU,*/ ONCUECHANGE, ONDBLCLICK, ONDRAG, ONDRAGEND, ONDRAGENTER, ONDRAGLEAVE, ONDRAGOVER, ONDRAGSTART, ONDROP, ONDURATIONCHANGE, ONEMPTIED, ONENDED, ONERROR, ONFOCUS, ONFORMCHANGE, ONFORMINPUT, ONINPUT, ONINVALID, ONKEYDOWN, ONKEYPRESS, ONKEYUP, ONLOAD, ONLOADEDDATA, ONLOADEDMETADATA, ONLOADSTART, ONMOUSEDOWN, ONMOUSEENTER, ONMOUSELEAVE, ONMOUSEMOVE, ONMOUSEOUT, ONMOUSEOVER, ONMOUSEUP, ONMOUSEWHEEL, ONPAUSE, ONPLAY, ONPLAYING, ONPROGRESS, ONRATECHANGE, ONREADYSTATECHANGE, ONRESET, ONRESIZE, ONSCROLL, ONSEEKED, ONSEEKING, ONSELECT, ONSHOW, ONSTALLED, ONSUBMIT, ONSUSPEND, ONTIMEUPDATE, ONTOGGLE, ONVOLUMECHANGE, ONWAITING};
//	public static final String[] COMMON_ATTRIBUTES__WITHOUT_ONCLICK_EVENT_HANDLER = {ONABORT, ONBLUR, ONCANCEL, ONCANPLAY, ONCANPLAYTHROUGH, ONCHANGE, ONCLOSE, /*ONCONTEXTMENU,*/ ONCUECHANGE, ONDBLCLICK, ONDRAG, ONDRAGEND, ONDRAGENTER, ONDRAGLEAVE, ONDRAGOVER, ONDRAGSTART, ONDROP, ONDURATIONCHANGE, ONEMPTIED, ONENDED, ONERROR, ONFOCUS, ONFORMCHANGE, ONFORMINPUT, ONINPUT, ONINVALID, ONKEYDOWN, ONKEYPRESS, ONKEYUP, ONLOAD, ONLOADEDDATA, ONLOADEDMETADATA, ONLOADSTART, ONMOUSEDOWN, ONMOUSEENTER, ONMOUSELEAVE, ONMOUSEMOVE, ONMOUSEOUT, ONMOUSEOVER, ONMOUSEUP, ONMOUSEWHEEL, ONPAUSE, ONPLAY, ONPLAYING, ONPROGRESS, ONRATECHANGE, ONREADYSTATECHANGE, ONRESET, ONRESIZE, ONSCROLL, ONSEEKED, ONSEEKING, ONSELECT, ONSHOW, ONSTALLED, ONSUBMIT, ONSUSPEND, ONTIMEUPDATE, ONTOGGLE, ONVOLUMECHANGE, ONWAITING};
	
	//XML attributes
	public static final String XML_LANG = "xml:lang";
	public static final String XML_SPACE = "xml:space";
	public static final String XML_BASE = "xml:base";
	public static final String[] COMMON_ATTRIBUTES_XML = {XML_LANG, XML_SPACE, XML_BASE};
	
	//HTML5 <html> attributes.
	public static final String MANIFEST = "manifest";
	
	//HTML5 <body> attributes.
	public static final String ONAFTERPRINT = "onafterprint";
	public static final String ONBEFOREPRINT = "onbeforeprint";
	public static final String ONBEFOREUNLOAD = "onbeforeunload";
	public static final String ONHASHCHANGE = "onhashchange";
	public static final String ONMESSAGE = "onmessage";
	public static final String ONOFFLINE = "onoffline";
	public static final String ONONLINE = "ononline";
	public static final String ONPAGEHIDE = "onpagehide";
	public static final String ONPAGESHOW = "onpageshow";
	public static final String ONPOPSTATE = "onpopstate";
//	public static final String ONRESIZE = "onresize";
	public static final String ONSTORAGE = "onstorage";
	public static final String ONUNLOAD = "onunload";
	
	//HTML5 <form> attributes
	public static final String ACTION = "action";
	public static final String METHOD = "method";
	public static final String ENCTYPE = "enctype";
	public static final String NAME = "name";
	public static final String ACCEPT_CHARSET = "accept-charset";
	public static final String NOVALIDATE = "novalidate";
	public static final String TARGET = "target";
	public static final String AUTOCOMPLETE = "autocomplete";
	
	//HTML5 <input> attributes
	public static final String TYPE = "type";
	public static final String VALUE = "value";
	public static final String DISABLED = "disabled";
	public static final String AUTOFOCUS = "autofocus";
	public static final String FORM = "form";
	public static final String MAXLENGTH = "maxlength";
	public static final String PLACEHOLDER = "placeholder";
	public static final String READONLY = "readonly";
	public static final String REQUIRED = "required";
	public static final String LIST = "list";
	public static final String PATTERN = "pattern";
	public static final String SIZE = "size";
	public static final String DIRNAME = "dirname";
	public static final String ROWS = "rows";
	public static final String WRAP = "wrap";
	public static final String COLS = "cols";
	public static final String STEP = "step";
	public static final String MIN = "min";
	public static final String MAX = "max";
	public static final String ACCEPT = "accept";
	public static final String MULTIPLE = "multiple";
	
	//Attributes only <input type="submit" />
	public static final String FORMACTION = "formaction";
	public static final String FORMENCTYPE = "formenctype";
	public static final String FORMMETHOD = "formmethod";
	public static final String FORMTARGET = "formtarget";
	public static final String FORMNOVALIDATE = "formnovalidate";
	
	//Attributes used by <audio>, <img>, <table> and <video> element
	public static final String SRC = "src";
	public static final String ALT = "alt";
	public static final String HEIGHT = "height";
	public static final String WIDTH = "width";
	public static final String USEMAP = "usemap";
	public static final String ISMAP = "ismap";
	public static final String BORDER = "border";
	
	//Attributes used by <audio> and <video> element
	public static final String AUTOPLAY = "autoplay";
	public static final String PRELOAD = "preload";
	public static final String CONTROLS = "controls";
	public static final String LOOP = "loop";
	public static final String POSTER = "poster";
	public static final String MEDIAGROUP = "mediagroup";
	public static final String MUTED = "muted";
	
	//Attributes used by <source> element
	public static final String MEDIA = "media";
	
	//Attributes used by <table>, <th>, <td> element
	public static final String SCOPE = "scope";
	
	//Attributes used by <th>, <td> element
	public static final String COLSPAN = "colspan";
	public static final String ROWSPAN = "rowspan";
	public static final String HEADERS = "headers";
	
	//Attributes used by <th> element
	public static final String ABBR = "abbr";
	public static final String SORTED = "sorted";
	
	public static enum HTML5PropertyKeys {
		accesskey,
		styleClass,
		contenteditable,
		contextmenu,
		dir,
		draggable,
		dropzone,
		hidden,
		id,
		lang,
		spellcheck,
		style,
		tabindex,
		title,
		translate,
		
		//Event-handlers
		onabort,
		onblur,
		oncancel,
		oncanplay,
		oncanplaythrough,
		onchange,
		onclick,
		onclose,
//		oncontextmenu,
		oncuechange,
		ondblclick,
		ondrag,
		ondragend,
		ondragenter,
		ondragleave,
		ondragover,
		ondragstart,
		ondrop,
		ondurationchange,
		onemptied,
		onended,
		onerror,
		onfocus,
		onformchange,
		onforminput,
		oninput,
		oninvalid,
		onkeydown,
		onkeypress,
		onkeyup,
		onload,
		onloadeddata,
		onloadedmetadata,
		onloadstart,
		onmousedown,
		onmouseenter,
		onmouseleave,
		onmousemove,
		onmouseout,
		onmouseover,
		onmouseup,
		onmousewheel,
		onpause,
		onplay,
		onplaying,
		onprogress,
		onratechange,
		onreadystatechange,
		onreset,
		onresize,
		onscroll,
		onseeked,
		onseeking,
		onselect,
		onshow,
		onstalled,
		onsubmit,
		onsuspend,
		ontimeupdate,
		ontoggle,
		onvolumechange,
		onwaiting
	}
}
