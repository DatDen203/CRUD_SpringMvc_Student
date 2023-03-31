package ConnectSql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySql {
	protected Connection conn;

	public MySql() {
		String url = "jdbc:mysql://127.0.0.1:3306/test";
		String username = "root";
		String pass = "999999";
		try {
			 Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(url, username, pass);
			if (conn != null) {
				System.out.println("Connected to the MySql success");
			} else {
				System.out.println("Never Give Up");
			}
		} catch (SQLException e) {
			System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
