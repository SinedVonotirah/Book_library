package by.vonotirah.booklibrary.web_app.rest;

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
import by.vonotirah.booklibrary.web_app.BookService;
import by.vonotirah.booklibrary.web_app.BookWebService;

@Path("/book")
public class BookRestService implements BookWebService {

	private BookService bookService;

	public BookRestService() {
		super();
		bookService = RestServiceManager.getBookService();
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createBook(Book book) {
		bookService.createBook(book);
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateBook(Book book) {
		bookService.updateBook(book);
	}

	@Override
	@POST
	@Path("/assign")
	@Consumes(MediaType.APPLICATION_JSON)
	public void assignBook(Book book, User user) {
		bookService.assignBook(book, user);
	}

	@Override
	@GET
	@Path("/id/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("id") String id) {
		return bookService.getBookById(id);
	}

	@Override
	@GET
	@Path("/name/{name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookByName(@PathParam("name") String name) {
		return bookService.getBookByName(name);
	}

	@Override
	@PUT
	@Path("/pass")
	@Consumes(MediaType.APPLICATION_JSON)
	public void passBook(Book book) {
		bookService.passBook(book);
	}

	@Override
	@GET
	@Path("/all")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@Override
	@GET
	@Path("/free")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public ArrayList<Book> getAllFreeBooks() {
		return bookService.getAllFreeBooks();
	}

	@Override
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteBook(Book book) {
		bookService.deleteBook(book);
	}

}
