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

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.UserWebService;
import by.vonotirah.booklibrary.web_app.soap.DaoManagerSoapService;
import by.vonotirah.booklibrary.web_app.soap.UserSoapService;
import by.vonotirah.booklibrary.web_app.tests.AbstractTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DaoManagerSoapService.class)
public class UserSoapServiceUnitTest extends AbstractTest {

	private UserDao mockedUserDao;

	@Before
	public void setUp() {
		PowerMockito.mockStatic(DaoManagerSoapService.class);
		mockedUserDao = Mockito.mock(UserDao.class);
		PowerMockito.when(DaoManagerSoapService.getUserDao()).thenReturn(mockedUserDao);
	}

	@Test
	public void createUserSoapUnitTest() throws SQLException {
		UserWebService userService = new UserSoapService();
		User user = getRandomUserObject();
		userService.createUser(user);

		verify(mockedUserDao).createUser(user);
	}

	@Test
	public void getUserByIdSoapUnitTest() throws SQLException {
		UserWebService userService = new UserSoapService();
		// userService.getUserById(Mockito.anyString());
		userService.getUserById(new String());

		verify(mockedUserDao).getUserById(new String());
	}

	@Test
	public void getUsetByLastNameSoapUnitTest() throws SQLException {
		UserWebService userService = new UserSoapService();
		// userService.getUserByLastName(Mockito.anyString());
		userService.getUserByLastName(new String());

		verify(mockedUserDao).getUserByLastName(new String());

	}

	@Test
	public void updateUserSoapUnitTest() throws SQLException {
		UserWebService userService = new UserSoapService();
		User user = getRandomUserObject();
		userService.updateUser(user);

		verify(mockedUserDao).updateUser(user);
	}

	@Test
	public void deleteUserSoapUnitTest() throws SQLException {
		UserWebService userService = new UserSoapService();
		User user = getRandomUserObject();
		userService.deleteUser(user);

		verify(mockedUserDao).deleteUser(user);
	}
}
