package no.hvl.data102;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {

	private int antall = 0;
	private LinearNode<CD> start;
	private final String TOM = "CD arkivet er tomt";

	public CDarkiv2() {
		start = null;
		antall = 0;
	}

	@Override
	public CD[] hentCdTabell() {

		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (start == null) {
			System.out.println(TOM);
		} else {
			while (i < antall && denne != null) {
				tab[i] = denne.getElement();
				denne = denne.getNext();
				i++;
			}
		}
		return tab;
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> newNode = new LinearNode<CD>(nyCd);
		newNode.setNext(start); // Setter node til start
		start = newNode; // N� er start den nye noden
		antall++;

	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean delete = false;
		LinearNode<CD> tempNode = start;
		LinearNode<CD> neste = tempNode.getNext();

		if (start == null) { // sjekker om det er noen elementer
			return delete;
		}
		if (start.getElement().getCdNumber() == cdNr) { // hvis det er første element der skal slettes
			start = start.getNext();
			antall--;
			return true;
		}

		while (tempNode != null && delete != true) {

			if (tempNode.getElement().getCdNumber() == cdNr && neste == null) {// Hvis det er sidste elemente der skal
																				// slettes.
				tempNode = null;
				antall--;
			}
			if (neste.getElement().getCdNumber() == cdNr) {// sletter noder midt i tabellen
				tempNode.setNext(neste.getNext()); // hopper over noden som har cdnummeret
				delete = true;
				antall--;

			} else {
				tempNode = tempNode.getNext();
			}
		}
		return delete;
	}

	@Override
	public CD[] sokTittel(String delstreng) {

		CD[] tab = new CD[antall];
		int i = 0;
		LinearNode<CD> denne = start;

		if (antall == 0) {
			System.out.println(TOM);
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
			System.out.println(TOM);
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

		while (denne != null) {
			if (denne.getElement().getGenre() == sjanger) {
				nr++;
				denne = denne.getNext();
			} else {
				denne = denne.getNext();
			}
		}
		return nr;
	}

}
