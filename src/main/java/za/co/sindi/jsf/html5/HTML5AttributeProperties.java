/**
 * 
 */
package za.co.sindi.jsf.html5;

/**
 * @author Buhake Sindi
 * @since 24 April 2013
 *
 */
public interface HTML5AttributeProperties {
	
	//***Common attributes core***
	public String getAccesskey();
	public void setAccesskey(String accesskey);
	
	//HTML5 class attribute. Note, we did this to not clash with Object.getClass();
	public String getStyleClass();
	public void setStyleClass(String styleClass);
	
	public boolean isContenteditable();
	public void setContenteditable(boolean contenteditable);
	
	public String getDir();
	public void setDir(String dir);
	
	public boolean isDraggable();
	public void setDraggable(boolean draggable);
	
	public String getDropzone();
	public void setDropzone(String dropzone);
	
	public String getHidden();
	public void setHidden(String hidden);
	
	public String getId();
	public void setId(String id);
	
	public String getLang();
	public void setLang(String lang);
	
	public boolean isSpellcheck();
	public void setSpellcheck(boolean spellcheck);
	
	public String getStyle();
	public void setStyle(String style);
	
	public int getTabindex();
	public void setTabindex(int tabindex);
	
	public String getTitle();
	public void setTitle(String title);
	
	public String getTranslate();
	public void setTranslate(String translate);
	
	//***Event-handler attributes***
	public String getOnabort();
	public void setOnabort(String onabort);
	
	public String getOnblur();
	public void setOnblur(String onblur);
	
	public String getOncancel();
	public void setOncancel(String oncancel);
	
	public String getOncanplay();
	public void setOncanplay(String oncanplay);
	
	public String getOncanplaythrough();
	public void setOncanplaythrough(String oncanplaythrough);
	
	public String getOnchange();
	public void setOnchange(String onchange);
	
	public String getOnclick();
	public void setOnclick(String onclick);
	
	public String getOnclose();
	public void setOnclose(String onclose);
	
//	public String getOncontextmenu();
//	public void setOncontextmenu(String oncontextmenu);
	
	public String getOncuechange();
	public void setOncuechange(String oncuechange);
	
	public String getOndblclick();
	public void setOndblclick(String ondblclick);
	
	public String getOndrag();
	public void setOndrag(String ondrag);
	
	public String getOndragend();
	public void setOndragend(String ondragend);
	
	public String getOndragenter();
	public void setOndragenter(String ondragenter);
	
	public String getOndragleave();
	public void setOndragleave(String ondragleave);
	
	public String getOndragover();
	public void setOndragover(String ondragover);
	
	public String getOndragstart();
	public void setOndragstart(String ondragstart);
	
	public String getOndrop();
	public void setOndrop(String ondrop);
	
	public String getOndurationchange();
	public void setOndurationchange(String ondurationchange);
	
	public String getOnemptied();
	public void setOnemptied(String onemptied);
	
	public String getOnended();
	public void setOnended(String onended);
	
	public String getOnerror();
	public void setOnerror(String onerror);
	
	public String getOnfocus();
	public void setOnfocus(String onfocus);
	
	public String getOnformchange();
	public void setOnformchange(String onformchange);
	
	public String getOnforminput();
	public void setOnforminput(String onforminput);
	
	public String getOninput();
	public void setOninput(String oninput);
	
	public String getOninvalid();
	public void setOninvalid(String oninvalid);
	
	public String getOnkeydown();
	public void setOnkeydown(String onkeydown);
	
	public String getOnkeypress();
	public void setOnkeypress(String onkeypress);
	
	public String getOnkeyup();
	public void setOnkeyup(String onkeyup);
	
	public String getOnload();
	public void setOnload(String onload);
	
	public String getOnloadeddata();
	public void setOnloadeddata(String onloadeddata);
	
	public String getOnloadedmetadata();
	public void setOnloadedmetadata(String onloadedmetadata);
	
	public String getOnloadstart();
	public void setOnloadstart(String onloadstart);
	
	public String getOnmousedown();
	public void setOnmousedown(String onmousedown);
	
	public String getOnmouseenter();
	public void setOnmouseenter(String onmouseenter);
	
	public String getOnmouseleave();
	public void setOnmouseleave(String onmouseleave);
	
	public String getOnmousemove();
	public void setOnmousemove(String onmousemove);
	
	public String getOnmouseout();
	public void setOnmouseout(String onmouseout);
	
	public String getOnmouseover();
	public void setOnmouseover(String onmouseover);
	
	public String getOnmouseup();
	public void setOnmouseup(String onmouseup);
	
	public String getOnmousewheel();
	public void setOnmousewheel(String onmousewheel);
	
	public String getOnpause();
	public void setOnpause(String onpause);
	
	public String getOnplay();
	public void setOnplay(String onplay);
	
	public String getOnplaying();
	public void setOnplaying(String onplaying);
	
	public String getOnprogress();
	public void setOnprogress(String onprogress);
	
	public String getOnratechange();
	public void setOnratechange(String onratechange);
	
	public String getOnreadystatechange();
	public void setOnreadystatechange(String onreadystatechange);
	
	public String getOnreset();
	public void setOnreset(String onreset);
	
	public String getOnresize();
	public void setOnresize(String onresize);
	
	public String getOnscroll();
	public void setOnscroll(String onscroll);
	
	public String getOnseeked();
	public void setOnseeked(String onseeked);
	
	public String getOnseeking();
	public void setOnseeking(String onseeking);
	
	public String getOnselect();
	public void setOnselect(String onselect);
	
	public String getOnshow();
	public void setOnshow(String onshow);
	
	public String getOnstalled();
	public void setOnstalled(String onstalled);
	
	public String getOnsubmit();
	public void setOnsubmit(String onsubmit);
	
	public String getOnsuspend();
	public void setOnsuspend(String onsuspend);
	
	public String getOntimeupdate();
	public void setOntimeupdate(String ontimeupdate);
	
	public String getOntoggle();
	public void setOntoggle(String ontoggle);
	
	public String getOnvolumechange();
	public void setOnvolumechange(String onvolumechange);
	
	public String getOnwaiting();
	public void setOnwaiting(String onwaiting);
}
