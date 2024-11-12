package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
import java.util.Arrays;
import java.util.stream.Collectors;
import no.hvl.dat100.oppgave1.*;

public class Blogg {

	private Innlegg innlegg[];
	private int nesteledig = 0;

	public Blogg() {
		this(20);
	}

	public Blogg(int lengde) {
		innlegg = new Innlegg[lengde];
	}

	public int getAntall() {  return nesteledig;  }
	
	public Innlegg[] getSamling() {
		return innlegg;
	}
	
	public int finnInnlegg(Innlegg innlegg) {
		for (int i = 0; i < nesteledig; i++)
			if (innlegg.erLik(this.innlegg[i]))
				return i;
		return -1;
	}

	public boolean finnes(Innlegg innlegg) {
		return (this.finnInnlegg(innlegg) >= 0) ? true : false;
	}

	public boolean ledigPlass() {  return innlegg.length != nesteledig;  }
	
	public boolean leggTil(Innlegg innlegg) {
		if (!this.ledigPlass()) return false;
		this.innlegg[nesteledig++] = innlegg;
		return true;
	}
	
	public String toString() {
	    return nesteledig + "\n" + 
	           Arrays.stream(innlegg, 0, nesteledig) // stream fordi jeg liker hvor fint det ser ut
	                 .map(Innlegg::toString)
	                 .collect(Collectors.joining());

	    /* loop versjon (mer effektiv men ikke like *fancy*)
	    String s = "" + nesteledig + "\n";
		for (int i = 0; i < nesteledig; i++) {
			s += innlegg[i].toString();
		}
		return s;
	    */
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	// så ikke at denne var valgfri før nå, så kan være den ikke er ritkig, men jeg sjekker ikke siden den bare er valgfri
	public boolean slett(Innlegg innlegg) {
		int i = this.finnInnlegg(innlegg);
		if (i == -1) return false;
		boolean found = false;
		for (int j = i + 1; j < nesteledig - 1; j++) {
			this.innlegg[j - 1] = this.innlegg[j];
		}
		this.innlegg[nesteledig-- - 1] = null;
		
		return true;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}
