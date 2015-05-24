package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import klase.Korisnik;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.Transaction;

import utils.HibernateUtil;

public class KorisnikDAO extends GenericDAO {

	public int checkUser(String korisnickoIme, String sifra) {
		final Logger logger = Logger.getLogger(KorisnikDAO.class);
		int resultValue = -1;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT k.id FROM korisnici k WHERE k.korisnickoIme = ? and k.sifra = ?;");
				statement.setString(1, korisnickoIme);
				statement.setString(2, sifra);
				ResultSet result = statement.executeQuery();
				if (result.next()) {
					String id = result.getString(1);
					resultValue = Integer.parseInt(id);
				}
			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Do�lo je do gre�ke!", e);
		} finally {
		}
		return resultValue;
	}
}
