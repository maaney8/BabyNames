import java.sql.*;

public class Query7 {
	public static void main(String[] args) {
		String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames"; // replace with your database name
		String user = "root"; // replace with your database username
		String password = "password"; // replace with your database password

		try (Connection conn = DriverManager.getConnection(url, user, password)) {
			String sql = "Insert into baby_names (id, name, year, gender, state, number) "
					+ "values (10000000, 'Joseph', 2016, 'M', 'PA', 476)";

			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			int rowsAffected = stmt.executeUpdate(sql);

			System.out.println("Rows affected: " + rowsAffected);

			stmt.close();
		} catch (SQLException e) {
			System.err.println("Error: " + e.getMessage());
		}
	}
}