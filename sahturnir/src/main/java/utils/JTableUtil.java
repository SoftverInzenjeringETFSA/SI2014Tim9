package utils;

import java.util.List;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import klase.Klub;
import klase.Korisnik;
import klase.Mec;
import klase.Takmicar;
import klase.Turnir;
import dal.KlubDAO;
import dal.KorisnikDAO;
import dal.MecDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;

public class JTableUtil {

	public TableModel populateJTableTakmicari() {
		List<Takmicar> takmicari = new ArrayList<Takmicar>();
		TakmicarDAO tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);
		String[] columnNames = { "ID", "Ime i prezime", "Datum roðenja",
				"JMBG", "Broj bodova", "Kategorija", "Klub", "", "" };
		Object[][] data = new Object[takmicari.size()][9];
		for (int i = 0; i < takmicari.size(); i++) {
			data[i][0] = takmicari.get(i).getId();
			data[i][1] = takmicari.get(i).getIme() + " "
					+ takmicari.get(i).getPrezime();
			String datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").format(takmicari.get(i).getDatumRodjenja());
			data[i][2] = datumRodjenja;
			data[i][3] = takmicari.get(i).getJmbg();
			data[i][4] = String.valueOf(takmicari.get(i).getBrojBodova());
			data[i][5] = takmicari.get(i).getKategorija();
			if(takmicari.get(i).getKlub() != null)
				data[i][6] = String.valueOf(takmicari.get(i).getKlub().getNaziv());
		}
		return new DefaultTableModel(data, columnNames);
	}
	
	public TableModel searchTakmicari(int criteria, String parameter) {
		if (parameter == null || parameter.trim().equals(""))
			return populateJTableTakmicari();
		TakmicarDAO tdao = new TakmicarDAO();
		List<Takmicar> takmicari = tdao.search(criteria, parameter);
		String[] columnNames = { "ID", "Ime i prezime", "Datum roðenja",
				"JMBG", "Broj bodova", "Kategorija", "Klub", "", "" };
		Object[][] data = new Object[takmicari.size()][9];
		for (int i = 0; i < takmicari.size(); i++) {
			data[i][0] = takmicari.get(i).getId();
			data[i][1] = takmicari.get(i).getIme() + " "
					+ takmicari.get(i).getPrezime();
			String datumRodjenja = new SimpleDateFormat("dd.MM.yyyy.").format(takmicari.get(i).getDatumRodjenja());
			data[i][2] = datumRodjenja;
			data[i][3] = takmicari.get(i).getJmbg();
			data[i][4] = String.valueOf(takmicari.get(i).getBrojBodova());
			data[i][5] = takmicari.get(i).getKategorija();
			if(takmicari.get(i).getKlub() != null)
				data[i][6] = String.valueOf(takmicari.get(i).getKlub().getNaziv());
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel populateJTableRangListaTakmicari() {
		List<Takmicar> takmicari = new ArrayList<Takmicar>();
		List<Klub> klubovi = new ArrayList<Klub>();

		TakmicarDAO tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);

		KlubDAO kdao = new KlubDAO();
		klubovi = kdao.getAll(Klub.class);

		String[] columnNames = { "Pozicija", "Ime i prezime", "Datum roðenja",
				"Klub", "Broj bodova", "Broj turnira", "Broj titula" };
		String[][] data = new String[takmicari.size()][7];
		for (int i = 0; i < takmicari.size(); i++) {
			data[i][0] = Integer.toString(i + 1);
			data[i][1] = takmicari.get(i).getIme() + " "
					+ takmicari.get(i).getPrezime();
			data[i][2] = String.valueOf(takmicari.get(i).getDatumRodjenja());
			for (int j = 0; j < klubovi.size(); j++) {
				if (klubovi.get(j).getId() == takmicari.get(i).getKlub()
						.getId())
					data[i][3] = klubovi.get(j).getNaziv();
			}
			data[i][4] = String.valueOf(takmicari.get(i).getBrojBodova());
			// data[i][5] = takmicari.get(i).getKategorija();
			data[i][5] = "0";
			data[i][6] = "0";
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel populateJTableRangListaKlubovi() {
		List<Takmicar> takmicari = new ArrayList<Takmicar>();
		List<Klub> klubovi = new ArrayList<Klub>();

		TakmicarDAO tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);

		KlubDAO kdao = new KlubDAO();
		klubovi = kdao.getAll(Klub.class);
		int prebroj = 0;
		double sumaBodova = 0.0d;
		String[] columnNames = { "Pozicija", "Naziv kluba", "Broj takmièara",
				"Ime i prezime predsjednika", "Ukupan broj bodova" };
		String[][] data = new String[klubovi.size()][5];
		for (int i = 0; i < klubovi.size(); i++) {
			data[i][0] = Integer.toString(i + 1);
			data[i][1] = klubovi.get(i).getNaziv();
			for (int j = 0; j < takmicari.size(); j++) {
				if (takmicari.get(j).getKlub().getId() == klubovi.get(i)
						.getId()) {
					sumaBodova = sumaBodova + takmicari.get(j).getBrojBodova();
					prebroj++;
				}
			}
			data[i][2] = Integer.toString(prebroj);
			data[i][3] = klubovi.get(i).getPredsjednik();
			data[i][4] = Double.toString(sumaBodova);
			sumaBodova = 0;
			prebroj = 0;
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel populateJTablePodaciKlubova() {
		List<Takmicar> takmicari = new ArrayList<Takmicar>();
		List<Klub> klubovi = new ArrayList<Klub>();

		TakmicarDAO tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);

		KlubDAO kdao = new KlubDAO();
		klubovi = kdao.getAll(Klub.class);
		int prebroj = 0;
		double sumaBodova = 0.0d;
		String[] columnNames = { "Pozicija", "Naziv kluba", "Broj takmièara",
				"Ime i prezime predsjednika", "Ukupan broj bodova" };
		String[][] data = new String[klubovi.size()][5];
		for (int i = 0; i < klubovi.size(); i++) {
			data[i][0] = Integer.toString(i + 1);
			data[i][1] = klubovi.get(i).getNaziv();
			for (int j = 0; j < takmicari.size(); j++) {
				if (takmicari.get(j).getKlub().getId() == klubovi.get(i)
						.getId()) {
					sumaBodova = sumaBodova + takmicari.get(j).getBrojBodova();
					prebroj++;
				}
			}
			data[i][2] = Integer.toString(prebroj);
			data[i][3] = klubovi.get(i).getPredsjednik();
			data[i][4] = Double.toString(sumaBodova);
			sumaBodova = 0;
			prebroj = 0;
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel populateJTableKorisnici() {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		KorisnikDAO kdao = new KorisnikDAO();
		korisnici = kdao.getAll(Korisnik.class);
		String[] columnNames = { "ID", "Korisnièko ime", "Ime i prezime",
				"JMBG", "", "" };
		Object[][] data = new Object[korisnici.size()][6];
		for (int i = 0; i < korisnici.size(); i++) {
			data[i][0] = korisnici.get(i).getId();
			data[i][1] = korisnici.get(i).getKorisnickoIme();
			data[i][2] = korisnici.get(i).getIme() + " "
					+ korisnici.get(i).getPrezime();
			data[i][3] = korisnici.get(i).getJmbg();
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel populateJTableKlubovi() {
		List<Klub> klubovi = new ArrayList<Klub>();
		KlubDAO kdao = new KlubDAO();
		klubovi = kdao.getAll(Klub.class);
		String[] columnNames = { "ID", "Naziv", "Sjedište", "Predsjednik",
				"Datum osnivanja", "Broj bodova", "", "" };
		Object[][] data = new Object[klubovi.size()][8];
		for (int i = 0; i < klubovi.size(); i++) {
			data[i][0] = klubovi.get(i).getId();
			data[i][1] = klubovi.get(i).getNaziv();
			data[i][2] = klubovi.get(i).getSjediste();
			data[i][3] = klubovi.get(i).getPredsjednik();
			String datumOsnivanja = new SimpleDateFormat("dd.MM.yyyy.").format(klubovi.get(i).getDatumOsnivanja());
			data[i][4] = datumOsnivanja;
			data[i][5] = String.valueOf(kdao.calculateClubPoints(klubovi.get(i)
					.getId()));
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel searchKlubovi(int criteria, String parameter) {
		if (parameter == null || parameter.trim().equals(""))
			return populateJTableKlubovi();
		KlubDAO kdao = new KlubDAO();
		List<Klub> klubovi = kdao.search(criteria, parameter);
		String[] columnNames = { "ID", "Naziv", "Sjedište", "Predsjednik",
				"Datum osnivanja", "Broj bodova", "", "" };
		String[][] data = new String[klubovi.size()][8];
		for (int i = 0; i < klubovi.size(); i++) {
			data[i][0] = String.valueOf(klubovi.get(i).getId());
			data[i][1] = klubovi.get(i).getNaziv();
			data[i][2] = klubovi.get(i).getSjediste();
			data[i][3] = klubovi.get(i).getPredsjednik();
			String datumOsnivanja = new SimpleDateFormat("dd.MM.yyyy.").format(klubovi.get(i).getDatumOsnivanja());
			data[i][4] = datumOsnivanja;
			data[i][5] = String.valueOf(kdao.calculateClubPoints(klubovi.get(i)
					.getId()));
		}
		return new DefaultTableModel(data, columnNames);
	}

	public TableModel populateJTableTurniri() {
		List<Turnir> turniri = new ArrayList<Turnir>();
		TurnirDAO tdao = new TurnirDAO();
		turniri = tdao.getAll(Turnir.class);
		String[] columnNames = { "ID", "Naziv", "Datum poèetka", "Trajanje (u danima)",
				"Format takmièenja", "Broj takmièara", "", "", "" };
		Object[][] data = new Object[turniri.size()][9];
		for (int i = 0; i < turniri.size(); i++) {
			data[i][0] = turniri.get(i).getId();
			data[i][1] = turniri.get(i).getNaziv();
			String datumPocetka = new SimpleDateFormat("dd.MM.yyyy.").format(turniri.get(i).getDatumPocetka());
			data[i][2] = datumPocetka;
			data[i][3] = String.valueOf(turniri.get(i).getTrajanje());
			data[i][4] = turniri.get(i).getFormatTakmicenja();
			data[i][5] = String.valueOf(tdao.getNumberOfContestants(turniri
					.get(i).getId()));
		}
		return new DefaultTableModel(data, columnNames);
	}
	
	public TableModel populateJTableMecevi() {
		List<Mec> mecevi = new ArrayList<Mec>();
		MecDAO tdao = new MecDAO();
		mecevi = tdao.getAll(Mec.class);
		String[] columnNames = { "", "Takmičar 1", "Takmičar 2", "Datum početka",
				"", ""};
		Object[][] data = new Object[mecevi.size()][6];
		for (int i = 0; i < mecevi.size(); i++) {
			data[i][0] = mecevi.get(i).getTakmicar1();
			data[i][1] = mecevi.get(i).getTakmicar2();
			String datumPocetka = new SimpleDateFormat("dd.MM.yyyy.").format(mecevi.get(i).getDate());
			data[i][2] = datumPocetka;
		}
		return new DefaultTableModel(data, columnNames);
	}
	
	public List<Klub> populateComboBoxKlubovi(){
		
		KlubDAO kdao = new KlubDAO();
		List<Klub> klubovi = new ArrayList<Klub>();
		klubovi = kdao.getAll(Klub.class);

		return klubovi;
	}
}
