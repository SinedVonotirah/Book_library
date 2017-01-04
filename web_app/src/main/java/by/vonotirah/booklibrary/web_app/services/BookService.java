package by.vonotirah.booklibrary.web_app.services;

import java.util.ArrayList;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;

public interface BookService {

	void createBook(Book book);

	void updateBook(Book book);

	void assignBook(Book book, User user);

	Book getBookById(String id);

	Book getBookByName(String name);

	void passBook(Book book);

	ArrayList<Book> getAllBooks();

	ArrayList<Book> getAllFreeBooks();

	void deleteBook(Book book);
}
