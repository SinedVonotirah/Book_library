package by.vonotirah.booklibrary.web_app.services.impl;

import java.sql.SQLException;

import by.vonotirah.booklibrary.persistence.DaoFactory;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.DynamicDaoListener;
import by.vonotirah.booklibrary.web_app.services.UserService;

public class UserServiceImpl implements UserService, DynamicDaoListener {

	private UserDao userDao;
	private AppContext context;
	
	public UserServiceImpl(AppContext context) {
		this.context = context;
		this.userDao = ((DaoFactory)context.getBean(AppContext.DAO_FACTORY_KEY)).getUserDao();
	}

	@Override
	public void createUser(User user) {
		try {
			userDao.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User getUserById(String id) {
		try {
			return userDao.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public User getUserByLastName(String lastName) {
		try {
			return userDao.getUserByLastName(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteUser(User user) {
		try {
			userDao.deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onDaoChange() {
		this.userDao = ((DaoFactory)context.getBean(AppContext.DAO_FACTORY_KEY)).getUserDao();
	}

}
