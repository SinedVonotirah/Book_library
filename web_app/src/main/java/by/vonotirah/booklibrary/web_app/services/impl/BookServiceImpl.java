package by.vonotirah.booklibrary.web_app.services.impl;

import java.sql.SQLException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.DaoFactory;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.BookService;
import by.vonotirah.booklibrary.web_app.services.DynamicDaoListener;

public class BookServiceImpl implements BookService, DynamicDaoListener {

	private BookDao bookDao;
	private AppContext context;

	private static final Logger LOGGER = LoggerFactory.getLogger(BookServiceImpl.class);

	public BookServiceImpl(AppContext context) {
		super();
		this.context = context;
		this.bookDao = ((DaoFactory) context.getBean(AppContext.DAO_FACTORY_KEY)).getBookDao();
	}

	@Override
	public void createBook(Book book) {
		try {
			bookDao.createBook(book);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void updateBook(Book book) {
		try {
			bookDao.updateBook(book);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void assignBook(Book book, User user) {
		try {
			bookDao.assignBook(book, user);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book getBookById(String id) {
		try {
			return bookDao.getBookById(id);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public Book getBookByName(String name) {
		try {
			return bookDao.getBookByName(name);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void passBook(Book book) {
		try {
			bookDao.passBook(book);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		try {
			return (ArrayList<Book>) bookDao.getAllBooks();
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public ArrayList<Book> getAllFreeBooks() {
		try {
			return (ArrayList<Book>) bookDao.getAllFreeBooks();
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void deleteBook(Book book) {
		try {
			bookDao.deleteBook(book);
		} catch (SQLException e) {
			LOGGER.error("Exception" + e.toString());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void onDaoChange() {
		this.bookDao = ((DaoFactory) context.getBean(AppContext.DAO_FACTORY_KEY)).getBookDao();
	}
}
