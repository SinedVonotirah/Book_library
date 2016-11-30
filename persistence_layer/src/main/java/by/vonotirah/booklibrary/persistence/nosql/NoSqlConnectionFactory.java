package by.vonotirah.booklibrary.persistence.nosql;

import com.mongodb.MongoClient;

public class NoSqlConnectionFactory {

	private MongoClient client;

	public NoSqlConnectionFactory() {
		client = new MongoClient("localhost", 27017);
	}

	public MongoClient getClient() {
		if (client == null)
			throw new RuntimeException();
		return client;
	}

}
