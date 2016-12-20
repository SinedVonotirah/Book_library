package by.vonotirah.booklibrary.web_app.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.vonotirah.booklibrary.persistence.factory.DaoFactoryContext;
import by.vonotirah.booklibrary.web_app.BookService;
import by.vonotirah.booklibrary.web_app.ServiceManager;
import by.vonotirah.booklibrary.web_app.UserService;
import by.vonotirah.booklibrary.web_app.services.BookServiceImpl;
import by.vonotirah.booklibrary.web_app.services.UserServiceImpl;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SoapServiceManager implements ServiceManager {

	private static BookService bookService;
	private static UserService userService;
	private static String currentBookDb = "SQL";
	private static String currentUserDb = "SQL";
	private static final String SQL_DB = "SQL";
	private static final String NO_SQL_DB = "NOSQL";

	@Override
	@WebMethod
	public void changeBookDb(String db) {
		if (db.equalsIgnoreCase(SQL_DB)) {
			currentBookDb = SQL_DB;
		}
		if (db.equalsIgnoreCase(NO_SQL_DB)) {
			currentBookDb = NO_SQL_DB;
		}
	}

	@Override
	@WebMethod
	public void changeUserDb(String db) {
		if (db.equalsIgnoreCase(SQL_DB)) {
			currentUserDb = SQL_DB;
		}
		if (db.equalsIgnoreCase(NO_SQL_DB)) {
			currentUserDb = NO_SQL_DB;
		}
	}

	public static BookService getBookService() {
		if (bookService == null) {
			bookService = new BookServiceImpl(DaoFactoryContext.getFactory(currentBookDb).getBookDao());
		}
		return bookService;
	}

	public static UserService getUserService() {
		if (userService == null) {
			userService = new UserServiceImpl(DaoFactoryContext.getFactory(currentUserDb).getUserDao());
		}
		return userService;
	}

}
