import java.sql.*;

public class Query8 {
	public static void main(String[] args) {
		String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames"; // replace with your database URL
		String user = "root"; // replace with your database username
		String password = "password"; // replace with your database password

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String sql = "Delete from babynames where id = 10000000";

			Statement stmt = conn.createStatement();
			int rowsAffected = stmt.executeUpdate(sql);

			System.out.println("Rows affected: " + rowsAffected);

			stmt.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}