package by.vonotirah.booklibrary.persistence.nosql;

import java.sql.SQLException;

import org.bson.Document;
import org.bson.types.ObjectId;

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class NoSqlUserDao implements UserDao {

	private MongoCollection<Document> collection;

	private static final String USER_ID_FIELD = "_id";
	private static final String USER_FIRST_NAME_FIELD = "first_name";
	private static final String USER_LAST_NAME_FIELD = "last_name";

	public NoSqlUserDao(NoSqlConnectionFactory connectionFactory) {
		super();
		MongoDatabase dataBase = connectionFactory.getClient().getDatabase(
				"booklibrary");
		collection = dataBase.getCollection("user");
	}

	public void createUser(User user) throws SQLException {
		Document userDoc = new Document();
		userDoc.append(USER_FIRST_NAME_FIELD, user.getFirstName());
		userDoc.append(USER_LAST_NAME_FIELD, user.getLastName());
		collection.insertOne(userDoc);

	}

	public User getUserById(String id) throws SQLException {
		Document doc = collection.find(
				Filters.eq(USER_ID_FIELD, new ObjectId(id))).first();
		if (doc != null) {
			return parseUser(doc);
		}
		return null;
	}

	public User getUserByLastName(String lastName) throws SQLException {
		Document doc = collection.find(
				Filters.eq(USER_LAST_NAME_FIELD, lastName)).first();
		if (doc != null) {
			return parseUser(doc);
		}
		return null;
	}

	public void updateUser(User user) throws SQLException {
		Document userDoc = new Document();
		userDoc.append(USER_FIRST_NAME_FIELD, user.getFirstName());
		userDoc.append(USER_LAST_NAME_FIELD, user.getLastName());
		collection.updateOne(
				Filters.eq(USER_ID_FIELD, new ObjectId(user.getId())),
				new Document("$set", userDoc));

	}

	public void deleteUser(User user) throws SQLException {
		collection.deleteOne(Filters.eq(USER_ID_FIELD,
				new ObjectId(user.getId())));

	}

	private User parseUser(Document doc) {
		User user = new User();
		user.setId(((ObjectId) doc.get(USER_ID_FIELD)).toHexString());
		user.setFirstName(doc.getString(USER_FIRST_NAME_FIELD));
		user.setLastName(doc.getString(USER_LAST_NAME_FIELD));

		return user;
	}

}
