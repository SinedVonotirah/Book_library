package by.vonotirah.booklibrary.persistence.tests.unit.sql;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.sql.SqlBookDao;
import by.vonotirah.booklibrary.persistence.sql.SqlConnectionFactory;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class SqlBookDaoUnitTest extends AbstractTest {

	private SqlConnectionFactory mockedConnectionFactory;
	private Connection mockedConnection;
	private PreparedStatement mockedPreparedStatement;
	private Statement mockedStatement;
	private ResultSet mockedResultSet;

	@Before
	public void dependencies() throws Exception {
		mockedConnectionFactory = mock(SqlConnectionFactory.class);
		mockedConnection = mock(Connection.class);
		mockedPreparedStatement = mock(PreparedStatement.class);
		mockedStatement = mock(Statement.class);
		mockedResultSet = mock(ResultSet.class);

		when(mockedConnectionFactory.getConnection()).thenReturn(mockedConnection);
		when(mockedConnection.prepareStatement(anyString())).thenReturn(mockedPreparedStatement);
		when(mockedConnection.createStatement()).thenReturn(mockedStatement);
		when(mockedStatement.executeQuery(anyString())).thenReturn(mockedResultSet);
		when(mockedPreparedStatement.executeQuery()).thenReturn(mockedResultSet);
	}

	@Test
	public void createBookUnitTest() throws SQLException {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		Book book = getRandomBookObject();
		bookDao.createBook(book);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, book.getName());
		verify(mockedPreparedStatement).executeUpdate();
	}

	@Test
	public void updateBookUnitTest() throws SQLException {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		Book book = getRandomBookObject();
		book.setId("1");
		bookDao.updateBook(book);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, book.getName());
		verify(mockedPreparedStatement).setInt(2, Integer.parseInt(book.getId()));
		verify(mockedPreparedStatement).executeUpdate();
	}

	@Test
	public void assignBookUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		Book book = getRandomBookObject();
		User user = getRandomUserObject();
		book.setId("1");
		user.setId("1");
		bookDao.assignBook(book, user);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setInt(1, Integer.parseInt(user.getId()));
		verify(mockedPreparedStatement).setInt(2, Integer.parseInt(book.getId()));
		verify(mockedPreparedStatement).executeUpdate();
	}

	@Test
	public void getBookByIdUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		bookDao.getBookById("1");
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setInt(1, Integer.parseInt("1"));
		verify(mockedPreparedStatement).executeQuery();
	}

	@Test
	public void getBookByNameUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		bookDao.getBookByName("1");
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, "1");
		verify(mockedPreparedStatement).executeQuery();
	}

	@Test
	public void passBookUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		Book book = getRandomBookObject();
		book.setId("1");
		bookDao.passBook(book);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setInt(1, Integer.parseInt(book.getId()));
		verify(mockedPreparedStatement).executeUpdate();
	}

	@Test
	public void getAllBooksUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		bookDao.getAllBooks();
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).createStatement();
		verify(mockedStatement).executeQuery(anyString());
	}

	@Test
	public void getAllFreeBooksUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		bookDao.getAllFreeBooks();
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).createStatement();
		verify(mockedStatement).executeQuery(anyString());
	}

	@Test
	public void deleteBookUnitTest() throws Exception {
		BookDao bookDao = new SqlBookDao(mockedConnectionFactory);
		Book book = getRandomBookObject();
		book.setId("1");
		bookDao.deleteBook(book);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setInt(1, Integer.parseInt(book.getId()));
		verify(mockedPreparedStatement).executeUpdate();
	}

}
