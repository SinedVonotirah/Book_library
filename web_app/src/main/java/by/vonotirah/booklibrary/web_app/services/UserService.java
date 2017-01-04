package by.vonotirah.booklibrary.web_app.services;

import by.vonotirah.booklibrary.persistence.domain.User;

public interface UserService {

	void createUser(User user);

	User getUserById(String id);

	User getUserByLastName(String lastName);

	void updateUser(User user);

	void deleteUser(User user);

}
