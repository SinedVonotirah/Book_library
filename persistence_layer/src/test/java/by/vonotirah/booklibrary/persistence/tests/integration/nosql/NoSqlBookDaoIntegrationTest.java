package by.vonotirah.booklibrary.persistence.tests.integration.nosql;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.factory.DaoFactoryContext;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class NoSqlBookDaoIntegrationTest extends AbstractTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NoSqlBookDaoIntegrationTest.class);

	private BookDao bookDao;

	@Before
	public void setUp() {
		bookDao = DaoFactoryContext.getFactory("NOSQL").getBookDao();
	}

	@Test
	public void noSqlBookCRUDTest() throws SQLException {
		LOGGER.info("----------------noSqlBookCRUDTest()----------------------");
		LOGGER.info("----------------Create Book----------------------");
		Book book = getRandomBookObject();
		bookDao.createBook(book);
		LOGGER.info("----------------Read Book----------------------");
		Book createdBook = bookDao.getBookByName(book.getName());
		Assert.assertNotNull(createdBook);
		Assert.assertEquals(book.getName(), createdBook.getName());

		LOGGER.info("----------------Update Book----------------------");
		createdBook.setName(randomString("updated name"));
		bookDao.updateBook(createdBook);
		Book updatedBook = bookDao.getBookById(createdBook.getId());
		Assert.assertNotNull(updatedBook);
		Assert.assertEquals(updatedBook.getName(), createdBook.getName());
		Assert.assertNotEquals(updatedBook.getName(), book.getName());

		LOGGER.info("----------------Delete Book----------------------");

		bookDao.deleteBook(updatedBook);
		Assert.assertNull(bookDao.getBookById(updatedBook.getId()));
	}

	@Test
	public void assignBookTest() throws Exception {
		LOGGER.info("----------------assignBookTest()----------------------");
		UserDao userDao = DaoFactoryContext.getFactory("NOSQL").getUserDao();

		Book book = getRandomBookObject();
		User user = getRandomUserObject();

		userDao.createUser(user);
		bookDao.createBook(book);
		Book bookFromDB = bookDao.getBookByName(book.getName());
		User userFromDB = userDao.getUserByLastName(user.getLastName());
		bookDao.assignBook(bookFromDB, userFromDB);

		Book assignedBook = bookDao.getBookByName(book.getName());

		Assert.assertEquals(assignedBook.getUserId(), userFromDB.getId());
	}
}
