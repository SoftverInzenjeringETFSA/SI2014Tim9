package klase;

import java.util.Date;

import dal.TakmicarDAO;

public class Takmicar extends Osoba implements java.io.Serializable , Comparable<Takmicar>  {

	

	private long id;
	private Date datumRodjenja;
	private double brojBodova;
	private Klub klub;
	private String kategorija;
	private int brojacPoraza;
	private Long brojTitula;

	public Takmicar() {
		// TODO Auto-generated constructor stub
		brojacPoraza =0;
	}

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
		 TakmicarDAO tdao = new TakmicarDAO();
         int[] omjer =  tdao.getMatchSummary(this.getId());
		 int brojPobjeda = omjer[0];
		 int brojNerijesenih = omjer[1];
		 int brojPoraza = omjer[2];
		 double bodovi = brojPobjeda*1.0d + brojNerijesenih*0.5d;
		 
		return bodovi;
	}

	public void setBrojBodova(double brojBodova) {
		TakmicarDAO tdao = new TakmicarDAO();
        int[] omjer =  tdao.getMatchSummary(this.getId());
		 int brojPobjeda = omjer[0];
		 int brojNerijesenih = omjer[1];
		 int brojPoraza = omjer[2];
		 double bodovi = brojPobjeda*1.0d + brojNerijesenih*0.5d;
		this.brojBodova = bodovi;
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
	
	 @Override
	    public int compareTo(Takmicar t) {
		 
	       if ((this.brojBodova - t.brojBodova)>(double)0)
	        return 1;
	       else if((this.brojBodova - t.brojBodova)<(double)0)
	    	   return -1;
	       return 0;
	        
	    }
	 
	public int getBrojacPoraza() {
		return brojacPoraza;
	}

	public void setBrojacPoraza(int brojacPoraza) {
		this.brojacPoraza = brojacPoraza;
	}
	
	public Long getBrojTitula() {
		return brojTitula;
	}

	public void setBrojTitula(Long brojTitula) {
		this.brojTitula = brojTitula;
	}
	
	 @Override public String toString() {
	      return this.getIme() + " " + this.getPrezime();
	    }
	
}
