package by.vonotirah.booklibrary.persistence.nosql;

import com.mongodb.MongoClient;

public enum ConnectionFactory {

	CONNECTION;

	private MongoClient client = null;

	private ConnectionFactory() {

		client = new MongoClient("localhost", 27017);

	}

	public MongoClient getClient() {
		if (client == null)
			throw new RuntimeException();
		return client;
	}
}
