package no.hvl.data102.adt;

import no.hvl.data102.CD;
import no.hvl.data102.CD.Genre;

public interface CDarkivADT {
	
	
	
	// Returnere en tabell av CD-er
	  CD[] hentCdTabell();
	  
	// Legger til en ny CD
	  void leggTilCd(CD nyCd);
	  
	 // Sletter en CD hvis den fins
	  boolean slettCd(int cdNr);
	  
	//Søker og henter CD-er med en gitt delstreng   
	  CD[] sokTittel(String delstreng);
	  
	//Søker og henter artister med en gitt delstreng   
	  CD[] sokArtist(String delstreng);
	
	  //Henter antall CD-er
	  int hentAntall();
	  
	// Henter antall CD-er for en gitt sjanger   
	  int hentAntall(Genre sjanger);

	  
}
