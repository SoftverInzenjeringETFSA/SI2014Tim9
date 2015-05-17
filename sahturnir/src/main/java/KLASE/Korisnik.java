package KLASE;
import java.io.Serializable;


public class Korisnik extends Osoba implements Serializable {
		

	private long id;
	private int sifra;
	private String korisnickoIme;
	
	public Korisnik() {}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSifra() {
		return sifra;
	}

	public void setSifra(int sifra) {
		this.sifra = sifra;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	
	
	 
}
