package by.vonotirah.booklibrary.web_app.rest;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookWebService;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;
import by.vonotirah.booklibrary.web_app.soap.DaoManagerSoapService;

@Path("/book")
public class BookRestService implements BookWebService {

	private DaoManagerWebService daoManager;

	public BookRestService() {
		super();
		daoManager = new DaoManagerSoapService();
	}

	@Override
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createBook(Book book) {
		try {
			daoManager.getBookDao().createBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(Book book) {
		try {
			daoManager.getBookDao().updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@POST
	@Path("/assign")
	@Consumes(MediaType.APPLICATION_JSON)
	public void assignBook(Book book, User user) {
		try {
			daoManager.getBookDao().assignBook(book, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@GET
	@Path("/id/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("id") String id) {
		try {
			return daoManager.getBookDao().getBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GET
	@Path("/name/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookByName(@PathParam("name") String name) {
		try {
			return daoManager.getBookDao().getBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PUT
	@Path("/pass")
	@Consumes(MediaType.APPLICATION_JSON)
	public void passBook(Book book) {
		try {
			daoManager.getBookDao().passBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getAllBooks() {
		try {
			return (ArrayList<Book>) daoManager.getBookDao().getAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GET
	@Path("/free")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getAllFreeBooks() {
		try {
			return (ArrayList<Book>) daoManager.getBookDao().getAllFreeBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteBook(Book book) {
		try {
			daoManager.getBookDao().deleteBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
