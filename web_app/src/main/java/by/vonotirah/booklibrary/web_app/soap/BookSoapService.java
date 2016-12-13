package by.vonotirah.booklibrary.web_app.soap;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookWebService;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;

@WebService(endpointInterface = "by.vonotirah.booklibrary.web_app.BookWebService")
public class BookSoapService implements BookWebService {

	private DaoManagerWebService daoManager;

	public BookSoapService() {
		super();
		daoManager = new DaoManagerSoapService();
	}

	@Override
	public void createBook(Book book) {
		try {
			daoManager.getBookDao().createBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateBook(Book book) {
		try {
			daoManager.getBookDao().updateBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void assignBook(Book book, User user) {
		try {
			daoManager.getBookDao().assignBook(book, user);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public Book getBookById(String id) {
		// TODO Auto-generated method stub
		try {
			return daoManager.getBookDao().getBookById(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Book getBookByName(String name) {
		// TODO Auto-generated method stub
		try {
			return daoManager.getBookDao().getBookByName(name);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void passBook(Book book) {
		try {
			daoManager.getBookDao().passBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ArrayList<Book> getAllBooks() {
		// TODO Auto-generated method stub
		try {
			return (ArrayList<Book>) daoManager.getBookDao().getAllBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public ArrayList<Book> getAllFreeBooks() {
		// TODO Auto-generated method stub
		try {
			return (ArrayList<Book>) daoManager.getBookDao().getAllFreeBooks();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void deleteBook(Book book) {
		// TODO Auto-generated method stub
		try {
			daoManager.getBookDao().deleteBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
