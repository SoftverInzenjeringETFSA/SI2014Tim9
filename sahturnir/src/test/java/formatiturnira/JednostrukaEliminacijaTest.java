package formatiturnira;
import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import klase.Takmicar;
import klase.Mec;
import klase.Turnir;

public class JednostrukaEliminacijaTest {
	
	@Test
	public void testJednostrukaEliminacija() {
		try {
		JednostrukaEliminacija el =new JednostrukaEliminacija();
			assertTrue(true);
			} catch (Exception e) {
			fail("Izuzetak.");
			}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaPravilnimBrojemTakmicara(){
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<4; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, true);
			assertTrue(true);
			
		} catch(Exception e)
		{
		   fail("Izuzetak");			
		}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaNePravilnimBrojemTakmicara() {
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<15; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, true);
			fail("Nepravilan broj igraca");
			
		} catch(Exception e)
		{ assertTrue(true);	}
	}
	
	@Test
	public void testGenerisRunduSaPravilnimBrojemTakmicara(){
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<16; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, false);
			assertTrue(true);
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	}
	

	@Test
	public void testGenerisiRunduSaNePravilnimBrojemTakmicara() {
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<15; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, true);
			assertFalse(true);
			
		} catch(Exception e)
		{
		   //fail(e.getMessage());			
		}
	}
		

	@Test
	public void testGenerisiBezTakmicara() {
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, true);
			assertFalse(true);
			
		} catch(Exception e)
		{
		  // fail(e.getMessage());			
		}
	}
	@Test
	public void testGenerisiBezTurnira() {
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<15; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, true);
			assertFalse(true);
			
		} catch(Exception e)
		{
		  // fail(e.getMessage());			
		}
	}  
/*	@Test
	public void testGenerisiRundu() {
		try
		{
			JednostrukaEliminacija el = new JednostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=1; i<6; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i);
				takmicari.add(t);
			}
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRundu(takmicari, turnir, false);
			Takmicar a = new Takmicar(); a.setId(1);
			Takmicar b = new Takmicar(); a.setId(2);
			Takmicar c = new Takmicar(); a.setId(3);
			Takmicar d = new Takmicar(); a.setId(4);
			
			assertTrue (1==mecevi.get(0).getTakmicar1().getId());
			assertTrue (2==mecevi.get(0).getTakmicar2().getId());
			assertTrue (3==mecevi.get(1).getTakmicar1().getId());
			assertTrue (4==mecevi.get(1).getTakmicar2().getId());
			
			assertEquals (a.getId(), mecevi.get(0).getTakmicar1().getId());
			assertEquals (b.getId(), mecevi.get(0).getTakmicar2().getId());
			assertEquals (c.getId(), mecevi.get(1).getTakmicar1().getId());
			assertEquals (d.getId(), mecevi.get(1).getTakmicar2().getId());
			
		} catch(Exception e)
		{
		   fail("Izuzetak");			
		}
	} */

}
