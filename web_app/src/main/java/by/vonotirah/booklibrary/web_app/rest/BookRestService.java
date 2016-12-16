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

@Path("/book")
public class BookRestService implements BookWebService {

	public BookRestService() {
		super();
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createBook(Book book) {
		try {
			DaoManagerRestService.getBookDao().createBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(Book book) {
		try {
			DaoManagerRestService.getBookDao().updateBook(book);
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
			DaoManagerRestService.getBookDao().assignBook(book, user);
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
			return DaoManagerRestService.getBookDao().getBookById(id);
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
			return DaoManagerRestService.getBookDao().getBookByName(name);
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
			DaoManagerRestService.getBookDao().passBook(book);
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
			return (ArrayList<Book>) DaoManagerRestService.getBookDao().getAllBooks();
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
			return (ArrayList<Book>) DaoManagerRestService.getBookDao().getAllFreeBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteBook(Book book) {
		try {
			DaoManagerRestService.getBookDao().deleteBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
