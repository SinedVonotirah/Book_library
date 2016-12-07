package by.vonotirah.booklibrary.persistence.nosql;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import by.vonotirah.booklibrary.persistence.BookDao;
import by.vonotirah.booklibrary.persistence.domain.Book;
import by.vonotirah.booklibrary.persistence.domain.User;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class NoSqlBookDao implements BookDao {

	private MongoCollection<Document> collection;

	private static final String BOOK_ID_FIELD = "_id";
	private static final String BOOK_NAME_FIELD = "name";
	private static final String BOOK_USER_ID_FIELD = "user_id";

	public NoSqlBookDao(NoSqlConnectionFactory connectionFactory) {
		super();
		MongoDatabase dataBase = connectionFactory.getClient().getDatabase(
				"booklibrary");
		collection = dataBase.getCollection("book");
	}

	public void createBook(Book book) throws SQLException {
		Document bookDoc = new Document();
		bookDoc.append(BOOK_NAME_FIELD, book.getName());
		collection.insertOne(bookDoc);
	}

	public void updateBook(Book book) throws SQLException {
		collection.updateOne(Filters.eq(BOOK_ID_FIELD,
				new ObjectId(book.getId())), new Document("$set", new Document(
				BOOK_NAME_FIELD, book.getName())));
	}

	public void assignBook(Book book, User user) throws SQLException {
		collection.updateOne(Filters.eq(BOOK_ID_FIELD,
				new ObjectId(book.getId())), new Document("$set", new Document(
				BOOK_USER_ID_FIELD, user.getId())));
	}

	public Book getBookById(String id) throws SQLException {
		Document doc = collection.find(
				Filters.eq(BOOK_ID_FIELD, new ObjectId(id))).first();
		if (doc != null) {
			return parseBook(doc);
		}
		return null;
	}

	public Book getBookByName(String name) throws SQLException {
		Document doc = collection.find(Filters.eq(BOOK_NAME_FIELD, name))
				.first();
		if (doc != null) {
			return parseBook(doc);
		}
		return null;
	}

	public void passBook(Book book) throws SQLException {
		collection.updateOne(
				Filters.eq(BOOK_ID_FIELD, new ObjectId(book.getId())),
				new Document("$unset", new Document(BOOK_USER_ID_FIELD, "")));

	}

	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		List<Document> docs = collection.find().into(new ArrayList<Document>());
		for (Document doc : docs) {
			books.add(parseBook(doc));
		}
		return books;
	}

	public List<Book> getAllFreeBooks() throws SQLException {
		List<Book> books = new ArrayList<Book>();
		List<Document> docs = collection.find(
				Filters.exists(BOOK_ID_FIELD, false)).into(
				new ArrayList<Document>());
		for (Document doc : docs) {
			books.add(parseBook(doc));
		}
		return books;
	}

	public void deleteBook(Book book) throws SQLException {
		collection.deleteOne(Filters.eq(BOOK_ID_FIELD,
				new ObjectId(book.getId())));
	}

	private Book parseBook(Document doc) {
		Book book = new Book();
		book.setId(((ObjectId) doc.get(BOOK_ID_FIELD)).toHexString());
		book.setName(doc.getString(BOOK_NAME_FIELD));
		book.setUserId(doc.getString(BOOK_USER_ID_FIELD));
		return book;
	}

}
