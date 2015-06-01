package gui;

import static org.junit.Assert.*;

import org.junit.Test;

public class DodavanjeTakmicaraTest {

	@Test
	public void testValidirajPrazno1() {
		
		assertTrue(!DodavanjeTakmicara.validirajPrazno(""));
	}
	@Test
	public void testValidirajPrazno2() {
		
		assertTrue(!DodavanjeTakmicara.validirajPrazno(" "));
	}
	@Test
	public void testValidirajPrazno3() {
		
		assertTrue(DodavanjeTakmicara.validirajPrazno("Nesto"));
	}
	
	@Test
	public void testvalidirajAlpha1() {
		
		assertTrue(DodavanjeTakmicara.validirajAlpha("Elma"));
	}
	
	@Test
	public void testvalidirajAlpha2() {
		
		assertTrue(!DodavanjeTakmicara.validirajAlpha("Elma-Kusundzija"));
	}
	
	@Test
	public void testvalidirajAlphaNum1() {
		
		assertTrue(DodavanjeTakmicara.validirajAlphaNum("Elma Kusundzija"));
	}
	@Test
	public void testvalidirajAlphaNum2() {
		
		assertTrue(!DodavanjeTakmicara.validirajAlphaNum("Elma-Kusundzija"));
	}
	
	@Test
	public void testvalidirajJmbg1() {
		
		assertTrue(!DodavanjeTakmicara.validirajJmbg(""));
	}
	@Test
	public void testvalidirajJmbg2() {
		
		assertTrue(!DodavanjeTakmicara.validirajJmbg(" "));
	}
	@Test
	public void testvalidirajJmbg3() {
		
		assertTrue(DodavanjeTakmicara.validirajJmbg("1234567891234"));
	}

}
