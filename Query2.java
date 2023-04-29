import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Query2 {

	public static void main(String[] args) {
		String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames";
		String user = "root";
		String password = "password";

		try (Connection con = DriverManager.getConnection(url, user, password)) {
			String sql = "Select year, Sum(number) as count from baby_names "
					+ "where name = 'Christopher' and gender = 'M' group by year order by count DESC limit 1";
			Statement stm = con.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			if (rs.next()) {
				int year = rs.getInt("year");
				int count = rs.getInt("count");
				System.out.println("The most baby boy's named Christopher were born in the year" + year
						+ " with the count of " + count + " in any state.");
			}
			rs.close();
			stm.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}

	}

}
