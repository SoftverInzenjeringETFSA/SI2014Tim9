package dal;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
						.prepareStatement("SELECT count(v.takmicar) FROM takmicar_turnir_veza v WHERE v.turnir = ?;");
				statement.setLong(1, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				resultValue = Integer.parseInt(sum);
			} 
			catch (Exception e) 
			{
				throw e;
			} 
			finally 
			{
				connection.close();
			}
		} 
		catch (Exception e) 
		{
			logger.error("Sorry, something wrong!", e);
		} 
		finally 
		{
		}
		return resultValue;
	}
}
