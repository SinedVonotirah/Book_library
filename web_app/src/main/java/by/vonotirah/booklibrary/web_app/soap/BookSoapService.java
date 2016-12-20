package by.vonotirah.booklibrary.web_app.soap;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookService;
import by.vonotirah.booklibrary.web_app.BookWebService;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class BookSoapService implements BookWebService {

	private BookService bookService;

	public BookSoapService() {
		super();
		bookService = SoapServiceManager.getBookService();
	}

	@Override
	@WebMethod
	public void createBook(Book book) {
		bookService.createBook(book);
	}

	@Override
	@WebMethod
	public void updateBook(Book book) {
		bookService.updateBook(book);
	}

	@Override
	@WebMethod
	public void assignBook(Book book, User user) {
		bookService.assignBook(book, user);
	}

	@Override
	@WebMethod
	public Book getBookById(String id) {
		return bookService.getBookById(id);
	}

	@Override
	@WebMethod
	public Book getBookByName(String name) {
		return bookService.getBookByName(name);
	}

	@Override
	@WebMethod
	public void passBook(Book book) {
		bookService.passBook(book);
	}

	@Override
	@WebMethod
	public ArrayList<Book> getAllBooks() {
		return bookService.getAllBooks();
	}

	@Override
	@WebMethod
	public ArrayList<Book> getAllFreeBooks() {
		return bookService.getAllFreeBooks();
	}

	@Override
	@WebMethod
	public void deleteBook(Book book) {
		bookService.deleteBook(book);
	}

}
