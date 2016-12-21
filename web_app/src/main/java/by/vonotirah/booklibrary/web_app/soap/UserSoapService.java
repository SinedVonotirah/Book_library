package by.vonotirah.booklibrary.web_app.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.UserService;
import by.vonotirah.booklibrary.web_app.UserWebService;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class UserSoapService implements UserWebService {

	private UserService userService;

	public UserSoapService() {
		super();
		userService = SoapServiceManager.getUserService();
	}

	@Override
	@WebMethod
	public void createUser(User user) {
		userService.createUser(user);
	}

	@Override
	@WebMethod
	public User getUserById(String id) {
		return userService.getUserById(id);
	}

	@Override
	@WebMethod
	public User getUserByLastName(String lastName) {
		return userService.getUserByLastName(lastName);
	}

	@Override
	@WebMethod
	public void updateUser(User user) {
		userService.updateUser(user);
	}

	@Override
	@WebMethod
	public void deleteUser(User user) {
		userService.deleteUser(user);
	}
}
