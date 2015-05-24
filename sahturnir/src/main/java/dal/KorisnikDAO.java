package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class KorisnikDAO extends GenericDAO {
	
	public int checkUser(String korisnickoIme, String sifra) {
		int resultValue = 0;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT count(k.id) FROM korisnici k WHERE k.korisnickoIme = ? and k.sifra = ?;");
				statement.setString(1, korisnickoIme);
				statement.setString(2, sifra);
				ResultSet result = statement.executeQuery();
				result.next();
				String countResult = result.getString(1);
				resultValue = Integer.parseInt(countResult);
			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
		} finally {
		}
		return resultValue;
	}
}
