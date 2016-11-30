package by.vonotirah.booklibrary.persistence.tests.integration.nosql;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class NoSqlBookDaoIntegrationTest extends AbstractTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NoSqlBookDaoIntegrationTest.class);

	private BookDao noSqlBookDao;

	@Before
	public void setUp() {
		noSqlBookDao = FactoryContext.getFactory("NOSQL").getBookDao();
	}

	@Test
	public void noSqlBookCRUDTest() throws SQLException {
		LOGGER.info("----------------noSqlBookCRUDTest()----------------------");
		LOGGER.info("----------------Create Book----------------------");
		Book book = getRandomBookObject();
		noSqlBookDao.createBook(book);
		LOGGER.info("----------------Read Book----------------------");
		Book createdBook = noSqlBookDao.getBookByName(book.getName());
		Assert.assertNotNull(createdBook);
		Assert.assertEquals(book.getName(), createdBook.getName());

		LOGGER.info("----------------Update Book----------------------");
		createdBook.setName(randomString("updated name"));
		noSqlBookDao.updateBook(createdBook);
		Book updatedBook = noSqlBookDao.getBookById(createdBook.getId());
		Assert.assertNotNull(updatedBook);
		Assert.assertEquals(updatedBook.getName(), createdBook.getName());
		Assert.assertNotEquals(updatedBook.getName(), book.getName());

		LOGGER.info("----------------Delete Book----------------------");

		noSqlBookDao.deleteBook(updatedBook);
		Assert.assertNull(noSqlBookDao.getBookById(updatedBook.getId()));
	}
}
