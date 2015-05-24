package klase;

import java.util.Date;

public class Mec implements java.io.Serializable {

	public Mec() {
		// TODO Auto-generated constructor stub
	}

	private long id;
	private Turnir turnir;
	private Takmicar takmicar1;
	private Takmicar takmicar2;
	private Double rezultat1;
	private Double rezultat2;
	private int round;
	private Date datumPocetka;

	public Mec(int r) {
		setRound(r);
	}
	
	public Mec(int r, Takmicar t, int i) {
		setRound(r); 
		if (i==1) this.takmicar1 = t;
		else if (i==2) this.takmicar2=t;
	}
	
	public Mec(int r, Takmicar t1, Takmicar t2)
	{
		setRound(r);
		this.takmicar1 = t1;
		this.takmicar2 = t2;
	}
	
	public Mec(Takmicar t1, Takmicar t2)
	{
		this.takmicar1 = t1;
		this.takmicar2 = t2;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Turnir getTurnir() {
		return turnir;
	}

	public void setTurnir(Turnir turnir) {
		this.turnir = turnir;
	}

	public Takmicar getTakmicar1() {
		return takmicar1;
	}

	public void setTakmicar1(Takmicar takmicar1) {
		this.takmicar1 = takmicar1;
	}

	public Takmicar getTakmicar2() {
		return takmicar2;
	}

	public void setTakmicar2(Takmicar takmicar2) {
		this.takmicar2 = takmicar2;
	}

	public Double getRezultat1() {
		return rezultat1;
	}

	public void setRezultat1(Double rezultat1) {
		this.rezultat1 = rezultat1;
	}

	public Double getRezultat2() {
		return rezultat2;
	}

	public void setRezultat2(Double rezultat2) {
		this.rezultat2 = rezultat2;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}
	
	public Date getDatumPocetka() {
		return datumPocetka;
	}

	public void setDatumPocetka(Date datumPocetka) {
		this.datumPocetka = datumPocetka;
	}
}
