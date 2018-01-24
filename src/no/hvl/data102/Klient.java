package no.hvl.data102;

import no.hvl.data102.adt.CDarkivADT;

public class Klient {

	public static void main(String[] args) {
		CDarkivADT cda = new CDarkiv(10);
		Meny meny = new Meny(cda);
		
		meny.start();

	}

}
