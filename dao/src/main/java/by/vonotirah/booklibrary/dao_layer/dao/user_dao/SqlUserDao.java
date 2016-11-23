package by.vonotirah.booklibrary.dao_layer.dao.user_dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.vonotirah.booklibrary.dao_layer.dao.UserDao;
import by.vonotirah.booklibrary.dao_layer.dao_factory.ConnectionFactory;
import by.vonotirah.booklibrary.dao_layer.dao_factory.SqlDaoFactory;
import by.vonotirah.booklibrary.dao_layer.domain.User;

public class SqlUserDao implements UserDao {

	@Override
	public void createUser(User user) throws SQLException {
		String sql = "INSERT INTO user (first_name, last_name) VALUES (?, ?)";

		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastName());
			statement.executeUpdate();
		}

	}

	@Override
	public User getUserById(int id) throws SQLException {
		User user = new User();
		String sql = "SELECT * FROM user WHERE id=?";
		List<User> list = new ArrayList<User>();

		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, id);
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
		String sql = "UPDATE user SET first_name=?, last_name =? WHERE id=?";

		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, user.getFirstname());
			statement.setString(2, user.getLastName());
			statement.setInt(3, user.getId());
			statement.executeUpdate();
		}

	}

	@Override
	public void deleteUser(User user) throws SQLException {
		String sql = "DELETE FROM user WHERE id=?";

		try (Connection connection = ConnectionFactory.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, user.getId());
			statement.executeUpdate();
		}

	}

	private List<User> parseUserResultSet(ResultSet result) throws SQLException {
		List<User> list = new ArrayList<User>();
		while (result.next()) {
			User user = new User();
			user.setId(result.getInt(1));
			user.setFirstname(result.getString(2));
			user.setLastName(result.getString(3));
			list.add(user);
		}
		return list;
	}

}
