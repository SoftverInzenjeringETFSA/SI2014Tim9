package dal;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import klase.Klub;

public class KlubDAO extends GenericDAO {
	
	public List<Klub> search(int criteria, String parameter)
	{
		String[] searchCriteria = { "naziv", "sjediste", "predsjednik"};
		List<Klub> klubovi = new ArrayList();
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				Statement statement = connection.createStatement();
				ResultSet result = statement.executeQuery("SELECT * FROM klubovi k WHERE k." + searchCriteria[criteria] + " LIKE '%" + parameter + "%';");
				while (result.next()) {
					Klub k = new Klub();
					k.setId(result.getInt("id"));
					k.setNaziv(result.getString("naziv"));
					k.setSjediste(result.getString("sjediste"));
					k.setPredsjednik(result.getString("predsjednik"));
					k.setDatumOsnivanja(result.getDate("datumOsnivanja"));
					klubovi.add(k);
				}
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
		catch (Exception e) {
			logger.error("Sorry, something wrong!", e);
		} 
		finally 
		{
		}
		return klubovi;
	}

	public double calculateClubPoints(long id) {
		double resultValue = 0.;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("SELECT sum(t.brojBodova) FROM takmicari t WHERE t.klub = ?;");
				statement.setLong(1, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				resultValue = Double.parseDouble(sum);
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
