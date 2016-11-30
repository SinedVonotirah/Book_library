package by.vonotirah.booklibrary.persistence.tests.unit;

import static org.mockito.Mockito.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.factory.FactoryContext;
import by.vonotirah.booklibrary.persistence.sql.ConnectionFactory;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

public class SqlBookDaoUnitTest extends AbstractTest {

	private ConnectionFactory mockedConnectionFactory;
	private Connection mockedConnection;
	private PreparedStatement mockedPreparedStatement;

	@Before
	public void dependencies() throws Exception {
		mockedConnectionFactory = mock(ConnectionFactory.class);
		mockedConnection = mock(Connection.class);
		mockedPreparedStatement = mock(PreparedStatement.class);

		when(mockedConnectionFactory.getConnection()).thenReturn(
				mockedConnection);
		when(mockedConnection.prepareStatement(anyString())).thenReturn(
				mockedPreparedStatement);
	}

	@Test
	public void createBookCallTest() throws SQLException {

		BookDao bookDao = FactoryContext.getFactory("sql").getBookDao();

		verify(mockedConnectionFactory).getConnection();
	}
}
