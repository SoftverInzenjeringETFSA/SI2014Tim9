package formatiturnira;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

import org.junit.Test;

public class DvostrukaEliminacijaTest {

	

	@Test
	public void testDvostrukaEliminacijaWinners() {
		try {
		DvostrukaEliminacija el =new DvostrukaEliminacija();
			assertTrue(true);
			} catch (Exception e) {
			fail("Izuzetak.");
			}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaPravilnimBrojemTakmicaraWinners(){
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			assertTrue(mecevi.size()==2);
			
		} catch(Exception e)
		{
		   fail("Izuzetak");			
		}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaNePravilnimBrojemTakmicaraWinners() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			fail("Nepravilan broj igraca");
			
		} catch(Exception e)
		{ assertTrue(true);	}
	}
	
	@Test
	public void testGenerisRunduSaPravilnimBrojemTakmicaraWinners(){
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			assertTrue(true);
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	}
	

	@Test
	public void testGenerisiRunduSaNepravilnimBrojemTakmicaraWinners() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<3; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			fail("Izuzetak!");
			
		} catch(Exception e)
		{
		  		assertTrue(true);		
		}
	}
		

	@Test
	public void testGenerisiBezTakmicaraWinners() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			fail("greska!");
			
		} catch(Exception e)
		{
		  assertTrue(true);			
		}
	}
	@Test
	public void testGenerisiBezTurniraWinners() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<15; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			fail("greska!");
			
		} catch(Exception e)
		{
		  assertTrue(true);			
		}
	}  
	@Test
	public void testGenerisiRundu() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();

			List<Mec> mecevi = new ArrayList<Mec>();
			
			Takmicar a = new Takmicar(); a.setId(1);
			Takmicar b = new Takmicar(); b.setId(2);
			Takmicar c = new Takmicar(); c.setId(3);
			Takmicar d = new Takmicar(); d.setId(4);
			takmicari.add(a);
			takmicari.add(b);
			takmicari.add(c);
			takmicari.add(d);
			mecevi = el.GenerisiRunduWinners(takmicari, turnir);
			assertTrue (1==mecevi.get(0).getTakmicar1().getId());
			assertTrue (2==mecevi.get(0).getTakmicar2().getId());
			assertTrue (3==mecevi.get(1).getTakmicar1().getId());
			assertTrue (4==mecevi.get(1).getTakmicar2().getId());
			
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	} 
	
	@Test
	public void testDvostrukaEliminacijaLoosers() {
		try {
		DvostrukaEliminacija el =new DvostrukaEliminacija();
			assertTrue(true);
			} catch (Exception e) {
			fail("Izuzetak.");
			}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaPravilnimBrojemTakmicaraLoosers(){
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			assertTrue(mecevi.size()==2);
			
		} catch(Exception e)
		{
		   fail("Izuzetak");			
		}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaNePravilnimBrojemTakmicaraLoosers() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			fail("Nepravilan broj igraca");
			
		} catch(Exception e)
		{ assertTrue(true);	}
	}
	
	@Test
	public void testGenerisRunduSaPravilnimBrojemTakmicaraLoosers(){
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			assertTrue(true);
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	}
	

	@Test
	public void testGenerisiRunduSaNepravilnimBrojemTakmicaraLoosers() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<3; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			fail("Izuzetak!");
			
		} catch(Exception e)
		{
		  		assertTrue(true);		
		}
	}
		

	@Test
	public void testGenerisiBezTakmicaraLoosers() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			fail("greska!");
			
		} catch(Exception e)
		{
		  assertTrue(true);			
		}
	}
	@Test
	public void testGenerisiBezTurniraLoosers() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<15; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			fail("greska!");
			
		} catch(Exception e)
		{
		  assertTrue(true);			
		}
	}  
	@Test
	public void testGenerisiRunduLoosers() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();

			List<Mec> mecevi = new ArrayList<Mec>();
			
			Takmicar a = new Takmicar(); a.setId(1);
			Takmicar b = new Takmicar(); b.setId(2);
			Takmicar c = new Takmicar(); c.setId(3);
			Takmicar d = new Takmicar(); d.setId(4);
			takmicari.add(a);
			takmicari.add(b);
			takmicari.add(c);
			takmicari.add(d);
			mecevi = el.GenerisiRunduLoosers(takmicari, turnir);
			assertTrue (1==mecevi.get(0).getTakmicar1().getId());
			assertTrue (2==mecevi.get(0).getTakmicar2().getId());
			assertTrue (3==mecevi.get(1).getTakmicar1().getId());
			assertTrue (4==mecevi.get(1).getTakmicar2().getId());
			
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	} 



	
	
	@Test
	public void testDvostrukaEliminacija() {
		try {
		DvostrukaEliminacija el =new DvostrukaEliminacija();
			assertTrue(true);
			} catch (Exception e) {
			fail("Izuzetak.");
			}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaPravilnimBrojemTakmicara(){
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, true);
			assertTrue(mecevi.size()==2);
			
		} catch(Exception e)
		{
		   fail("Izuzetak");			
		}
	}
	
	@Test
	public void testGenerisiPrvuRunduSaNePravilnimBrojemTakmicara() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, true);
			fail("Nepravilan broj igraca");
			
		} catch(Exception e)
		{ assertTrue(true);	}
	}
	
	@Test
	public void testGenerisRunduSaPravilnimBrojemTakmicara(){
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
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
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, false);
			assertTrue(true);
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	}
	

	@Test
	public void testGenerisiPrvuRunduSaNepravilnimBrojemTakmicara() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<3; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, true);
			fail("Izuzetak!");
			
		} catch(Exception e)
		{
		  		assertTrue(true);		
		}
	}
		

	@Test
	public void testGenerisiBezTakmicara() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, true);
			fail("greska!");
			
		} catch(Exception e)
		{
		  assertTrue(true);			
		}
	}
	@Test
	public void testGenerisiBezTurnira() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			List<Takmicar> takmicari = new ArrayList<Takmicar>();
			for (int i=0; i<15; i++)
			{
				Takmicar t = new Takmicar();
				t.setId(i+1);
				takmicari.add(t);
			}
			List<Mec> mecevi = new ArrayList<Mec>();
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, true);
			fail("greska!");
			
		} catch(Exception e)
		{
		  assertTrue(true);			
		}
	}  
	@Test
	public void testGenerisiPrvuRundu() {
		try
		{
			DvostrukaEliminacija el = new DvostrukaEliminacija();
			Turnir turnir = new Turnir(); 
			turnir.setId(123);
			List<Takmicar> takmicari = new ArrayList<Takmicar>();

			List<Mec> mecevi = new ArrayList<Mec>();
			
			Takmicar a = new Takmicar(); a.setId(1);
			Takmicar b = new Takmicar(); b.setId(2);
			Takmicar c = new Takmicar(); c.setId(3);
			Takmicar d = new Takmicar(); d.setId(4);
			takmicari.add(a);
			takmicari.add(b);
			takmicari.add(c);
			takmicari.add(d);
			mecevi = el.GenerisiPrvuRundu(takmicari, turnir, false);
			assertTrue (2==mecevi.size());
			
		} catch(Exception e)
		{
		   fail(e.getMessage());			
		}
	} 
}
