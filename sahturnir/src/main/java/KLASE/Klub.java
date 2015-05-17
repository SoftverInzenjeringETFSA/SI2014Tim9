package KLASE;

import java.util.Date;
import java.io.Serializable;

public class Klub implements Serializable {

	public Klub() {
		// TODO Auto-generated constructor stub
	}
	
	private long id;
	private String naziv;
	private String sjediste;
	private Date datum;
	private String predsjednik;
	
	
	public long getId() {
		return id;
	}
	public void setId(long id){
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public Date getDatum() {
		return datum;
	}
	public void setDatum(Date datum) {
		this.datum = datum;
	}
	public String getPredsjednik() {
		return predsjednik;
	}
	public void setPredsjednik(String predsjednik) {
		this.predsjednik = predsjednik;
	}
	public String getSjediste() {
		return sjediste;
	}
	public void setSjediste(String sjediste) {
		this.sjediste = sjediste;
	}
}