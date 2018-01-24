package no.hvl.data102;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;


public class CDarkiv implements CDarkivADT {

	private CD[] cdTabel;
	private int antall;

	public CDarkiv(int antall) {

		cdTabel = new CD[antall];
		this.antall = 0;
	}

	@Override
	public void leggTilCd(CD nyCd) {

		if (!erTom()) {
			System.out.println("Ingen ledig plass");
		}
		else if (antall == cdTabel.length){
			utvidKapasitet();
		}
		else {
			cdTabel[antall] = nyCd;
			antall++;
		}

	}
	
	private void utvidKapasitet(){
		CD[] hjelpetabell = new CD[(int)Math.ceil(1.1 * cdTabel.length)]; 
		
		for (int i = 0; i < cdTabel.length; i++){
		      hjelpetabell[i] = cdTabel[i];
		      }
		    cdTabel = hjelpetabell;
		}

	private boolean erTom() {
		return (antall == 0);
	}

	@Override
	public boolean slettCd(int cdNr) {
		
		boolean slettet = false;
		int i = 0;
		
		if(!erTom()) {
		while (slettet != true && antall > i) {
			if (cdTabel[i].getCdNumber() == cdNr) {
				cdTabel[i] = cdTabel[antall-1];
				cdTabel[antall - 1] = null;
				antall--;
				slettet = true;
			}
			else {
				i++;
			}
		}
		}
		return slettet;
		
	}

	@Override
	public CD[] hentCdTabell() {
		return cdTabel;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		CD[] hjelpeTab = new CD[antall];
		int j = 0;
		
		for (int i=0; i<antall; i++) {
			if(cdTabel[i].getCdTitle().contains(delstreng)) {
				hjelpeTab[j] = cdTabel[i];
				j++;
			}
		}
		return hjelpeTab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] hjelpeTab = new CD[antall];
		int j = 0;
		
		for (int i=0; i<antall; i++) {
			if(cdTabel[i].getArtist().contains(delstreng)) {
				hjelpeTab[j] = cdTabel[i];
				j++;
			}
		}
		return hjelpeTab;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Genre sjanger) {
		int total = 0;
		
		for(int i=0; i<antall; i++) {
			if(cdTabel[i].getGenre() == sjanger) {
				total++;
			}
		}
		
		return total;
	}


	
	
}
