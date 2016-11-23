package by.vonotirah.booklibrary.dao_layer.tests.integration;

import java.sql.SQLException;

import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.vonotirah.booklibrary.dao_layer.dao.BookDao;
import by.vonotirah.booklibrary.dao_layer.dao_factory.DaoFactory;
import by.vonotirah.booklibrary.dao_layer.domain.Book;
import by.vonotirah.booklibrary.dao_layer.tests.AbstractTest;

public class SqlBookDaoIntegrationTest extends AbstractTest {

	private static BookDao bookDao;

	private static final Logger LOGGER = LoggerFactory.getLogger(SqlBookDaoIntegrationTest.class);

	@BeforeClass
	public static void config() {
		DaoFactory sqlDaoFactory = DaoFactory.getFactory("SQL");
		bookDao = sqlDaoFactory.getBookDao();
	}

	@Test
	public void bookCRUDTest() {
		LOGGER.info("----------------bookCRUDTest()----------------------");

		Book book = getRandomBookObject();
		LOGGER.info("----------------CREATE/READ-------------------------");
		try {
			bookDao.createBook(book);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		System.out.println(book.getId());

	}

}
