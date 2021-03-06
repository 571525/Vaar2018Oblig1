package no.hvl.data102;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;
/* CDarkiv2 er implementer og bliver brukt nå. 

public class CDarkiv implements CDarkivADT {

	private CD[] cdTabel;
	private int antall;

	public CDarkiv(int antall) {

		cdTabel = new CD[antall];
		this.antall = 0;
	}

	@Override
	public void leggTilCd(CD nyCd) {

		if (antall == cdTabel.length){
			utvidKapasitet();
		}
		else {
			cdTabel[antall] = nyCd;
			antall++;
		}

	}
	
	private void utvidKapasitet(){
		CD[] hjelpetabell = new CD[(int)Math.ceil(1.5 * cdTabel.length)]; 
		
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
		hjelpeTab = trimTab(hjelpeTab, j);
		return hjelpeTab;
	}

	private CD[] trimTab(CD[] tab, int n) { // n er antall elementer CD[] cdtab2 = new CD[n];
		int i = 0;
		CD[] cdtab2 = new CD[n];
		while (i < n) {
		         cdtab2[i] = tab[i];
		         i++;
		   }//while
		return cdtab2; }//

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
*/
