package by.vonotirah.booklibrary.persistence.tests.unit.nosql;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.bson.Document;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.nosql.NoSqlBookDao;
import by.vonotirah.booklibrary.persistence.nosql.NoSqlConnectionFactory;
import by.vonotirah.booklibrary.persistence.tests.AbstractTest;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@RunWith(PowerMockRunner.class)
@PrepareForTest({ NoSqlBookDao.class })
public class NoSqlBookDaoUnitTest extends AbstractTest {

	private NoSqlConnectionFactory mockedConnectionFactory;
	private MongoClient mockedClient;
	private MongoDatabase mockedDataBase;
	private MongoCollection<Document> mockedCollection;
	private Document mockedDocument;

	@Before
	public void setUp() throws Exception {
		mockedConnectionFactory = mock(NoSqlConnectionFactory.class);
		mockedClient = mock(MongoClient.class);
		mockedDataBase = mock(MongoDatabase.class);
		mockedCollection = mock(MongoCollection.class);
		mockedDocument = mock(Document.class);

		when(mockedConnectionFactory.getClient()).thenReturn(mockedClient);
		when(mockedClient.getDatabase(anyString())).thenReturn(mockedDataBase);
		when(mockedDataBase.getCollection(anyString())).thenReturn(
				mockedCollection);

		PowerMockito.whenNew(Document.class).withNoArguments()
				.thenReturn(mockedDocument);

	}

	@Test
	public void constructorunitTest() throws Exception {
		new NoSqlBookDao(mockedConnectionFactory);
		verify(mockedConnectionFactory).getClient();
		verify(mockedClient).getDatabase(anyString());
		verify(mockedDataBase).getCollection(anyString());

	}

	@Test
	public void createBookUnitTest() throws Exception {
		NoSqlBookDao bookDao = new NoSqlBookDao(mockedConnectionFactory);
		Book book = getRandomBookObject();
		bookDao.createBook(book);

		verify(mockedDocument).append("name", book.getName());
		verify(mockedCollection).insertOne(mockedDocument);
	}

}
