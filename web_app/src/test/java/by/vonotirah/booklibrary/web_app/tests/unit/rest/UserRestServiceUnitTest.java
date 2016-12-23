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

import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.UserWebService;
import by.vonotirah.booklibrary.web_app.rest.RestServiceManager;
import by.vonotirah.booklibrary.web_app.rest.UserRestService;
import by.vonotirah.booklibrary.web_app.services.UserService;
import by.vonotirah.booklibrary.web_app.tests.AbstractTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(RestServiceManager.class)
public class UserRestServiceUnitTest extends AbstractTest {

	private UserService mockedUserService;

/*	@Before
	public void setUp() {
		PowerMockito.mockStatic(RestServiceManager.class);
		mockedUserService = Mockito.mock(UserService.class);
		PowerMockito.when(RestServiceManager.getUserService()).thenReturn(mockedUserService);
	}
*/
	@Test
	public void createUserSoapUnitTest() throws SQLException {
		UserWebService userService = new UserRestService();
		User user = getRandomUserObject();
		userService.createUser(user);

		verify(mockedUserService).createUser(user);
	}

	@Test
	public void getUserByIdSoapUnitTest() throws SQLException {
		UserWebService userService = new UserRestService();
		// userService.getUserById(Mockito.anyString());
		userService.getUserById(new String());

		verify(mockedUserService).getUserById(new String());
	}

	@Test
	public void getUsetByLastNameSoapUnitTest() throws SQLException {
		UserWebService userService = new UserRestService();
		// userService.getUserByLastName(Mockito.anyString());
		userService.getUserByLastName(new String());

		verify(mockedUserService).getUserByLastName(new String());

	}

	@Test
	public void updateUserSoapUnitTest() throws SQLException {
		UserWebService userService = new UserRestService();
		User user = getRandomUserObject();
		userService.updateUser(user);

		verify(mockedUserService).updateUser(user);
	}

	@Test
	public void deleteUserSoapUnitTest() throws SQLException {
		UserWebService userService = new UserRestService();
		User user = getRandomUserObject();
		userService.deleteUser(user);

		verify(mockedUserService).deleteUser(user);
	}
}
