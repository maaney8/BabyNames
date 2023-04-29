import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Query1 {
	public static void main(String[] args) throws Exception {

		Connection con = null;
		Statement stm = null;
		ResultSet rs = null;

		try {
			// Establish a connection to the database
			con = DriverManager.getConnection("jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames", "username", "password");

			// Create a statement object
			stm = con.createStatement();

			// Execute the SQL query
			rs = stm.executeQuery("Select name, SUM(num_babies) as total_babies from baby_names "
					+ "where us_state = 'MD' and gender = 'M' and date_year = 1991 Group by name order by total_babies DESC Limit 1;");

			// Retrieve the result
			if (rs.next()) {
				String mostCommonName = rs.getString("name");
				int totalBabies = rs.getInt("total_babies");
				System.out.println("The most common boy's name in Maryland in 1991 is : " + mostCommonName
						+ " with " + totalBabies + " babies.");
			}
		} finally {
			// Close the ResultSet, Statement and Connection objects
			if (rs != null)
				rs.close();
			if (stm != null)
				stm.close();
			if (con != null)
				con.close();
		}
	}
}
