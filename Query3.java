import java.sql.*;

public class Query3 {
	public static void main(String[] args) {
    	String url = "jdbc:derby:C:/Users/chris/Desktop/HCCFiles/CMSY 167/babynames";
    	String user = "root";
    	String password = "password";
    	        
        try (Connection conn = DriverManager.getConnection(url, user, password)) {
            String sql = "Select year, SUM(number) as count from baby_names where name = 'Rosemary'"
            		+ " and gender = 'F' Group By year order by count DESC LIMIT 1";
            
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            if (rs.next()) {
                int year = rs.getInt("year");
                int count = rs.getInt("count");
                System.out.println("The most baby girls named Rosemary were born in the year " + year + " with a count of " + count + " in any state.");
            }
            
            rs.close();
            stmt.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
