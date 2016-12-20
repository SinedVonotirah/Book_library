package by.vonotirah.booklibrary.web_app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import by.vonotirah.booklibrary.persistence.factory.DaoFactoryContext;
import by.vonotirah.booklibrary.web_app.BookService;
import by.vonotirah.booklibrary.web_app.ServiceManager;
import by.vonotirah.booklibrary.web_app.UserService;
import by.vonotirah.booklibrary.web_app.services.BookServiceImpl;
import by.vonotirah.booklibrary.web_app.services.UserServiceImpl;

@Path("/setup")
public class RestServiceManager implements ServiceManager {

	private static BookService bookService;
	private static UserService userService;
	private static String currentBookDb = "SQL";
	private static String currentUserDb = "SQL";
	private static final String SQL_DB = "SQL";
	private static final String NO_SQL_DB = "NOSQL";

	@Override
	@PUT
	@Path("{db}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void changeBookDb(@PathParam("db") String db) {
		if (db.equalsIgnoreCase(SQL_DB)) {
			currentBookDb = SQL_DB;
		}
		if (db.equalsIgnoreCase(NO_SQL_DB)) {
			currentBookDb = NO_SQL_DB;
		}
	}

	@Override
	@PUT
	@Path("{db}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void changeUserDb(@PathParam("db") String db) {
		if (db.equalsIgnoreCase(SQL_DB)) {
			currentUserDb = SQL_DB;
		}
		if (db.equalsIgnoreCase(NO_SQL_DB)) {
			currentUserDb = NO_SQL_DB;
		}
	}

	public static BookService getBookService() {
		System.out.println("start");
		if (bookService == null) {
			System.out.println("if");
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
