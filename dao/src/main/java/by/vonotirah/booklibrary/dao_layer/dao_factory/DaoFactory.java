package by.vonotirah.booklibrary.dao_layer.dao_factory;

import by.vonotirah.booklibrary.dao_layer.dao.BookDao;
import by.vonotirah.booklibrary.dao_layer.dao.UserDao;

public abstract class DaoFactory {

	public abstract BookDao getBookDao();

	public abstract UserDao getUserDao();

	public static DaoFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SQL")) {
			return new SqlDaoFactory();
		} else if (choice.equalsIgnoreCase("NOSQL")) {
			return new NoSqlDaoFactory();
		}
		return null;
	}

}
