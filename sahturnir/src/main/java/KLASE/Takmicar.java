package KLASE;

import java.util.Date;
import java.io.Serializable;

public class Takmicar implements Serializable {

	private long id;
	private Date datumRodjenja;
	private double brojBodova;
	private Klub klub;
	private String kategorija;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getDatumRodjenja() {
		return datumRodjenja;
	}
	public void setDatumRodjenja(Date datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}
	public double getBrojBodova() {
		return brojBodova;
	}
	public void setBrojBodova(double brojBodova) {
		this.brojBodova = brojBodova;
	}
	public Klub getKlub() {
		return klub;
	}
	public void setKlub(Klub klub) {
		this.klub = klub;
	}
	public String getKategorija() {
		return kategorija;
	}
	public void setKategorija(String kategorija) {
		this.kategorija = kategorija;
	}
}
