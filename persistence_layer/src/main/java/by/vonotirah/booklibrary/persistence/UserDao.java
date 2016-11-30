package by.vonotirah.booklibrary.persistence;

import java.sql.SQLException;

import by.vonotirah.booklibrary.persistence.domain.User;

public interface UserDao {

	void createUser(User user) throws SQLException;

	User getUserById(String id) throws SQLException;

	User getUserByLastName(String lastName) throws SQLException;

	void updateUser(User user) throws SQLException;

	void deleteUser(User user) throws SQLException;

}
