import java.sql.*;

public class Query9 {
	public static void main(String[] args) {
		String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames"; // replace with your database URL
		String user = "root"; // replace with your database username
		String password = "password"; // replace with your database password

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String sql = "Select name, SUM(number) as total from babynames where gender = 'M' and year = 1991"
					+ " GROUP BY name order by total DESC LIMIT 1";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				String name = rs.getString("name");
				int total = rs.getInt("total");

				System.out.println(
						"The most common boy's name in 1991 was " + name + " with a total of " + total + " babies.");
			} else {
				System.out.println("No results found.");
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}