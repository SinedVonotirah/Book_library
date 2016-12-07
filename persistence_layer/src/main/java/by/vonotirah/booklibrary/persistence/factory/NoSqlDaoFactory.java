package by.vonotirah.booklibrary.persistence.factory;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.DaoFactory;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.nosql.NoSqlBookDao;
import by.vonotirah.booklibrary.persistence.nosql.NoSqlConnectionFactory;
import by.vonotirah.booklibrary.persistence.nosql.NoSqlUserDao;

public class NoSqlDaoFactory implements DaoFactory {

	@Override
	public BookDao getBookDao() {
		// TODO Auto-generated method stub
		return new NoSqlBookDao(new NoSqlConnectionFactory());
	}

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return new NoSqlUserDao(new NoSqlConnectionFactory());
	}

}
