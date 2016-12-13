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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public User getUserById(String id) {
		// TODO Auto-generated method stub
		try {
			return daoManager.getUserDao().getUserById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public User getUserByLastName(String lastName) {
		// TODO Auto-generated method stub
		try {
			return daoManager.getUserDao().getUserByLastName(lastName);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		try {
			daoManager.getUserDao().updateUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		try {
			daoManager.getUserDao().deleteUser(user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
