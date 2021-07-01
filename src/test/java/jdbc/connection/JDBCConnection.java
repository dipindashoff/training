package jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCConnection {

	public static void main(String[] args) {

		try {
			// 1. Dynamically load the driver class
			Class.forName("oracle.jdbc.driver.OracleDriver"); // Give JDBC driver Name

			// 2. Create the connection object
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "username", "password");

			// 3. Create the Statement object
			Statement stmt = con.createStatement();

			// 4. Execute the query
			String sql = "select * from emp";

			ResultSet rs = stmt.executeQuery(sql);

			// You need to call next() at least one time before you can read any data.
			// Before the first next() call the ResultSet is positioned before the first
			// row.
			while (rs.next())
				// Using column index
				System.out.println(rs.getInt(1) + " " + rs.getString(2));

			// You can also use column name to get data
			// E.g. String a = rs.getString("columnName");

		} catch (Exception e) {
			e.printStackTrace();
		}

		// OR
		String sql = "select * from table";
		// Using dynamic query
//		String query = "select name, country, password from Users where email = ? and password = ?";
		try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@databasename", "user", "password");
				PreparedStatement prepStmnt = con.prepareStatement(sql)) {

			Class.forName("oracle.jdbc.driver.OracleDriver");

			try (ResultSet rs = prepStmnt.executeQuery()) {

				while (rs.next())
					System.out.println(rs.getString("name"));
			}

			// NOTE: No catch is necessary here

		} catch (Exception e) {
		}

	}

}
