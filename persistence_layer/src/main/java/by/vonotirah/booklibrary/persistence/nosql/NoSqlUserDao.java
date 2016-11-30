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

	public NoSqlUserDao(NoSqlConnectionFactory connectionFactory) {
		super();
		MongoDatabase dataBase = connectionFactory.getClient().getDatabase("booklibrary");
		collection = dataBase.getCollection("user");
	}

	public void createUser(User user) throws SQLException {
		Document userDoc = new Document();
		userDoc.append("first_name", user.getFirstName());
		userDoc.append("last_name", user.getLastName());
		collection.insertOne(userDoc);

	}

	public User getUserById(String id) throws SQLException {
		Document doc = collection.find(Filters.eq("_id", new ObjectId(id))).first();
		if (doc != null) {
			return parseUser(doc);
		}
		return null;
	}

	public User getUserByLastName(String lastName) throws SQLException {
		Document doc = collection.find(Filters.eq("last_name", lastName)).first();
		if (doc != null) {
			return parseUser(doc);
		}
		return null;
	}

	public void updateUser(User user) throws SQLException {
		Document userDoc = new Document();
		userDoc.append("first_name", user.getFirstName());
		userDoc.append("last_name", user.getLastName());
		collection.updateOne(Filters.eq("_id", new ObjectId(user.getId())), new Document("$set", userDoc));

	}

	public void deleteUser(User user) throws SQLException {
		collection.deleteOne(Filters.eq("_id", new ObjectId(user.getId())));

	}

	private User parseUser(Document doc) {
		User user = new User();
		user.setId(((ObjectId) doc.get("_id")).toHexString());
		user.setFirstName(doc.getString("first_name"));
		user.setLastName(doc.getString("last_name"));

		return user;
	}

}
