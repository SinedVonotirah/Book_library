package by.vonotirah.booklibrary.web_app;

import by.vonotirah.booklibrary.persistence.domain.User;

public interface UserWebService {

	void createUser(User user);

	User getUserById(String id);

	User getUserByLastName(String lastName);

	void updateUser(User user);

	void deleteUser(User user);

}
