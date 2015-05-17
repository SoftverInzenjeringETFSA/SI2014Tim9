package sahturnir;
import java.sql.*;

public class App {
	public static void main(String[] args) {
		String url = "jdbc:mysql://localhost/sahovski_klub_pijun";
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection c = DriverManager.getConnection(url, "root", "turnir");
			try {
				Statement st = c.createStatement();
				ResultSet rs = st.executeQuery("select * from klubovi;");
				while (rs.next()) {
					String naziv = rs.getString(5);
					System.out.println(naziv);
				}
			} catch (Exception e) {
				System.out.println("Greska pri radu sa bazom: "
						+ e.getMessage());
			} finally {
				c.close();
			}
		} catch (Exception e) {
			System.out.println("Greska pri radu sa bazom: " + e.getMessage());
		}
	}
}
