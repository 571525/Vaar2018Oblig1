package no.hvl.data102;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;

public class CDarkiv2 implements CDarkivADT {
	
	private int antall;
	private LinearNode<CD> start;
	
	public CDarkiv2() {
		start = null;
		antall = 0;
	}
	
	
	@Override
	public CD[] hentCdTabell() {
		return LinearNode<CD>; //Hvordan skal dette gjøres ??? dette fungerer jo ikke eheh
	}

	@Override
	public void leggTilCd(CD nyCd) {
		LinearNode<CD> newNode = new LinearNode<CD>(nyCd);
		newNode.setNext(start); // Setter node til start 
		start = newNode; //Nå er start den nye noden
		antall++;
		
	}

	@Override
	public boolean slettCd(int cdNr) {
		boolean delete = false;
		if(start == null) {  //sjekker om det er noen elementer
			return delete;
		}
		
		LinearNode<CD> tempNode = start;
		
		while(tempNode != null) {
			if(tempNode.getElement().getCdNumber() == cdNr) { 
				tempNode = tempNode.getNext();      //hopper over noden som har cdnummeret             
				delete = true;
			}
		}
		return delete;
	}

	@Override
	public CD[] sokTittel(String delstreng) {
		
		return null;
	}

	@Override
	public CD[] sokArtist(String delstreng) {
		
		return null;
	}

	@Override
	public int hentAntall() {
		
		return 0;
	}

	@Override
	public int hentAntall(Genre sjanger) {
		
		return 0;
	}
		
	
	
}
