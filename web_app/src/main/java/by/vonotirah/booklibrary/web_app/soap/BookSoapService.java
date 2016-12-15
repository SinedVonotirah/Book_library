package by.vonotirah.booklibrary.web_app.soap;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.BookWebService")
public class BookSoapService implements BookWebService {

	private BookDao bookDao;

	public BookSoapService() {
		super();
		bookDao = DaoManagerSoapService.getBookDao();
	}

	@Override
	public void createBook(Book book) {
		try {
			bookDao.createBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void assignBook(Book book, User user) {
		try {
			bookDao.assignBook(book, user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public Book getBookById(String id) {
		try {
			return bookDao.getBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookByName(String name) {
		try {
			return bookDao.getBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void passBook(Book book) {
		try {
			bookDao.passBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		try {
			return (ArrayList<Book>) bookDao.getAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Book> getAllFreeBooks() {
		try {
			return (ArrayList<Book>) bookDao.getAllFreeBooks();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		try {
			bookDao.deleteBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
