package no.hvl.dat100.oppgave2;

import no.hvl.dat100.common.TODO;

public class Bilde extends Tekst {

	private String url;
	
	public Bilde(int id, String bruker, String dato, String tekst, String url) {
		super(id, bruker, dato, tekst);
		this.url = url;
	}

	public Bilde(int id, String bruker, String dato, int likes, String tekst, String url) {
		super(id, bruker, dato, likes, tekst);
		this.url = url;
	}
	
	public String getUrl() {  return url;  }

	public void setUrl(String url) {  this.url = url;  }

	@Override
	public String toString() {
		return super.toString().replace("TEKST", "BILDE") + url + '\n';
	}

	// Metoden nedenfor er kun for valgfri oppgave 6
	public String toHTML() {
	    return super.toHTML()
	        .replace(c("User content placeholder"), p(getBruker(), "highlight"))
	        .replace(c("Date content placeholder"), p(getDato(), "content"))
	        .replace(c("Likes count placeholder"), p(Integer.toString(getLikes()), "content"))
	        .replace(c("Content placeholder"), img("https://example.com/image.jpg", "image"));
	}		
}
