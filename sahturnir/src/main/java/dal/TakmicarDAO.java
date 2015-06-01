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
			logger.error("Došlo je do greške!", e);
		} finally {
		}
		return takmicari;
	}
	
	public int[] getMatchSummary(long id) {
		final Logger logger = Logger.getLogger(KlubDAO.class);
		int[] resultValue = new int[3];
		int pobjede = 0;
		int nerjeseno = 0;
		int porazi = 0;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("select count(mecevi.rezultat1) from mecevi where mecevi.takmicar1 = ? AND mecevi.rezultat1 = 1;");
				statement.setLong(1, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				if(sum != null)
					pobjede += Integer.parseInt(sum);

				PreparedStatement statement2 = connection
						.prepareStatement("select count(mecevi.rezultat2) from mecevi where mecevi.takmicar2 = ? AND mecevi.rezultat2 = 1;");
				statement2.setLong(1, id);
				ResultSet result2 = statement2.executeQuery();
				result2.next();
				String sum2 = result2.getString(1);
				if(sum2 != null)
					pobjede += Integer.parseInt(sum2);
				
				PreparedStatement statement3 = connection
						.prepareStatement("select count(mecevi.rezultat1) from mecevi where (mecevi.takmicar1 = ? OR mecevi.takmicar2 = ?) AND mecevi.rezultat1 = 0.5;");
				statement3.setLong(1, id);
				statement3.setLong(2, id);
				ResultSet result3 = statement3.executeQuery();
				result3.next();
				String sum3 = result3.getString(1);
				if(sum3 != null)
					nerjeseno += Integer.parseInt(sum3);
			
				PreparedStatement statement4 = connection
						.prepareStatement("select count(mecevi.rezultat2) from mecevi where mecevi.takmicar2 = ? AND mecevi.rezultat1 = 1 AND mecevi.rezultat2 = 0;");
				statement4.setLong(1, id);
				ResultSet result4 = statement4.executeQuery();
				result4.next();
				String sum4 = result4.getString(1);
				if(sum4 != null)
					porazi += Integer.parseInt(sum4);

				PreparedStatement statement5 = connection
						.prepareStatement("select count(mecevi.rezultat1) from mecevi where mecevi.takmicar1 = ? AND mecevi.rezultat1 = 0 AND mecevi.rezultat2 = 1;");
				statement5.setLong(1, id);
				ResultSet result5 = statement5.executeQuery();
				result5.next();
				String sum5 = result5.getString(1);
				if(sum5 != null)
					porazi += Integer.parseInt(sum5);

			} catch (Exception e) {
				throw e;
			} finally {
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Došlo je do greške!", e);
		} finally {
		}
		resultValue[0] = pobjede;
		resultValue[1] = nerjeseno;
		resultValue[2] = porazi;
		return resultValue;
	}
	
	
	public int getParticipationCount(long id) {
		final Logger logger = Logger.getLogger(KlubDAO.class);
		int cifra = 0;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("select count(distinct turnir) from mecevi, turniri where (takmicar1 = ? OR takmicar2 = ?) AND turnir  =  turniri.id;");
				statement.setLong(1, id);
				statement.setLong(2, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				if(sum != null)
					cifra += Integer.parseInt(sum);
			} 
			catch (Exception e) 
			{
				throw e;
			} 
			finally 
			{
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Došlo je do greške!", e);
		} finally {
		}
		return cifra;
	}
	
	public double getTournamentPoints (long id, long turnirID)
	{
		double bodovi = 0.0d;
		final Logger logger = Logger.getLogger(KlubDAO.class);
		try {
			Class.forName(driver);
				Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
				try{
					PreparedStatement statement3;
					statement3 = connection
							.prepareStatement("select sum(rezultat1) from mecevi where mecevi.turnir = ? AND mecevi.takmicar1 = ?;");
		
					statement3.setLong(1, turnirID);
					statement3.setLong(2, id);
					ResultSet result3 = statement3.executeQuery();
					result3.next();
					String sum3 = result3.getString(1);
					if(sum3 != null)
						bodovi += Double.parseDouble(sum3);

					
					PreparedStatement statement4;
					statement4 = connection
							.prepareStatement("select sum(rezultat2) from mecevi where mecevi.turnir = ? AND mecevi.takmicar2 = ?;");
		
					statement4.setLong(1, turnirID);
					statement4.setLong(2, id);
					ResultSet result4 = statement4.executeQuery();
					result4.next();
					String sum4 = result4.getString(1);
					if(sum4 != null)
						bodovi += Double.parseDouble(sum4);
					
				} catch (Exception e) {
					throw e;
				}
				finally{
					connection.close();
				}
			
		} 
		catch (Exception e) {
			logger.error("Greška", e);
		}
		finally{}
		
		
		return bodovi;
	}
	
	public boolean validate(long id, long turnirID)
	{
		final Logger logger = Logger.getLogger(KlubDAO.class);
		boolean flag = false;
		try{
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			
			PreparedStatement statement3;
			try {
				statement3 = connection
						.prepareStatement("select mecevi.id from mecevi where mecevi.turnir = ? AND mecevi.takmicar2 = ?  AND mecevi.rezultat2 = 0 AND mecevi.rezultat1 = 0;");
	
				statement3.setLong(1, turnirID);
				statement3.setLong(2, id);
				ResultSet result3 = statement3.executeQuery();
				result3.next();
				String sum3 = result3.getString(1);
				if(sum3 != null)
					flag = true;
	
			} catch (SQLException e) {
				throw e;
			}
			finally{
				connection.close();
			}
		}
		catch (Exception e1) 
		{
			logger.error("Došlo je do greške", e1);
		} 
		finally 
		{
		}		
		return flag;
	}
	
	
	public boolean throwOut(long id, long turnirID) {
		System.out.println(id);
		final Logger logger = Logger.getLogger(KlubDAO.class);
		boolean flag = false;
		try {
			Class.forName(driver);
			Connection connection = DriverManager.getConnection(cs1, cs2, cs3);
			try {
				PreparedStatement statement = connection
						.prepareStatement("select count(mecevi.id) from mecevi where mecevi.turnir = ? AND mecevi.takmicar1 = ?  AND mecevi.rezultat1 = 0 AND mecevi.rezultat2 = 1;");
				statement.setLong(1, turnirID);
				statement.setLong(2, id);
				ResultSet result = statement.executeQuery();
				result.next();
				String sum = result.getString(1);
				if(sum != null && Integer.parseInt(sum) != 0)
					flag = true;
				
				
				PreparedStatement statement2 = connection
						.prepareStatement("select count(mecevi.id) from mecevi where mecevi.turnir = ? AND mecevi.takmicar2 = ?  AND mecevi.rezultat2 = 0 AND mecevi.rezultat1 = 1;");
				statement2.setLong(1, turnirID);
				statement2.setLong(2, id);
				ResultSet result2 = statement2.executeQuery();
				result2.next();
				String sum2 = result2.getString(1);
				if(sum2 != null && Integer.parseInt(sum2) != 0)
					flag = true;
				
				if (flag)
					System.out.println("TRUE");
				else System.out.println("FALSE");
			} 
			catch (Exception e) 
			{
				throw e;
			} 
			finally 
			{
				connection.close();
			}
		} catch (Exception e) {
			logger.error("Došlo je do greške!", e);
		} finally {
		}
		return flag;
	}
}
