package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import klase.Klub;
import klase.Takmicar;

import org.apache.log4j.Logger;

public class TurnirDAO extends GenericDAO {

	public int getNumberOfContestants(long id) {
		final Logger logger = Logger.getLogger(TurnirDAO.class);
		int resultValue = 0;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT count(v.takmicar) FROM turnir_takmicar_veza v WHERE v.turnir = ?;");
				statement.setLong(1, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				resultValue = Integer.parseInt(sum);
			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Došlo je do greške!", e);
		} finally {
		}
		return resultValue;
	}
	
	public void prepareContestants(long turnir, long takmicar) {
		final Logger logger = Logger.getLogger(TurnirDAO.class);
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("INSERT INTO turnir_takmicar_veza (turnir, takmicar) VALUES(?, ?);");
				statement.setLong(1, turnir);
				statement.setLong(2, takmicar);
				statement.execute();
			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Došlo je do greške!", e);
		} finally {
		}
	}
	
	public List<Takmicar> getAllContestants(long id) {
		final Logger logger = Logger.getLogger(TurnirDAO.class);
		List<Takmicar> takmicari = new ArrayList<Takmicar>();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT * from takmicari t, osobe o, turnir_takmicar_veza v where t.id = o.id and t.id = v.takmicar and v.turnir = ?;");
				statement.setLong(1, id);
				ResultSet result = statement.executeQuery();
				while (result.next()) {
					Takmicar t = new Takmicar();
					t.setId(result.getInt("id"));
					t.setIme(result.getString("ime"));
					t.setPrezime(result.getString("prezime"));
					takmicari.add(t);
				}
			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Došlo je do greške!", e);
		} finally {
		}
		return takmicari;
	}
}
