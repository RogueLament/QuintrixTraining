import org.testng.annotations.Test;
import java.sql.*;

public class SanityTests {
	@Test
	public void canRunTests() {
	}
	  
	@Test
	public void TestDatabaseConnections() {
		String url = "jdbc:mysql://localhost:3306/sakila";

		System.out.println("Connecting database...");

		try (Connection connection = DriverManager.getConnection(url);
				Statement statement = connection.createStatement();
		        ResultSet rs = statement.executeQuery("SELECT city FROM CITY ORDER BY city DESC LIMIT 10;")) {
		    System.out.println("Database connected");
		} catch (SQLException e) {
		    throw new IllegalStateException("Cannot connect the database", e);
		}
	}
}
