package by.vonotirah.booklibrary.web_app.rest;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;

public class DaoManagerRestService implements DaoManagerWebService {

	private BookDao bookDao;
	private UserDao userDao;

	public DaoManagerRestService() {
		super();
		bookDao = FactoryContext.getFactory("SQL").getBookDao();
		userDao = FactoryContext.getFactory("SQL").getUserDao();
	}

	@Override
	public BookDao getBookDao() {
		return bookDao;
	}

	@Override
	public UserDao getUserDao() {
		return userDao;
	}

	// TODO REST
	@Override
	public void changeDb(String db) {

		bookDao = FactoryContext.getFactory(db).getBookDao();
		userDao = FactoryContext.getFactory(db).getUserDao();
	}

}
