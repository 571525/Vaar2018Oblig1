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

	public void nytArkivEllerLes() throws Exception {
		System.out.println(
				"Vil du: \n 1: Lese inn ett CD arkiv \n 2: Oprette et nytt CD arkiv \n Velg: ");

		valg = in.nextInt();
		if (valg==1) {
			System.out.println("Filnavn: ");
			String fil = in.next();

			try {
				boolean lest = false;
				while (lest != true) {

					cda = Fil.lesFraFil(fil);
					lest = true;
				}
			} catch (FileNotFoundException e) {
				throw new Exception ("Fil ikke funnnet");
			}
			
		}

		else if (valg == 2) {
			this.cda = new CDarkiv(100);
		}
	}

	public void start() {
		
		try {
		nytArkivEllerLes();
		}catch (Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			
		}

		
		do {
			System.out.println("" + "1: Legg CD til arkiv \n" + "2: Søk en CD \n" + "3: Søk artist \n"
					+ "4: Skriv ut Statistikk \n" + "0: Avslutt");
			
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
			}
		} while (valg != 0);

	}

}
