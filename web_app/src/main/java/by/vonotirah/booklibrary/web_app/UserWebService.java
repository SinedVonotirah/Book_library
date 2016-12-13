package by.vonotirah.booklibrary.web_app;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.vonotirah.booklibrary.persistence.domain.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface UserWebService {

	void createUser(User user);

	User getUserById(String id);

	User getUserByLastName(String lastName);

	void updateUser(User user);

	void deleteUser(User user);

}
