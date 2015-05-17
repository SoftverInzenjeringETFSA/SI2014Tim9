package KLASE;
import java.io.Serializable;

public class Korisnik extends Osoba implements Serializable {
	
	private long id;
	private String korisnickoIme;
	private String sifra;
	
	public Korisnik() {}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getKorisnickoIme() {
		return korisnickoIme;
	}
	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}
	public String getSifra() {
		return sifra;
	}
	public void setSifra(String sifra) {
		this.sifra = sifra;
	}
	
}
