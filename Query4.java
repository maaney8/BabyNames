import java.sql.*;

public class Query4 {
	public static void main(String[] args) {
		String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames";
		String user = "root";
		String password = "password";

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String sql = "Select name, number from baby_names where state = 'MD' and year = 2000" + " and number > 500";

			try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
				while (rs.next()) {
					String name = rs.getString("name");
					int number = rs.getInt("number");
					System.out.println(name + ": " + number);
				}
			} catch (SQLException e) {
				System.err.println("Error: " + e.getMessage());
			}
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}