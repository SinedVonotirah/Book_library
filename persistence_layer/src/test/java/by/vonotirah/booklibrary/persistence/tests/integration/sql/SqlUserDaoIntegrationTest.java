package by.vonotirah.booklibrary.persistence.tests.integration.sql;

import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class SqlUserDaoIntegrationTest extends AbstractTest {
	private static final Logger LOGGER = LoggerFactory
			.getLogger(SqlUserDaoIntegrationTest.class);

	private UserDao sqlUserDao;

	@Before
	public void setUp() {
		sqlUserDao = FactoryContext.getFactory("SQL").getUserDao();
	}

	@Test
	public void noSqlBookCRUDTest() throws SQLException {
		LOGGER.info("----------------noSqlBookCRUDTest()----------------------");
		LOGGER.info("----------------Create User----------------------");
		User user = getRandomUserObject();
		sqlUserDao.createUser(user);
		LOGGER.info("----------------Read User----------------------");
		User createdUser = sqlUserDao.getUserByLastName(user.getLastName());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());

		LOGGER.info("----------------Update User----------------------");
		createdUser.setLastName(randomString("updated last Name"));
		createdUser.setFirstName(randomString("updated first Name"));
		sqlUserDao.updateUser(createdUser);
		User updatedUser = sqlUserDao.getUserById(createdUser.getId());
		Assert.assertNotNull(updatedUser);
		Assert.assertEquals(updatedUser.getFirstName(),
				createdUser.getFirstName());
		Assert.assertEquals(updatedUser.getLastName(),
				createdUser.getLastName());
		Assert.assertNotEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertNotEquals(user.getLastName(), createdUser.getLastName());

		LOGGER.info("----------------Delete Book----------------------");

		sqlUserDao.deleteUser(updatedUser);
		Assert.assertNull(sqlUserDao.getUserById(updatedUser.getId()));
	}
}
