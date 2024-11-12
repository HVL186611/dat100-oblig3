package no.hvl.dat100.oppgave1;

import no.hvl.dat100.common.TODO;

public abstract class Innlegg {
	
	private int id;
	private String bruker;
	String dato;
	private int likes = 0;
	
	public Innlegg() {
		
	}
	
	public Innlegg(int id, String bruker, String dato) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
	}

	public Innlegg(int id, String bruker, String dato, int likes) {

		this.id = id;
		this.bruker = bruker;
		this.dato = dato;
		this.likes = likes;
	}
	
	public String getBruker() {  return bruker;  }

	public void setBruker(String bruker) {  this.bruker = bruker;}

	public String getDato() {  return dato;  }

	public void setDato(String dato) {  this.dato = dato;  }

	public int getId() {  return id;  }

	public int getLikes() {  return likes;  }
	
	public void doLike () {  this.likes++;  }
	
	public boolean erLik(Innlegg innlegg) {  return id == innlegg.id;}
	
	@Override
	public String toString() {  return String.join("\n", Integer.toString(id), bruker, dato, Integer.toString(likes), "");  }
	
	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
	    String html = div(
	        div(c("User:") + p(c("User content placeholder"), "highlight") +
	            c("Date:") + p(c("Date content placeholder")), "content") +
	        
	        div(c("Likes:") + p(c("Likes count placeholder")), "content") +

	        div(c("Content placeholder"), "content")
	        
	    , "container");

	    return html;
	}
	
	// hjelper-metoder for html
	
	String C = "CLASS";
	String CT = "CONTENT";
	String ID = "ID";
	String SRC = "src";

	public String c(String s) {  return " <!-- " + s + " --> ";  }
	public String c() {  return c("");  }
	
	public String e(String element) {  return ("<ELEMENT " + c(C) + c(ID) + c(SRC) + ">" + c(CT) + "</ELEMENT>").replace("ELEMENT", element);  }
	public String e(String element, String content) {  return e(element).replace(c(CT), content);  }
	public String e(String element, String content, String clss) {  return e(element, content).replace(c(C), "class=" + clss);  }
	public String e(String element, String content, String clss, String id) {  return e(element, content, clss).replace(c(ID), "id=" + id);  }
	
	public String div(String content) {  return e("div", content);  }
	public String div(String content, String clss) {  return e("div", content, clss);  }
	public String div(String content, String clss, String id) {  return e("div", content, clss, id);  }
	
	public String p(String content) {  return e("p", content);  }
	public String p(String content, String clss) {  return p(content).replace(c(C), clss);  }
	public String p(String content, String clss, String id) {  return p(content).replace(c(C), clss).replace(c(ID), id);  }

	public String img(String url) {  return e("img").replace(c(SRC), "src=" + url);  }
	public String img(String url, String clss) {  return img(url).replace(c(C), "class=" + clss);  }
	public String img(String url, String clss, String id) {  return img(url, clss).replace(c(ID), "class=" + id);  }
}
