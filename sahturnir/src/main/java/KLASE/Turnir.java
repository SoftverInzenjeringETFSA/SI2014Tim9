package KLASE;

import java.io.Serializable;
import java.util.Date;

public class Turnir implements Serializable{

	private long id;
	private String naziv;
	private Date datumPocetka;
	private int trajanje;
	private String formatTakmicenja;
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Date getDatumPocetka() {
		return datumPocetka;
	}
	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
	public int getTrajanje() {
		return trajanje;
	}
	public void setTrajanje(int trajanje) {
		this.trajanje = trajanje;
	}
	public String getFormatTakmicenja() {
		return formatTakmicenja;
	}
	public void setFormatTakmicenja(String formatTakmicenja) {
		this.formatTakmicenja = formatTakmicenja;
	}
	
}
