package klase;

public abstract class Osoba implements java.io.Serializable {

	public Osoba() {
		// TODO Auto-generated constructor stub
	}

	private long id;
	private String ime;
	private String prezime;
	private String jmbg;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getJmbg() {
		return jmbg;
	}

	public void setJmbg(String jmbg) {
		this.jmbg = jmbg;
	}

	public int compareTo(Takmicar t) {
		// TODO Auto-generated method stub
		return 0;
	}
}
