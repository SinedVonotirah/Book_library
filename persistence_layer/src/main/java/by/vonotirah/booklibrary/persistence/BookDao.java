package by.vonotirah.booklibrary.persistence;

import java.sql.SQLException;
import java.util.List;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;

public interface BookDao {

	void createBook(Book book) throws SQLException;

	public void updateBook(Book book) throws SQLException;

	public void assignBook(Book book, User user) throws SQLException;

	public Book getBookById(String id) throws SQLException;

	public Book getBookByName(String name) throws SQLException;

	public void passBook(Book book) throws SQLException;

	public List<Book> getAllBooks() throws SQLException;

	public List<Book> getAllFreeBooks() throws SQLException;

	public void deleteBook(Book book) throws SQLException;
}
