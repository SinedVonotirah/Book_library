package by.vonotirah.booklibrary.dao_layer.dao_factory;

import by.vonotirah.booklibrary.dao_layer.dao.BookDao;
import by.vonotirah.booklibrary.dao_layer.dao.UserDao;
import by.vonotirah.booklibrary.dao_layer.dao.book_dao.SqlBookDao;

public class SqlDaoFactory extends DaoFactory {

	@Override
	public BookDao getBookDao() {
		// TODO Auto-generated method stub
		return new SqlBookDao();
	}

	@Override
	public UserDao getUserDao() {
		// TODO Auto-generated method stub
		return null;
	}

}
