package by.vonotirah.booklibrary.web_app.soap;

import java.sql.SQLException;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.UserWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.UserWebService")
public class UserSoapService implements UserWebService {

	private UserDao userDao;

	public UserSoapService() {
		super();
		userDao = DaoManagerSoapService.getUserDao();
	}

	@Override
	public void createUser(User user) {
		try {
			userDao.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User getUserById(String id) {
		try {
			return userDao.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByLastName(String lastName) {
		try {
			return userDao.getUserByLastName(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			userDao.deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
