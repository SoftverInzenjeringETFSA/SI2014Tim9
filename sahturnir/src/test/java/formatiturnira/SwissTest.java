package formatiturnira;
import klase.Takmicar;
import klase.Mec;
import klase.Turnir;
import static org.junit.Assert.*;



import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class SwissTest {

	@Test
	public void testSwiss() {
		try {
			Swiss s=new Swiss();
			assertTrue(true);
			} catch (Exception e) {
			fail("Izuzetak.");
			}
	}

	@Test
	public void testGenerisiMeceveNemaTakmicara() {
		try {
			Swiss s=new Swiss();
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			Turnir t=new Turnir();
			t.setId(5);
			s.GenerisiMeceve(takmicari, t);
			fail("Izuzetak!");
			} catch (Exception e) {
			assertTrue(true);
			}
	}
	@Test
	public void testGenerisiMeceveNemaTurnira() {
		try {
			Swiss s=new Swiss();
			Takmicar elma=new Takmicar();
			elma.setId(5);
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			takmicari.add(elma);
			Turnir t=new Turnir();
			s.GenerisiMeceve(takmicari, t);
			fail("Izuzetak!");
			} catch (Exception e) {
			assertTrue(true);
			}
	}
	@Test
	public void testGenerisiMeceveNedovoljanBrojTakmicara() {
		try {
			Swiss s=new Swiss();
			Takmicar elma=new Takmicar();
			elma.setId(5);
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			for(int i=0;i<5;i++)
			{
			takmicari.add(elma);
			}
			Turnir t=new Turnir();
			t.setId(5);
			s.GenerisiMeceve(takmicari, t);
			fail("Izuzetak!");
			} catch (Exception e) {
			assertTrue(true);
			}
	}
	@Test
	public void testGenerisiMeceveDobarSort() {
		try {
			Swiss s=new Swiss();
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			for(int i=0;i<4;i++)
			{
				Takmicar elma=new Takmicar();
				elma.setId(5-i);
				if(i%2==0)elma.setBrojBodova(5-i);
				if(i%2==1)elma.setBrojBodova(5+i);
				elma.setIme("elma"+String.valueOf(i));
				takmicari.add(elma);
			}
			
			Turnir t=new Turnir();
			t.setId(7);
			List<Mec> mecevi=new ArrayList<Mec>();
			mecevi=s.GenerisiMeceve(takmicari, t);
			
			assertTrue(s.takmicari.get(0).getBrojBodova()==(double)3);
			assertTrue(s.takmicari.get(3).getBrojBodova()==(double)8);
			assertTrue(s.takmicari.get(1).getBrojBodova()==(double)5);
			assertTrue(s.takmicari.get(2).getBrojBodova()==(double)6);
			
			//fail("Izuzetak!");
			} catch (Exception e) {
			//
			}
	}
	@Test
	public void testGenerisiMeceveUparivanje() {
		try {
			Swiss s=new Swiss();
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			for(int i=0;i<4;i++)
			{
				Takmicar elma=new Takmicar();
				elma.setId(5-i);
				if(i%2==0)elma.setBrojBodova(5-i);
				if(i%2==1)elma.setBrojBodova(5+i);
				elma.setIme("elma"+String.valueOf(i));
				takmicari.add(elma);
			}
			
			Turnir t=new Turnir();
			t.setId(7);
			List<Mec> mecevi=new ArrayList<Mec>();
			mecevi=s.GenerisiMeceve(takmicari, t);
			
			assertTrue(mecevi.get(0).getTakmicar1().getIme().equals("elma2"));
			assertTrue(mecevi.get(0).getTakmicar2().getIme().equals("elma0"));
			assertTrue(mecevi.get(1).getTakmicar1().getIme().equals("elma1"));
			assertTrue(mecevi.get(1).getTakmicar2().getIme().equals("elma3"));
			
			} catch (Exception e) {
			fail(e.getMessage());
			}
	}
}
