package no.hvl.data102;

import java.util.Scanner;

import no.hvl.data102.CD.Genre;
import no.hvl.data102.adt.CDarkivADT;

public class Tekstgrensesnitt {

	/** leser opplysningene om en CD fra tastatur
	 * @return CD som er blevet oprettet.
	 */
	public CD lesCD() {

		Scanner in = new Scanner(System.in);
		

		CD ny = new CD();
			
		try {
		System.out.println("Artist: ");
		ny.setArtist(in.nextLine());
		System.out.println("Selskap: ");
		ny.setCdCompany(in.nextLine());
		System.out.println("CD nummer: ");
		ny.setCdNumber(Integer.parseInt(in.nextLine()));
		System.out.println("CD Tittel: ");
		ny.setCdTitle(in.nextLine());
		System.out.println("Genre: ");
		ny.setGenre(Genre.valueOf(in.next().toUpperCase()));
		System.out.println("År: ");
		ny.setReleaseYear(in.nextInt());
		}catch (Exception e) {
			System.out.println("Opgi korrekt data format.");
		}

		return ny;
	}

	/** Viser en CD med alle opplysninger på skjerm
	 * @param cd
	 */
	public void visCD(CD cd) {

		try {
			String[] ny = cd.toString().split("#");
			
			System.out.println("Artist: " + ny[1]);
			System.out.println("Selskap: " + ny[5]);
			System.out.println("CD nummer: " + ny[0]);
			System.out.println("CD Tittel: " + ny[2]);
			System.out.println("Genre: " + ny[4]);
			System.out.println("År: " + ny[3]);
			System.out.println();
			
		} catch (Exception e) {
			System.out.println("Fandt ikke CD'en");
		}
	}

	/** Skriver ut alle CD-er med en spesiell delstreng i tittelen
	 * @param cda
	 * @param delstreng
	 */
	public void skrivUtCdDelstrengITittel(CDarkivADT cda, String delstreng) {

		CD[] cd = cda.sokTittel(delstreng);

		for (CD i : cd) {
			visCD(i);
		}

	}

	/** Skriver ut alle CD-er av en artist / en gruppe
	 * @param cda
	 * @param delstreng
	 */
	public void skrivUtCdArtist(CDarkivADT cda, String delstreng) {
		CD[] ny = cda.sokArtist(delstreng);

		for (CD i : ny) {
			visCD(i);
		}
	}

	/** Skrive ut en enkel statistikk som inneholder antall CD-er totalt
	 * og hvor mange det er i hver sjanger
	 * @param cda
	 */
	public void skrivUtStatistikk(CDarkivADT cda) {
		Genre[] genre = Genre.values();
		
		System.out.println("Total antall CD'er: " + cda.hentAntall());

		for (int i = 0; i < genre.length; i++) {
			System.out.println(genre[i] + ": " + cda.hentAntall(genre[i]));
		}

	}
	
	public void skrivAlle(CDarkivADT cda) {
		for(CD cd : cda.hentCdTabell()) {
			visCD(cd);
			}
	}

}