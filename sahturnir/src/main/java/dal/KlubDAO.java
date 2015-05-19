package dal;

import java.sql.*;

public class KlubDAO extends GenericDAO {

	public double calculateClubPoints(long id) {
		double resultValue = 0.;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection(
					"jdbc:mysql://localhost/sahovski_klub_pijun", "siuser",
					"password123");
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT sum(t.brojBodova) FROM takmicari t WHERE t.klub = ?;");
				statement.setLong(1, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				resultValue = Double.parseDouble(sum);
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
