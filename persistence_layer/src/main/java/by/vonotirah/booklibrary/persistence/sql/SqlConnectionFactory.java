package by.vonotirah.booklibrary.persistence.sql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlConnectionFactory {

	public static final String DRIVER = "org.postgresql.Driver";
	public static final String DBURL = "jdbc:postgresql://localhost:5432/bookLibrary";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "stalker1";

	public SqlConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Connection getConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
}
