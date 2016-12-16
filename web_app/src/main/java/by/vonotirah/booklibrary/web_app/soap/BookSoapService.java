package by.vonotirah.booklibrary.web_app.soap;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.BookWebService")
public class BookSoapService implements BookWebService {

	public BookSoapService() {
		super();
	}

	@Override
	public void createBook(Book book) {
		try {
			DaoManagerSoapService.getBookDao().createBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book book) {
		try {
			DaoManagerSoapService.getBookDao().updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void assignBook(Book book, User user) {
		try {
			DaoManagerSoapService.getBookDao().assignBook(book, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book getBookById(String id) {
		try {
			return DaoManagerSoapService.getBookDao().getBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookByName(String name) {
		try {
			return DaoManagerSoapService.getBookDao().getBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void passBook(Book book) {
		try {
			DaoManagerSoapService.getBookDao().passBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		try {
			return (ArrayList<Book>) DaoManagerSoapService.getBookDao().getAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Book> getAllFreeBooks() {
		try {
			return (ArrayList<Book>) DaoManagerSoapService.getBookDao().getAllFreeBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		try {
			DaoManagerSoapService.getBookDao().deleteBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
