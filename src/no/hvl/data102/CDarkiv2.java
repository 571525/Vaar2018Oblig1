package no.hvl.data102;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall = 0;
	private LinearNode<CD> start;

	public CDarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public CD[] hentCdTabell() {

		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println("CD arkivet er tomt");
		} else {
			while (i < antall && denne != null) {
				tab[i] = denne.getElement();
				denne = denne.getNext();
			}
		}
		return tab;
	}

	@Override
	public void leggTilCd(CD nyCd) {

		LinearNode<CD> ny = new LinearNode<CD>(nyCd);
		ny.setNext(start);
		start = ny;
		antall++;
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean slettet = false;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println("CD arkivet er tomt.");
		} else if (denne.getElement().getCdNumber() == cdNr) { // If it's the first element we need to delete.
			start = start.getNext();
			antall--;
		}

		else {
			while (slettet != true && denne != null) {
				if (denne.getNext().getElement().getCdNumber() == cdNr) {
					LinearNode<CD> neste = denne.getNext();
					denne.setNext(neste.getNext());
					antall--;
					slettet = true;
				} else {
					denne = denne.getNext();
				}
			}
		}
		return slettet;
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println("Arkivet er tomt");
		} else {
			while (denne != null) {
				if (denne.getElement().getCdTitle().contains(delstreng)) {
					tab[i] = denne.getElement();
					i++;
					denne = denne.getNext();
				} else {
					denne = denne.getNext();
				}
			}
		}

		return tab;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println("Arkivet er tomt");
		} else {
			while (denne != null) {
				if (denne.getElement().getArtist().contains(delstreng)) {
					tab[i] = denne.getElement();
					i++;
					denne = denne.getNext();
				} else {
					denne = denne.getNext();
				}
			}
		}

		return tab;
	}

	@Override
	public int hentAntall() {
		return antall;
	}

	@Override
	public int hentAntall(Genre sjanger) {
		LinearNode<CD> denne = start;
		int nr = 0;
		
		while(denne != null) {
			if (denne.getElement().getGenre() == sjanger) {
				nr++;
				denne = denne.getNext();
			}
			else {
				denne = denne.getNext();
			}
		}
		return nr;
	}
	

}
