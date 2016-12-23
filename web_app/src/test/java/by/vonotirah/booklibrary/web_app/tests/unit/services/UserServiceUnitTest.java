package by.vonotirah.booklibrary.web_app.tests.unit.services;

import static org.mockito.Mockito.verify;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.factory.SqlDaoFactory;
import by.vonotirah.booklibrary.web_app.rest.RestServiceManager;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.UserService;
import by.vonotirah.booklibrary.web_app.services.impl.UserServiceImpl;
import by.vonotirah.booklibrary.web_app.tests.AbstractTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RestServiceManager.class)
public class UserServiceUnitTest extends AbstractTest {

	private UserDao mockedUserDao;
	private UserService userService;
	private SqlDaoFactory mockedSqlDaoFactory;
	private AppContext context;

	@Before
	public void setUp() {
		context = AppContext.getInstance();
		mockedUserDao = Mockito.mock(UserDao.class);
		mockedSqlDaoFactory = Mockito.mock(SqlDaoFactory.class);
		context.registrBean(AppContext.DAO_FACTORY_KEY, mockedSqlDaoFactory);
		Mockito.when(mockedSqlDaoFactory.getUserDao()).thenReturn(mockedUserDao);
		userService = new UserServiceImpl(context);
	}

	@Test
	public void createUserSoapUnitTest() throws SQLException {
		User user = getRandomUserObject();
		userService.createUser(user);

		verify(mockedUserDao).createUser(user);
	}

	@Test
	public void getUserByIdSoapUnitTest() throws SQLException {
		// userService.getUserById(Mockito.anyString());
		userService.getUserById(new String());

		verify(mockedUserDao).getUserById(new String());
	}

	@Test
	public void getUsetByLastNameSoapUnitTest() throws SQLException {
		// userService.getUserByLastName(Mockito.anyString());
		userService.getUserByLastName(new String());

		verify(mockedUserDao).getUserByLastName(new String());

	}

	@Test
	public void updateUserSoapUnitTest() throws SQLException {
		User user = getRandomUserObject();
		userService.updateUser(user);

		verify(mockedUserDao).updateUser(user);
	}

	@Test
	public void deleteUserSoapUnitTest() throws SQLException {
		User user = getRandomUserObject();
		userService.deleteUser(user);

		verify(mockedUserDao).deleteUser(user);
	}
}
