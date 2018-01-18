package no.hvl.data102;

import java.util.Scanner;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {

	// lese opplysningene om en CD fra tastatur
	public CD lesCD() {

		Scanner in = new Scanner(System.in);

		CD ny = new CD();
		ny.setArtist(in.nextLine());
		ny.setCdCompany(in.nextLine());
		ny.setCdNumber(in.nextInt());
		ny.setCdTitle(in.nextLine());
		ny.setGenre(Genre.valueOf(in.nextLine().toUpperCase()));
		ny.setReleaseYear(in.nextInt());

		return ny;
	}

	// vise en CD med alle opplysninger på skjerm (husk tekst for sjanger)
	public void visCD(CD cd) {

		try {
			System.out.println(cd.toString());
		} catch (Exception e) {
			System.out.println("Fandt ikke CD'en");
		}
	}

	// Skrive ut alle CD-er med en spesiell delstreng i tittelen
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {

		CD[] cd = cda.sokTittel(delstreng);

		for (CD i : cd) {
			System.out.println(i.toString());
		}

	}

	// Skriver ut alle CD-er av en artist / en gruppe
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] ny = cda.sokArtist(delstreng);

		for (CD i : ny) {
			System.out.println(i.toString());
		}
	}

	// Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	// og hvor mange det er i hver sjanger

	public void skrivUtStatistikk(CDarkivADT cda) {
		Genre[] genre = Genre.values();

		for (int i = 0; i < genre.length; i++) {
			System.out.println(genre[i] + ": " + cda.hentAntall(genre[i]));
		}

	} // ... Ev. andre metoder

}