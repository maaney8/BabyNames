import java.sql.*;

public class Query6 {
	public static void main(String[] args) {
		String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames"; // replace with your database URL
		String user = "root"; // replace with your database username
		String password = "password"; // replace with your database password

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String sql = "Select state, SUM(number) as count from baby_names where name = 'Hannah' and gender = 'F'"
					+ " and year = 1997 Group by state order by count DESC LIMIT 1";

			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			if (rs.next()) {
				String state = rs.getString("state");
				int count = rs.getInt("count");
				System.out.println("The state with the most girls named Hannah in 1997 was " + state
						+ " with a count of " + count + ".");
			}

			rs.close();
			stmt.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}