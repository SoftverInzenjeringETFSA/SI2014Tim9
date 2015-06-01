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
	public void testvalidirajBrojTakmicara1() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara("Jednostruki eliminacioni", 1));
	}
	@Test
	public void testvalidirajBrojTakmicara2() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara("Dvostruki eliminacioni", 15));
	}
	@Test
	public void testvalidirajBrojTakmicara3() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara("Swiss", -5));
	}
	@Test
	public void testvalidirajBrojTakmicara4() {
		
		assertTrue(DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara("Round Robin", 16));
	}
	
	@Test
	public void testvalidirajBrojTakmicara5() {
		
		assertTrue(!DodavanjeNovogIAzuriranjePostojecegTurnira.validirajBrojTakmicara("Swiss", 24));
	}


}
