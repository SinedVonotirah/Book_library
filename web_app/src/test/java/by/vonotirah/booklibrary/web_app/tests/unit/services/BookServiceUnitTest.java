package by.vonotirah.booklibrary.web_app.tests.unit.services;

import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.modules.junit4.PowerMockRunner;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.factory.SqlDaoFactory;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.BookService;
import by.vonotirah.booklibrary.web_app.services.impl.BookServiceImpl;
import by.vonotirah.booklibrary.web_app.tests.AbstractTest;

@RunWith(PowerMockRunner.class)
public class BookServiceUnitTest extends AbstractTest {

	private BookDao mockedBookDao;
	private BookService bookService;
	private SqlDaoFactory mockedSqlDaoFactory;
	private AppContext context;

	@Before
	public void setUp() {
		context = AppContext.getInstance();
		mockedBookDao = Mockito.mock(BookDao.class);
		mockedSqlDaoFactory = Mockito.mock(SqlDaoFactory.class);
		context.registrBean(AppContext.DAO_FACTORY_KEY, mockedSqlDaoFactory);
		Mockito.when(mockedSqlDaoFactory.getBookDao()).thenReturn(mockedBookDao);
		bookService = new BookServiceImpl(context);
	}

	@Test
	public void createBookSoapUnitTest() throws SQLException {
		Book book = getRandomBookObject();
		bookService.createBook(book);

		verify(mockedBookDao).createBook(book);
	}

	@Test
	public void updateBookSoapUnitTest() throws SQLException {
		Book book = getRandomBookObject();
		bookService.updateBook(book);

		verify(mockedBookDao).updateBook(book);
	}

	@Test
	public void assignBookSoapUnitTest() throws SQLException {
		Book book = getRandomBookObject();
		User user = getRandomUserObject();
		bookService.assignBook(book, user);

		verify(mockedBookDao).assignBook(book, user);

	}

	@Test
	public void getBookByIdSoapUnitTest() throws SQLException {
		// bookService.getBookById(Mockito.anyString());
		bookService.getBookById(new String());

		verify(mockedBookDao).getBookById(new String());
	}

	@Test
	public void getBookByNameSoapUnitTest() throws SQLException {
		// bookService.getBookByName(Mockito.anyString());
		bookService.getBookByName(new String());

		verify(mockedBookDao).getBookByName(new String());
	}

	@Test
	public void passBookSoapUnitTest() throws SQLException {
		Book book = getRandomBookObject();
		bookService.passBook(book);

		verify(mockedBookDao).passBook(book);
	}

	// @Test
	public void getAllBooksSoapUnitTest() throws SQLException {
		bookService.getAllBooks();

		verify(mockedBookDao).getAllBooks();
	}

	// @Test
	public void getAllFreeBooksSoapUnitTest() throws SQLException {
		bookService.getAllFreeBooks();

		verify(mockedBookDao).getAllFreeBooks();
	}

	@Test
	public void deleteBookSoapUnitTest() throws SQLException {
		Book book = getRandomBookObject();
		bookService.deleteBook(book);

		verify(mockedBookDao).deleteBook(book);
	}
}
