package by.vonotirah.booklibrary.web_app;

import java.util.ArrayList;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface BookWebService {

	@WebMethod
	void createBook(Book book);

	@WebMethod
	void updateBook(Book book);

	@WebMethod
	void assignBook(Book book, User user);

	@WebMethod
	Book getBookById(String id);

	@WebMethod
	Book getBookByName(String name);

	@WebMethod
	void passBook(Book book);

	@WebMethod
	ArrayList<Book> getAllBooks();

	@WebMethod
	ArrayList<Book> getAllFreeBooks();

	@WebMethod
	void deleteBook(Book book);
}
