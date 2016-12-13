package by.vonotirah.booklibrary.web_app.soap;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.DaoManagerWebService")
public class DaoManagerSoapService implements DaoManagerWebService {

	private BookDao bookDao;
	private UserDao userDao;

	public DaoManagerSoapService() {
		super();
		bookDao = FactoryContext.getFactory("SQL").getBookDao();
		userDao = FactoryContext.getFactory("SQL").getUserDao();
	}

	@Override
	public void changeDb(String db) {
		bookDao = FactoryContext.getFactory(db).getBookDao();
		userDao = FactoryContext.getFactory(db).getUserDao();
	}

	@Override
	public BookDao getBookDao() {
		return bookDao;
	}

	@Override
	public UserDao getUserDao() {
		return userDao;
	}

}
