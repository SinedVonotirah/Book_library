package by.vonotirah.booklibrary.web_app.soap;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.DaoManagerWebService")
public class DaoManagerSoapService implements DaoManagerWebService {

	private static BookDao bookDao;
	private static UserDao userDao;

	static {
		bookDao = FactoryContext.getFactory("SQL").getBookDao();
		userDao = FactoryContext.getFactory("SQL").getUserDao();
	}

	@Override
	public void changeDb(String db) {
		bookDao = FactoryContext.getFactory(db).getBookDao();
		userDao = FactoryContext.getFactory(db).getUserDao();
	}

	public static BookDao getBookDao() {
		return bookDao;
	}

	public static UserDao getUserDao() {
		return userDao;
	}

}
