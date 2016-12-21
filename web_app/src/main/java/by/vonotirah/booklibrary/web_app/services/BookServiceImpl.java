package by.vonotirah.booklibrary.web_app.services;

import java.sql.SQLException;
import java.util.ArrayList;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookService;

public class BookServiceImpl implements BookService {

	private BookDao bookDao;

	public BookServiceImpl(BookDao bookDao) {
		super();
		this.bookDao = bookDao;
	}

	@Override
	public void createBook(Book book) {
		try {
			bookDao.createBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void assignBook(Book book, User user) {
		try {
			bookDao.assignBook(book, user);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book getBookById(String id) {
		try {
			return bookDao.getBookById(id);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book getBookByName(String name) {
		try {
			return bookDao.getBookByName(name);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void passBook(Book book) {
		try {
			bookDao.passBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		try {
			return (ArrayList<Book>) bookDao.getAllBooks();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Book> getAllFreeBooks() {
		try {
			return (ArrayList<Book>) bookDao.getAllFreeBooks();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBook(Book book) {
		try {
			bookDao.deleteBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
