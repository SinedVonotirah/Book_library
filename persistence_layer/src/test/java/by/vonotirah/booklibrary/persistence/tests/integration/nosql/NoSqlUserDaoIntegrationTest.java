package by.vonotirah.booklibrary.persistence.tests.integration.nosql;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.factory.DaoFactoryContext;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class NoSqlUserDaoIntegrationTest extends AbstractTest {

	private static final Logger LOGGER = LoggerFactory
			.getLogger(NoSqlUserDaoIntegrationTest.class);

	private UserDao noSqlUserDao;

	@Before
	public void setUp() {
		noSqlUserDao = DaoFactoryContext.getFactory("NOSQL").getUserDao();
	}

	@Test
	public void noSqlBookCRUDTest() throws SQLException {
		LOGGER.info("----------------noSqlBookCRUDTest()----------------------");
		LOGGER.info("----------------Create User----------------------");
		User user = getRandomUserObject();
		noSqlUserDao.createUser(user);
		LOGGER.info("----------------Read User----------------------");
		User createdUser = noSqlUserDao.getUserByLastName(user.getLastName());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());

		LOGGER.info("----------------Update User----------------------");
		createdUser.setLastName(randomString("updated last Name"));
		createdUser.setFirstName(randomString("updated first Name"));
		noSqlUserDao.updateUser(createdUser);
		User updatedUser = noSqlUserDao.getUserById(createdUser.getId());
		Assert.assertNotNull(updatedUser);
		Assert.assertEquals(updatedUser.getFirstName(),
				createdUser.getFirstName());
		Assert.assertEquals(updatedUser.getLastName(),
				createdUser.getLastName());
		Assert.assertNotEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertNotEquals(user.getLastName(), createdUser.getLastName());

		LOGGER.info("----------------Delete Book----------------------");

		noSqlUserDao.deleteUser(updatedUser);
		Assert.assertNull(noSqlUserDao.getUserById(updatedUser.getId()));
	}
}
