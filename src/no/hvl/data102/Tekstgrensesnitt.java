package no.hvl.data102;

import java.util.Scanner;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {

		Scanner in = new Scanner(System.in);

		CD ny = new CD();
		
		try {
		System.out.println("Artist: ");
		ny.setArtist(in.next());
		System.out.println("Selskap: ");
		ny.setCdCompany(in.next());
		System.out.println("CD nummer: ");
		ny.setCdNumber(in.nextInt());
		System.out.println("CD Tittel: ");
		ny.setCdTitle(in.next());
		System.out.println("Genre: ");
		ny.setGenre(Genre.valueOf(in.next().toUpperCase()));
		System.out.println("År: ");
		ny.setReleaseYear(in.nextInt());
		}catch (Exception e) {
			System.out.println("Opgi korrekt data format.");
		}

		return ny;
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {

		try {
			String[] ny = cd.toString().split("#");
			
			System.out.println("Artist: " + ny[1]);
			System.out.println("Selskap: " + ny[5]);
			System.out.println("CD nummer: " + ny[0]);
			System.out.println("CD Tittel: " + ny[2]);
			System.out.println("Genre: " + ny[4]);
			System.out.println("År: " + ny[3]);
			
		} catch (Exception e) {
			System.out.println("Fandt ikke CD'en");
		}
	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {

		CD[] cd = cda.sokTittel(delstreng);

		for (CD i : cd) {
			visCD(i);
		}

	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] ny = cda.sokArtist(delstreng);

		for (CD i : ny) {
			visCD(i);
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger

	public void skrivUtStatistikk(CDarkivADT cda) {
		Genre[] genre = Genre.values();

		for (int i = 0; i < genre.length; i++) {
			System.out.println(genre[i] + ": " + cda.hentAntall(genre[i]));
		}

	}
	
	public void skrivAlle(CDarkivADT cda) {
		for(CD cd : cda.hentCdTabell()) {
			visCD(cd);
			System.out.println();
		}
	}

}