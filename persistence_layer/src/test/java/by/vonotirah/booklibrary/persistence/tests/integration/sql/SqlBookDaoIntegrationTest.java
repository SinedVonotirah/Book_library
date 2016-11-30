package by.vonotirah.booklibrary.persistence.tests.integration.sql;

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

public class SqlBookDaoIntegrationTest extends AbstractTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(SqlBookDaoIntegrationTest.class);

	private BookDao sqlBookDao;

	@Before
	public void setUp() {
		sqlBookDao = FactoryContext.getFactory("SQL").getBookDao();
	}

	@Test
	public void bookCRUDTest() throws SQLException {
		LOGGER.info("----------------noSqlBookCRUDTest()----------------------");
		LOGGER.info("----------------Create Book----------------------");
		Book book = getRandomBookObject();
		sqlBookDao.createBook(book);
		LOGGER.info("----------------Read Book----------------------");
		Book createdBook = sqlBookDao.getBookByName(book.getName());
		Assert.assertNotNull(createdBook);
		Assert.assertEquals(book.getName(), createdBook.getName());

		LOGGER.info("----------------Update Book----------------------");
		createdBook.setName(randomString("updated name"));
		sqlBookDao.updateBook(createdBook);
		Book updatedBook = sqlBookDao.getBookById(createdBook.getId());
		Assert.assertNotNull(updatedBook);
		Assert.assertEquals(updatedBook.getName(), createdBook.getName());
		Assert.assertNotEquals(updatedBook.getName(), book.getName());

		LOGGER.info("----------------Delete Book----------------------");

		sqlBookDao.deleteBook(updatedBook);
		Assert.assertNull(sqlBookDao.getBookById(updatedBook.getId()));
	}
}
