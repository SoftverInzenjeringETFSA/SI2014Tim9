package utils;

import gui.GlavniProzor;

import java.util.List;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import klase.Klub;
import klase.Korisnik;
import klase.Takmicar;
import klase.Turnir;
import dal.KlubDAO;
import dal.KorisnikDAO;
import dal.TakmicarDAO;
import dal.TurnirDAO;

public class JTableUtil {

	public JTable populateJTableTakmicari() {
		List<Takmicar> takmicari = new ArrayList<Takmicar>();
		TakmicarDAO tdao = new TakmicarDAO();
		takmicari = tdao.getAll(Takmicar.class);
		String[] columnNames = { "Ime i prezime", "Datum ro�enja", "JMBG",
				"Broj bodova", "Kategorija" };
		String[][] data = new String[takmicari.size()][5];
		for (int i = 0; i < takmicari.size(); i++) {
			data[i][0] = takmicari.get(i).getIme() + " "
					+ takmicari.get(i).getPrezime();
			data[i][1] = String.valueOf(takmicari.get(i).getDatumRodjenja());
			data[i][2] = takmicari.get(i).getJmbg();
			data[i][3] = String.valueOf(takmicari.get(i).getBrojBodova());
			data[i][4] = takmicari.get(i).getKategorija();
		}
		return new JTable(data, columnNames);
	}

	public JTable populateJTableKorisnici() {
		List<Korisnik> korisnici = new ArrayList<Korisnik>();
		KorisnikDAO kdao = new KorisnikDAO();
		korisnici = kdao.getAll(Korisnik.class);
		String[] columnNames = { "Korisni�ko ime", "Ime i prezime", "JMBG" };
		String[][] data = new String[korisnici.size()][3];
		for (int i = 0; i < korisnici.size(); i++) {
			data[i][0] = korisnici.get(i).getKorisnickoIme();
			data[i][1] = korisnici.get(i).getIme() + " "
					+ korisnici.get(i).getPrezime();
			data[i][2] = korisnici.get(i).getJmbg();
		}
		return new JTable(data, columnNames);
	}

	public JTable populateJTableKlubovi() {
		List<Klub> klubovi = new ArrayList<Klub>();
		KlubDAO kdao = new KlubDAO();
		klubovi = kdao.getAll(Klub.class);
		String[] columnNames = { "Naziv", "Sjedi�te", "Predsjednik",
				"Datum osnivanja", "Broj bodova", "Opcije" };
		Object[][] data = new String[klubovi.size()][6];
		for (int i = 0; i < klubovi.size(); i++) {
			data[i][0] = klubovi.get(i).getNaziv();
			data[i][1] = klubovi.get(i).getSjediste();
			data[i][2] = klubovi.get(i).getPredsjednik();
			data[i][3] = String.valueOf(klubovi.get(i).getDatumOsnivanja());
			data[i][4] = String.valueOf(kdao.calculateClubPoints(klubovi.get(i).getId()));
		}
		return new JTable(data, columnNames);
	}

	public JTable populateJTableTurniri() {
		List<Turnir> turniri = new ArrayList<Turnir>();
		TurnirDAO tdao = new TurnirDAO();
		turniri = tdao.getAll(Turnir.class);
		String[] columnNames = { "Naziv", "Datum po�etka", "Trajanje",
				"Format takmi�enja", "Broj takmi�ara" };
		String[][] data = new String[turniri.size()][5];
		for (int i = 0; i < turniri.size(); i++) {
			data[i][0] = turniri.get(i).getNaziv();
			data[i][1] = String.valueOf(turniri.get(i).getDatumPocetka());
			data[i][2] = String.valueOf(turniri.get(i).getTrajanje());
			data[i][3] = turniri.get(i).getFormatTakmicenja();
			data[i][4] = String.valueOf(tdao.getNumberOfContestants(turniri
					.get(i).getId()));
		}
		return new JTable(data, columnNames);
	}
}
