package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TurnirDAO extends GenericDAO {

	public int getNumberOfContestants(long id) {
		int resultValue = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/sahovski_klub_pijun", "siuser",
					"password123");
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT count(v.takmicar) FROM takmicar_turnir_veza v WHERE v.turnir = ?;");
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
		} finally {
			return resultValue;
		}
	}
}
