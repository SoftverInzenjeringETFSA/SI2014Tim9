package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class DodavanjeKorisnikaTest {

	@Test
	public void testValidirajPrazno1() {
		
		assertTrue(!DodavanjeKorisnika.validirajPrazno(""));
	}
	@Test
	public void testValidirajPrazno2() {
		
		assertTrue(!DodavanjeKorisnika.validirajPrazno(" "));
	}
	@Test
	public void testValidirajPrazno3() {
		
		assertTrue(DodavanjeKorisnika.validirajPrazno("Nesto"));
	}
	
	@Test
	public void testvalidirajPraznoPass1() {
		
		assertTrue(!DodavanjeKorisnika.validirajPraznoPass(("").toCharArray()));
	}
	@Test
	public void testvalidirajPraznoPass2() {
		
		assertTrue(DodavanjeKorisnika.validirajPraznoPass((" ").toCharArray()));
	}
	@Test
	public void testvalidirajPraznoPass3() {
		
		assertTrue(DodavanjeKorisnika.validirajPraznoPass(("Elma Kusundzija").toCharArray()));
	}
	
	
	
	@Test
	public void testvalidirajAlphaNum1() {
		
		assertTrue(DodavanjeKorisnika.validirajAlpha("Elma"));
	}
	@Test
	public void testvalidirajAlphaNum2() {
		
		assertTrue(!DodavanjeKorisnika.validirajAlpha("Elma-Kusundzija"));
	}

}
