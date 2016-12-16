package by.vonotirah.booklibrary.web_app.tests.unit.soap;

import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.BookWebService;
import by.vonotirah.booklibrary.web_app.soap.BookSoapService;
import by.vonotirah.booklibrary.web_app.soap.DaoManagerSoapService;
import by.vonotirah.booklibrary.web_app.tests.AbstractTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DaoManagerSoapService.class)
public class BookSoapServiceUnitTest extends AbstractTest {

	private BookDao mockedBookDao;

	@Before
	public void setUp() {
		PowerMockito.mockStatic(DaoManagerSoapService.class);
		mockedBookDao = Mockito.mock(BookDao.class);
		PowerMockito.when(DaoManagerSoapService.getBookDao()).thenReturn(mockedBookDao);
	}

	@Test
	public void createBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		Book book = getRandomBookObject();
		bookService.createBook(book);

		verify(mockedBookDao).createBook(book);
	}

	@Test
	public void updateBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		Book book = getRandomBookObject();
		bookService.updateBook(book);

		verify(mockedBookDao).updateBook(book);
	}

	@Test
	public void assignBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		Book book = getRandomBookObject();
		User user = getRandomUserObject();
		bookService.assignBook(book, user);

		verify(mockedBookDao).assignBook(book, user);

	}

	@Test
	public void getBookByIdSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		// bookService.getBookById(Mockito.anyString());
		bookService.getBookById(new String());

		verify(mockedBookDao).getBookById(new String());
	}

	@Test
	public void getBookByNameSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		// bookService.getBookByName(Mockito.anyString());
		bookService.getBookByName(new String());

		verify(mockedBookDao).getBookByName(new String());
	}

	@Test
	public void passBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		Book book = getRandomBookObject();
		bookService.passBook(book);

		verify(mockedBookDao).passBook(book);
	}

	// @Test
	public void getAllBooksSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		bookService.getAllBooks();

		verify(mockedBookDao).getAllBooks();
	}

	// @Test
	public void getAllFreeBooksSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		bookService.getAllFreeBooks();

		verify(mockedBookDao).getAllFreeBooks();
	}

	@Test
	public void deleteBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookSoapService();
		Book book = getRandomBookObject();
		bookService.deleteBook(book);

		verify(mockedBookDao).deleteBook(book);
	}
}
