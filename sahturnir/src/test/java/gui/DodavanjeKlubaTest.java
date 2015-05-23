package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class DodavanjeKlubaTest {

	@Test
	public void testValidirajPrazno1() {
		
		assertTrue(!DodavanjeKluba.validirajPrazno(""));
	}
	@Test
	public void testValidirajPrazno2() {
		
		assertTrue(!DodavanjeKluba.validirajPrazno(" "));
	}
	@Test
	public void testValidirajPrazno3() {
		
		assertTrue(DodavanjeKluba.validirajPrazno("Nesto"));
	}
	
	@Test
	public void testValidirajImePrezime1() {
		
		assertTrue(!DodavanjeKluba.validirajImePrezime(""));
	}
	@Test
	public void testValidirajImePrezime2() {
		
		assertTrue(!DodavanjeKluba.validirajImePrezime(" "));
	}
	@Test
	public void testValidirajImePrezime3() {
		
		assertTrue(DodavanjeKluba.validirajImePrezime("Elma Kusundzija"));
	}
	
	
	
	@Test
	public void testvalidirajAlphaNum1() {
		
		assertTrue(DodavanjeKluba.validirajAlphaNum("Elma Kusundzija"));
	}
	@Test
	public void testvalidirajAlphaNum2() {
		
		assertTrue(!DodavanjeKluba.validirajAlphaNum("Elma-Kusundzija"));
	}
	
	
}
