package by.vonotirah.booklibrary.persistence.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;

public class SqlUserDao implements UserDao {

	@Override
	public void createUser(User user) throws SQLException {
		String sql = "INSERT INTO users (first_name, last_name) VALUES (?, ?)";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.executeUpdate();
		}

	}

	@Override
	public User getUserById(String id) throws SQLException {
		User user = new User();
		String sql = "SELECT * FROM users WHERE id=?";
		List<User> list = new ArrayList<User>();

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, Integer.parseInt(id));
			ResultSet result = statement.executeQuery();
			list = parseUserResultSet(result);
			if (!list.isEmpty()) {
				user = list.get(0);
				return user;
			}
		}
		return null;
	}

	@Override
	public User getUserByLastName(String lastName) throws SQLException {
		User user = new User();
		String sql = "SELECT * FROM users WHERE last_name=?";
		List<User> list = new ArrayList<User>();

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, lastName);
			ResultSet result = statement.executeQuery();
			list = parseUserResultSet(result);
			if (!list.isEmpty()) {
				user = list.get(0);
			}
		}
		return user;
	}

	@Override
	public void updateUser(User user) throws SQLException {
		String sql = "UPDATE users SET first_name=?, last_name =? WHERE id=?";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, user.getFirstName());
			statement.setString(2, user.getLastName());
			statement.setInt(3, Integer.parseInt(user.getId()));
			statement.executeUpdate();
		}

	}

	@Override
	public void deleteUser(User user) throws SQLException {
		String sql = "DELETE FROM users WHERE id=?";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, Integer.parseInt(user.getId()));
			statement.executeUpdate();
		}

	}

	private List<User> parseUserResultSet(ResultSet result) throws SQLException {
		List<User> list = new ArrayList<User>();
		while (result.next()) {
			User user = new User();
			user.setId(Integer.toString(result.getInt(1)));
			user.setFirstName(result.getString(2));
			user.setLastName(result.getString(3));
			list.add(user);
		}
		return list;
	}

}
