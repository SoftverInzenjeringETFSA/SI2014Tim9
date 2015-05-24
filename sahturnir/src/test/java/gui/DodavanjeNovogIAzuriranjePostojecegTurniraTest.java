package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class DodavanjeNovogIAzuriranjePostojecegTurniraTest {


	@Test
	public void testValidirajPrazno1() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajPrazno(""));
	}
	@Test
	public void testValidirajPrazno2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajPrazno(" "));
	}
	@Test
	public void testValidirajPrazno3() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajPrazno("Nesto"));
	}
	
	@Test
	public void testValidirajImePrezime1() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajImePrezime(""));
	}
	@Test
	public void testValidirajImePrezime2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajImePrezime(" "));
	}
	@Test
	public void testValidirajImePrezime3() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajImePrezime("Elma Kusundzija"));
	}
	
	@Test
	public void testvalidirajAlpha1() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajAlpha("Elma"));
	}
	@Test
	public void testvalidirajAlpha2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajAlpha("Elma-Kusundzija"));
	}
	
	
	@Test
	public void testvalidirajAlphaNum1() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajAlphaNum("Elma Kusundzija"));
	}
	@Test
	public void testvalidirajAlphaNum2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajAlphaNum("Elma-Kusundzija"));
	}
	
	@Test
	public void testvalidirajJmbg1() {
		
	}
	@Test
	public void testvalidirajJmbg2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajJmbg(" "));
	}
	@Test
	public void testvalidirajJmbg3() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajJmbg("1234567891234"));
	}
	
	@Test
	public void testvalidirajBrojTakmicara1() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara(1));
	}
	@Test
	public void testvalidirajBrojTakmicara2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara(5));
	}
	@Test
	public void testvalidirajBrojTakmicara3() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara(-5));
	}
	@Test
	public void testvalidirajBrojTakmicara4() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara(16));
	}
	
	@Test
	public void testvalidirajBrojTakmicara5() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara(24));
	}


}
