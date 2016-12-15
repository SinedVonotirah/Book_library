package by.vonotirah.booklibrary.web_app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;

@Path("/")
public class DaoManagerRestService implements DaoManagerWebService {

	private static BookDao bookDao;
	private static UserDao userDao;

	static {
		bookDao = FactoryContext.getFactory("SQL").getBookDao();
		userDao = FactoryContext.getFactory("SQL").getUserDao();
	}

	public static BookDao getBookDao() {
		return bookDao;
	}

	public static UserDao getUserDao() {
		return userDao;
	}

	@Override
	@PUT
	@Path("{db}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void changeDb(@PathParam("db") String db) {

		bookDao = FactoryContext.getFactory(db).getBookDao();
		userDao = FactoryContext.getFactory(db).getUserDao();
	}

}
