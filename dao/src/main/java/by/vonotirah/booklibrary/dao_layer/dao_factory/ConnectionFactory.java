package by.vonotirah.booklibrary.dao_layer.dao_factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	private static ConnectionFactory instance = new ConnectionFactory();

	public static final String DRIVER = "org.postgresql.Driver";
	public static final String DBURL = "jdbc:postgresql://localhost:5432/bookLibrary";
	public static final String USERNAME = "postgres";
	public static final String PASSWORD = "stalker1";

	public ConnectionFactory() {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	private Connection createConnection() {
		Connection connection = null;
		try {
			connection = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static Connection getConnection() {
		return instance.createConnection();
	}
}
