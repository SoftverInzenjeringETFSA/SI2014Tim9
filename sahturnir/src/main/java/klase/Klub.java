package klase;

import java.util.Date;

import dal.KlubDAO;

public class Klub implements java.io.Serializable , Comparable<Klub> {

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
	 
    public int compareTo(Klub t) {
       KlubDAO k=new KlubDAO();
	double d1=k.calculateClubPoints(this.getId());
	double d2=k.calculateClubPoints(t.getId());
	
	
       if ((d1 - d2)>(double)0)
        return -1;
       else if((d1 - d2)<(double)0)
    	   return 1;
       return 0;
        
    }
	 
	
	
}