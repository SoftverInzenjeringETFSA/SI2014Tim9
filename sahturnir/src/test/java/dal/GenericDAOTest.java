package dal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import klase.Klub;
import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class GenericDAOTest {
	Klub k=new Klub();
	GenericDAO<Klub> g=new GenericDAO<Klub>();
	
	@Before
	public void method()
	{
		k.setId(2);
		Date date = new Date();
		k.setDatumOsnivanja(date);
		k.setNaziv("MojKlub");
		k.setPredsjednik("Elma");
		k.setSjediste("BucaPotok");
		g.create(k);
		
	}

	@Test
	public void testUpdate() {
		/*try{
			Klub b=new Klub();
		b= GenericDAO.loadById(Klub.class,k.getId());
		b.setNaziv("NekiNaziv");
		g.update(b);
		b= GenericDAO.loadById(Klub.class,k.getId());
		assertTrue(1==1);
		}
		catch(Exception e)
		{
			fail("Greska");
		}*/
	}

	@Test
	public void testLoadById() {
		/*try{
			Klub b=new Klub();
		b= GenericDAO.loadById(Klub.class,k.getId());
		assertTrue(b.getId()==k.getId());}
	catch(Exception e)
	{
		fail("Greska");
	}
		*/
	}

	@Test
	public void testUpdate2() {
		assertFalse(GenericDAO.getAll(Klub.class).isEmpty());
		
	}


}
