package klase;
import klase.Takmicar;

import static org.junit.Assert.*;

import org.junit.Test;

public class TakmicarTest {

	@Test
	public void testComapareTo1() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(15);
		t2.setBrojBodova(2);
		assertTrue(t1.compareTo(t2)==1);
		
	}
	@Test
	public void testComapareTo2() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(15);
		t2.setBrojBodova(25);
		assertTrue(t1.compareTo(t2)==-1);
	}
	@Test
	public void testComapareTo3() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(15);
		t2.setBrojBodova(15);
		assertTrue(t1.compareTo(t2)==0);
		
	}
	@Test
	public void testComapareTo4() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(-15);
		t2.setBrojBodova(2);
		assertTrue(t1.compareTo(t2)!=1);
		
	}
	@Test
	public void testComapareTo5() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(15);
		t2.setBrojBodova(-25);
		assertTrue(t1.compareTo(t2)!=-1);
	}
	@Test
	public void testComapareTo6() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(-15);
		t2.setBrojBodova(15);
		assertTrue(t1.compareTo(t2)!=0);
		
	}
	@Test
	public void testComapareTo7() {
		Takmicar t1= new Takmicar();
		Takmicar t2= new Takmicar();
		t1.setBrojBodova(15.99999);
		t2.setBrojBodova(16);
		assertTrue(t1.compareTo(t2)==-1);
		
	}
}
