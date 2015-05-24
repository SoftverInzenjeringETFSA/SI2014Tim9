package dal;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import klase.Klub;
import klase.Takmicar;

public class TakmicarDAO extends GenericDAO {

	public List<Takmicar> search(int criteria, String parameter) {
		final Logger logger = Logger.getLogger(TurnirDAO.class);
		String[] searchCriteria = { "concat(ime, ' ', prezime)", "jmbg",
				"kategorija" };
		List<Takmicar> takmicari = new ArrayList();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				Statement statement = connection.createStatement();
				ResultSet result = statement
						.executeQuery("SELECT * FROM osobe o, takmicari t where "
								+ searchCriteria[criteria]
								+ " LIKE '%"
								+ parameter + "%' and o.id = t.id;");
				while (result.next()) {
					Takmicar t = new Takmicar();
					t.setId(result.getInt("id"));
					t.setIme(result.getString("ime"));
					t.setPrezime(result.getString("prezime"));
					t.setDatumRodjenja(result.getDate("datumRodjenja"));
					t.setJmbg(result.getString("jmbg"));
					t.setBrojBodova(result.getDouble("brojBodova"));
					t.setKategorija(result.getString("kategorija"));
					t.setKlub(loadById(Klub.class, result.getLong("klub")));
					takmicari.add(t);
				}
			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Sorry, something wrong!", e);
		} finally {
		}
		return takmicari;
	}
}
