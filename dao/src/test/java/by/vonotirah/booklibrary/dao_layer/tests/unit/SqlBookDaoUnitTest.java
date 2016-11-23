package by.vonotirah.booklibrary.dao_layer.tests.unit;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.vonotirah.booklibrary.dao_layer.dao.BookDao;
import by.vonotirah.booklibrary.dao_layer.dao_factory.ConnectionFactory;
import by.vonotirah.booklibrary.dao_layer.dao_factory.DaoFactory;
import by.vonotirah.booklibrary.dao_layer.domain.Book;
import by.vonotirah.booklibrary.dao_layer.tests.AbstractTest;

@RunWith(PowerMockRunner.class)
@PrepareForTest(ConnectionFactory.class)
public class SqlBookDaoUnitTest extends AbstractTest {

	private Connection mockedConnection;
	private PreparedStatement mockedPreparedStatement;

	@Before
	public void dependencies() throws Exception {
		mockedConnection = mock(Connection.class);
		mockedPreparedStatement = mock(PreparedStatement.class);

		PowerMockito.mockStatic(ConnectionFactory.class);

		when(ConnectionFactory.getConnection()).thenReturn(mockedConnection);

		System.out.println(mockedConnection.getClass());

		when(mockedConnection.prepareStatement("asd")).thenReturn(
				mockedPreparedStatement);
	}

	@Test
	public void createBookCallTest() throws SQLException {

		DaoFactory sqlDaoFactory = DaoFactory.getFactory("SQL");
		BookDao bookDao = sqlDaoFactory.getBookDao();

		Book book = getRandomBookObject();

		try {
			bookDao.createBook(book);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// verify(mockedConnection).prepareStatement(anyString());
		verify(mockedPreparedStatement).setString(1, book.getName());
		verify(mockedPreparedStatement).executeUpdate();

	}
}
