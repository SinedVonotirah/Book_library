package by.vonotirah.booklibrary.persistence.sql;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;

public class SqlBookDao implements BookDao {

	public void createBook(Book book) throws SQLException {
		String sql = "INSERT INTO book (name) VALUES (?)";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, book.getName());
			statement.executeUpdate();
		}
	}

	public void updateBook(Book book) throws SQLException {
		String sql = "UPDATE book SET name=? WHERE id=?";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {

			statement.setString(1, book.getName());
			statement.setInt(2, Integer.parseInt(book.getId()));
			statement.executeUpdate();
		}
	}

	public void assignBook(Book book, User user) throws SQLException {
		String sql = "UPDATE book SET user_id=? WHERE id=?";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, Integer.parseInt(user.getId()));
			statement.setInt(2, Integer.parseInt(book.getId()));
			statement.executeUpdate();
		}
	}

	public Book getBookById(String id) throws SQLException {
		Book book = new Book();
		String sql = "SELECT * FROM book WHERE id=?";
		List<Book> list = new ArrayList<Book>();

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, Integer.parseInt(id));
			ResultSet result = statement.executeQuery();
			list = parseBookResultSet(result);
			if (!list.isEmpty()) {
				book = list.get(0);
				return book;
			}
		}
		return null;
	}

	@Override
	public Book getBookByName(String name) throws SQLException {
		Book book = new Book();
		String sql = "SELECT * FROM book WHERE name=?";
		List<Book> list = new ArrayList<Book>();

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			list = parseBookResultSet(result);
			if (!list.isEmpty()) {
				book = list.get(0);
			}
		}
		return book;
	}

	public void passBook(Book book) throws SQLException {
		String sql = "UPDATE book SET user_id=0 WHERE id=?";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, Integer.parseInt(book.getId()));
			statement.executeUpdate();
		}
	}

	public List<Book> getAllBooks() throws SQLException {
		String sql = "SELECT * FROM book";
		List<Book> list = new ArrayList<Book>();

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet result = statement.executeQuery(sql);
			list = parseBookResultSet(result);
		}

		return list;
	}

	public List<Book> getAllFreeBooks() throws SQLException {
		String sql = "SELECT * FROM book WHERE user_id=0";
		List<Book> list = new ArrayList<Book>();

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				Statement statement = connection.createStatement();) {
			ResultSet result = statement.executeQuery(sql);
			list = parseBookResultSet(result);
		}
		return list;
	}

	public void deleteBook(Book book) throws SQLException {
		String sql = "DELETE FROM book WHERE id=?";

		try (Connection connection = ConnectionFactory.getInstance()
				.getConnection();
				PreparedStatement statement = connection.prepareStatement(sql);) {
			statement.setInt(1, Integer.parseInt(book.getId()));
			statement.executeUpdate();
		}
	}

	private List<Book> parseBookResultSet(ResultSet result) throws SQLException {
		List<Book> list = new ArrayList<Book>();
		while (result.next()) {
			Book book = new Book();
			book.setId(Integer.toString(result.getInt(1)));
			book.setName(result.getString(2));
			book.setUserId(Integer.toString(result.getInt(3)));
			list.add(book);
		}
		return list;
	}

}
