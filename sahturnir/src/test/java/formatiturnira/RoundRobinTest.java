package formatiturnira;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import klase.Mec;
import klase.Takmicar;
import klase.Turnir;

import org.junit.Test;

public class RoundRobinTest {

	@Test
	public void testRoundRobin() {
		try {
			RoundRobin r=new RoundRobin();
			assertTrue(true);
			} catch (Exception e) {
			fail("Izuzetak.");
			}
	}
	@Test
	public void testGenerisiMeceveNemaTakmicara() {
		try {
			RoundRobin r=new RoundRobin();
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			Turnir t=new Turnir();
			t.setId(5);
			r.RoundRobinGenerator(takmicari, t);
			fail("Izuzetak!");
			} catch (Exception e) {
			assertTrue(true);
			}
	}
	@Test
	public void testGenerisiMeceveNemaTurnira() {
		try {
			RoundRobin s=new RoundRobin();
			Takmicar elma=new Takmicar();
			elma.setId(5);
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			takmicari.add(elma);
			Turnir t=new Turnir();
			s.RoundRobinGenerator(takmicari, t);
			fail("Izuzetak!");
			} catch (Exception e) {
			assertTrue(true);
			}
	}
	@Test
	public void testGenerisiMeceveNedovoljanBrojTakmicara() {
		try {
			RoundRobin s=new RoundRobin();
			Takmicar elma=new Takmicar();
			elma.setId(5);
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			for(int i=0;i<5;i++)
			{
			takmicari.add(elma);
			}
			Turnir t=new Turnir();
			t.setId(5);
			s.RoundRobinGenerator(takmicari, t);
			fail("Izuzetak!");
			} catch (Exception e) {
			assertTrue(true);
			}
	}
	@Test
	public void testGenerisiMeceveTacanBroj(){
		try {
			RoundRobin r=new RoundRobin();
			Takmicar elma=new Takmicar();
			elma.setId(5);
			List<Takmicar> takmicari=new ArrayList<Takmicar>();
			for(int i=0;i<16;i++)
			{
			takmicari.add(elma);
			}
			Turnir t=new Turnir();
			t.setId(5);
			
			
			assertTrue(r.RoundRobinGenerator(takmicari, t).size()==120);
			} catch (Exception e) {
			fail(e.getMessage());
			}
	}
	@Test
	public void testGenerisiMeceveUparivanje() {
		try {
			RoundRobin r=new RoundRobin();
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
			t.setId(5);
			List<Mec> mecevi=new ArrayList<Mec>();
			mecevi=r.RoundRobinGenerator(takmicari, t);
			assertTrue(mecevi.get(0).getTakmicar1().getIme().equals("elma0"));
			assertTrue(mecevi.get(0).getTakmicar2().getIme().equals("elma3"));
			assertTrue(mecevi.get(1).getTakmicar1().getIme().equals("elma1"));
			assertTrue(mecevi.get(1).getTakmicar2().getIme().equals("elma2"));
			
			} catch (Exception e) {
			fail(e.getMessage());
			}
	}
	

}
