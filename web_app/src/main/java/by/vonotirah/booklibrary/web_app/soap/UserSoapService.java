package by.vonotirah.booklibrary.web_app.soap;

import java.sql.SQLException;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;
import by.vonotirah.booklibrary.web_app.UserWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.UserWebService")
public class UserSoapService implements UserWebService {

	private DaoManagerWebService daoManager;

	public UserSoapService() {
		super();
		daoManager = new DaoManagerSoapService();
	}

	@Override
	public void createUser(User user) {
		try {
			daoManager.getUserDao().createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public User getUserById(String id) {
		try {
			return daoManager.getUserDao().getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByLastName(String lastName) {
		try {
			return daoManager.getUserDao().getUserByLastName(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		try {
			daoManager.getUserDao().updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User user) {
		try {
			daoManager.getUserDao().deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
