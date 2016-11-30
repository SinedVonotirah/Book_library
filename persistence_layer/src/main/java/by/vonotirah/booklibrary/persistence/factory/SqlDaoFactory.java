package by.vonotirah.booklibrary.persistence.factory;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.DaoFactory;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.sql.SqlBookDao;
import by.vonotirah.booklibrary.persistence.sql.SqlUserDao;

public class SqlDaoFactory implements DaoFactory {

	@Override
	public BookDao getBookDao() {
		// TODO Auto-generated method stub
		return new SqlBookDao();
	}

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new SqlUserDao();
	}

}
