package by.vonotirah.booklibrary.web_app.tests.unit.rest;

import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.tests.AbstractTest;
import by.vonotirah.booklibrary.web_app.BookService;
import by.vonotirah.booklibrary.web_app.BookWebService;
import by.vonotirah.booklibrary.web_app.rest.RestServiceManager;
import by.vonotirah.booklibrary.web_app.rest.BookRestService;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RestServiceManager.class)
public class BookRestServiceUnitTest extends AbstractTest {

	private BookService mockedBookService;

	@Before
	public void setUp() {
		PowerMockito.mockStatic(RestServiceManager.class);
		mockedBookService = Mockito.mock(BookService.class);
		PowerMockito.when(RestServiceManager.getBookService()).thenReturn(mockedBookService);
	}

	@Test
	public void createBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		Book book = getRandomBookObject();
		bookService.createBook(book);

		verify(mockedBookService).createBook(book);
	}

	@Test
	public void updateBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		Book book = getRandomBookObject();
		bookService.updateBook(book);

		verify(mockedBookService).updateBook(book);
	}

	@Test
	public void assignBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		Book book = getRandomBookObject();
		User user = getRandomUserObject();
		bookService.assignBook(book, user);

		verify(mockedBookService).assignBook(book, user);

	}

	@Test
	public void getBookByIdSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		// bookService.getBookById(Mockito.anyString());
		bookService.getBookById(new String());

		verify(mockedBookService).getBookById(new String());
	}

	@Test
	public void getBookByNameSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		// bookService.getBookByName(Mockito.anyString());
		bookService.getBookByName(new String());

		verify(mockedBookService).getBookByName(new String());
	}

	@Test
	public void passBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		Book book = getRandomBookObject();
		bookService.passBook(book);

		verify(mockedBookService).passBook(book);
	}

	@Test
	public void getAllBooksSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		bookService.getAllBooks();

		verify(mockedBookService).getAllBooks();
	}

	@Test
	public void getAllFreeBooksSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		bookService.getAllFreeBooks();

		verify(mockedBookService).getAllFreeBooks();
	}

	@Test
	public void deleteBookSoapUnitTest() throws SQLException {
		BookWebService bookService = new BookRestService();
		Book book = getRandomBookObject();
		bookService.deleteBook(book);

		verify(mockedBookService).deleteBook(book);
	}
}
