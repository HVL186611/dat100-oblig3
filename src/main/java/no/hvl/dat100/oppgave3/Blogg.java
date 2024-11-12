package no.hvl.dat100.oppgave3;

import no.hvl.dat100.common.TODO;
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
		throw new UnsupportedOperationException(TODO.method());
	}

	// valgfrie oppgaver nedenfor
	
	public void utvid() {
		throw new UnsupportedOperationException(TODO.method());
	}
	
	public boolean leggTilUtvid(Innlegg innlegg) {

		throw new UnsupportedOperationException(TODO.method());
		
	}
	
	public boolean slett(Innlegg innlegg) {
		if (!this.finnes(innlegg)) return false;
		
		return true;
	}
	
	public int[] search(String keyword) {
		
		throw new UnsupportedOperationException(TODO.method());

	}
}