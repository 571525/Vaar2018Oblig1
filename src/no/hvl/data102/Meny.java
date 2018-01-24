package no.hvl.data102;

import java.io.FileNotFoundException;
import java.util.Scanner;

import no.hvl.data102.adt.CDarkivADT;

public class Meny {

	private Tekstgrensesnitt tekstgr;
	private CDarkivADT cda;
	private Scanner in = new Scanner(System.in);
	int valg;

	public Meny(CDarkivADT cda) {
		tekstgr = new Tekstgrensesnitt();
		this.cda = cda;
	}

	public boolean nytArkivEllerLes() {
		boolean lest = false;
		System.out.println("Vil du: \n 1: Lese inn ett CD arkiv \n 2: Oprette et nytt CD arkiv \n Velg: ");

		valg = in.nextInt();
		if (valg == 1) {
			System.out.println("Filnavn: ");
			String fil = in.next();

			try {
				 
					cda = Fil.lesFraFil(fil);
					lest = true;

			} catch (FileNotFoundException e) {
				System.out.println("Fil ikke funnet");
			}

		}

		else if (valg == 2) {
			this.cda = new CDarkiv(100);
			lest = true;
		}
		return lest;
	}

	public void start() {

		boolean start = false;

		start = nytArkivEllerLes();

		if (start == false) {
			System.out.println("Program avsluttet");
		} else {

			do {
				System.out.println("\n" + "1: Legg CD til arkiv \n" + "2: Søk en CD \n" + "3: Søk artist \n"
						+ "4: Skriv ut Statistikk \n" + "5: Lagre CD arkiv på fil \n" + "0: Avslutt");

				valg = in.nextInt();
				switch (valg) {
				case 1: {
					cda.leggTilCd(tekstgr.lesCD());
					break;
				}
				case 2: {
					System.out.println("CD tittel: ");
					String cd = in.next();
					tekstgr.skrivUtCdDelstrengITittel(cda, cd);
					break;
				}
				case 3: {
					System.out.println("Artist: ");
					String cd = in.next();
					tekstgr.skrivUtCdArtist(cda, cd);
					break;
				}
				case 4: {
					tekstgr.skrivUtStatistikk(cda);
					break;
				}
				case 5: {
					String filnavn;
					System.out.println("Navn på fil: ");
					filnavn = in.next() + ".txt";
					try {
						Fil.skrivTilFil(cda, filnavn);
					} catch (FileNotFoundException e) {
						System.out.println("Feil ved skriving");
					}
					break;
				}
				}
			} while (valg != 0);
		}

	}

}
