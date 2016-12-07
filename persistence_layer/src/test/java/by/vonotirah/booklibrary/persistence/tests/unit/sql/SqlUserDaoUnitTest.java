package by.vonotirah.booklibrary.persistence.tests.unit.sql;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Before;
import org.junit.Test;

import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.persistence.sql.SqlConnectionFactory;
import by.vonotirah.booklibrary.persistence.sql.SqlUserDao;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class SqlUserDaoUnitTest extends AbstractTest {

	private SqlConnectionFactory mockedConnectionFactory;
	private Connection mockedConnection;
	private PreparedStatement mockedPreparedStatement;
	private Statement mockedStatement;
	private ResultSet mockedResultSet;

	@Before
	public void dependencies() throws Exception {
		mockedConnectionFactory = mock(SqlConnectionFactory.class);
		mockedConnection = mock(Connection.class);
		mockedPreparedStatement = mock(PreparedStatement.class);
		mockedStatement = mock(Statement.class);
		mockedResultSet = mock(ResultSet.class);

		when(mockedConnectionFactory.getConnection()).thenReturn(mockedConnection);
		when(mockedConnection.prepareStatement(anyString())).thenReturn(mockedPreparedStatement);
		when(mockedConnection.createStatement()).thenReturn(mockedStatement);
		when(mockedStatement.executeQuery(anyString())).thenReturn(mockedResultSet);
		when(mockedPreparedStatement.executeQuery()).thenReturn(mockedResultSet);
	}

	@Test
	public void createUserUnitTest() throws Exception {
		SqlUserDao userDao = new SqlUserDao(mockedConnectionFactory);
		User user = getRandomUserObject();
		userDao.createUser(user);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, user.getFirstName());
		verify(mockedPreparedStatement).setString(2, user.getLastName());
		verify(mockedPreparedStatement).executeUpdate();
	}

	@Test
	public void getUserByIdUnitTest() throws Exception {
		SqlUserDao userDao = new SqlUserDao(mockedConnectionFactory);
		userDao.getUserById("1");
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setInt(1, Integer.parseInt("1"));
		verify(mockedPreparedStatement).executeQuery();
	}

	@Test
	public void getUserByLastNameUnitTest() throws Exception {
		SqlUserDao userDao = new SqlUserDao(mockedConnectionFactory);
		userDao.getUserByLastName("1");
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, "1");
		verify(mockedPreparedStatement).executeQuery();
	}

	@Test
	public void updateUserUnitTest() throws Exception {
		SqlUserDao userDao = new SqlUserDao(mockedConnectionFactory);
		User user = getRandomUserObject();
		user.setId("1");
		userDao.updateUser(user);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, user.getFirstName());
		verify(mockedPreparedStatement).setString(2, user.getLastName());
		verify(mockedPreparedStatement).setInt(3, Integer.parseInt(user.getId()));
		verify(mockedPreparedStatement).executeUpdate();
	}

	@Test
	public void deleteUserUnitTest() throws Exception {
		SqlUserDao userDao = new SqlUserDao(mockedConnectionFactory);
		User user = getRandomUserObject();
		user.setId("1");
		userDao.deleteUser(user);
		verify(mockedConnectionFactory).getConnection();
		verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setInt(1, Integer.parseInt(user.getId()));
		verify(mockedPreparedStatement).executeUpdate();
	}

}
