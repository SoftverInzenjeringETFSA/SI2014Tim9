package sahturnir;

import java.util.Scanner;
import org.hibernate.Transaction;
import org.hibernate.Session;
import utils.HibernateUtil;
import klase.Turnir;
import klase.Mec;
import klase.Takmicar;
import klase.Klub;
import java.util.Date;

public class App {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		dodajNesto(session);
		//nadjiNesto(session);
		session.close();
	}

	private static void dodajNesto(Session session) {
		Transaction t1 = session.beginTransaction();
		Takmicar t = new Takmicar();
		Klub k = new Klub();
		k.setNaziv("zoooooooooooohooooooooooooooooo");
		k.setSjediste("Uzavreli grad");
		k.setPredsjednik("Kiss Kiss");
		k.setDatumOsnivanja(new Date());
		t.setId(1);
		t.setIme("imendan");
		t.setPrezime("prezimendan");
		t.setJmbg("1234517851734");
		t.setBrojBodova(5);
		t.setDatumRodjenja(new Date());
		t.setKategorija("levat");
	    Turnir turnircic = new Turnir();
	    turnircic.setId(1);
		Mec m = new Mec();
		m.setTurnir(turnircic);
		m.setRezultat1(1.);
		m.setRezultat2(0.);
		m.setTakmicar1(t);
		m.setTakmicar2(t);
		Long id = (Long) session.save(m);
		//Long id1 = (Long) session.save(t);
		Long id2 = (Long) session.save(k);
		System.out.println("Pozz");
		t1.commit();
	}
}
