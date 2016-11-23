package by.vonotirah.booklibrary.dao_layer.dao;

import java.sql.SQLException;

import by.vonotirah.booklibrary.dao_layer.domain.User;

public interface UserDao {

	void createUser(User user) throws SQLException;

	User getUserById(int id) throws SQLException;

	void updateUser(User user) throws SQLException;

	void deleteUser(User user) throws SQLException;

}
