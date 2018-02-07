package no.hvl.dat102;

import static org.junit.Assert.assertEquals;
import org.junit.jupiter.api.Test;

import no.hvl.data102.CD;
import no.hvl.data102.CD.Genre;
import no.hvl.data102.CDarkiv2;

class TestCDarkiv2 {
	
	@Test
	void testHentCdTabell() {
	
		CDarkiv2 cda = new CDarkiv2();	
		
		assertEquals("Tomt arkiv",0 ,cda.hentAntall());
		
		CD cd1 = new CD(1, "Artist", "cdTitle", 2018, Genre.POP , "cdCompany");
		CD cd2 = new CD(2, "Artist", "cdTitle", 2018, Genre.POP , "cdCompany");
		cda.leggTilCd(cd1);
		cda.leggTilCd(cd2);
		
		assertEquals("2 i arkivet",2 ,cda.hentAntall());
		
		CD[] tab = new CD[2];
		tab[0] = cd2;
		tab[1] = cd1;//NOTE: kjedet speilvenner rekkefølgen av cd'erne
		
		assertEquals("Feil", tab[0], cda.hentCdTabell()[0]);
		assertEquals("Feil", tab[1], cda.hentCdTabell()[1]);
	}

	@Test
	void testLeggTilCdl() {
		CDarkiv2 cda = new CDarkiv2();	
		CD cd1 = new CD(1, "Artist", "cdTitle", 2018, Genre.POP , "cdCompany");
		cda.leggTilCd(cd1);
		
		assertEquals(cd1, cda.sokArtist("Artist")[0]);
	}
	@Test
	void testSlettCd() {
		CDarkiv2 cda = new CDarkiv2();	
		CD cd1 = new CD(1, "Artist1", "cdTitle1", 2018, Genre.POP , "cdCompany");
		CD cd2 = new CD(2, "Artist2", "cdTitle2", 2018, Genre.ROCK , "cdCompany");
		cda.leggTilCd(cd1);
		cda.leggTilCd(cd2);
		
		assertEquals("Tester at cd2 er lakt til", cd2, cda.hentCdTabell()[0]);
		assertEquals("Tester at cd1 er lakt til", cd1, cda.hentCdTabell()[1]);
		assertEquals("Tester at antall pop-cd'er er 1", 1, cda.hentAntall(Genre.POP));

		cda.slettCd(1);
		
		assertEquals("Tester at antall pop-cd'er er 0. CD er slettet da.", 0, cda.hentAntall(Genre.POP));
	}
	
	@Test
	void testSokTittel() {
		CDarkiv2 cda = new CDarkiv2();	
		CD cd1 = new CD(1, "Artist1", "cdTitle1", 2018, Genre.POP , "cdCompany");
		cda.leggTilCd(cd1);
		
		assertEquals("Tester om cd1 er lakt til", cd1, cda.sokTittel("cdTitle1")[0]);
	}
	
	@Test
	void testSokArtist() {
		CDarkiv2 cda = new CDarkiv2();	
		CD cd1 = new CD(1, "Artist1", "cdTitle1", 2018, Genre.POP , "cdCompany");
		cda.leggTilCd(cd1);
		
		assertEquals("Tester om cd1 er lakt til", cd1, cda.sokArtist("Artist1")[0]);	}
	
	@Test
	void testHentAntallMedSjangerSomParameter() {
		CDarkiv2 cda = new CDarkiv2();	
		CD cd1 = new CD(1, "Artist1", "cdTitle1", 2018, Genre.POP , "cdCompany");
		CD cd2 = new CD(2, "Artist2", "cdTitle2", 2018, Genre.ROCK , "cdCompany");
		cda.leggTilCd(cd1);
		cda.leggTilCd(cd2);	
	
		assertEquals("Ser om der 1 pop cd", 1, cda.hentAntall(Genre.POP));
		assertEquals("Ser om der 1 rock cd", 1, cda.hentAntall(Genre.ROCK));
		assertEquals("Ser om der 0 opera cd'er", 0, cda.hentAntall(Genre.OPERA));
		assertEquals("Ser om der 0 classic cd'er", 0, cda.hentAntall(Genre.CLASSIC));

	}
}
