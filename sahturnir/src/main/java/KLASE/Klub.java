package klase;

import java.util.Date;

public class Klub implements java.io.Serializable {

	public Klub() {
		// TODO Auto-generated constructor stub
	}

	private long id;
	private String naziv;
	private String sjediste;
	private Date datumOsnivanja;
	private String predsjednik;

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

	public Date getDatumOsnivanja() {
		return datumOsnivanja;
	}

	public void setDatumOsnivanja(Date datum) {
		this.datumOsnivanja = datum;
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