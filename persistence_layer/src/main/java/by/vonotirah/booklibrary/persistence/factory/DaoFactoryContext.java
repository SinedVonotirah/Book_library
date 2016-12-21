package by.vonotirah.booklibrary.persistence.factory;

import by.vonotirah.booklibrary.persistence.DaoFactory;

public class DaoFactoryContext {

	private static SqlDaoFactory sqlDaoFactory;
	private static NoSqlDaoFactory nosqlDaoFactory;

	private DaoFactoryContext() {

	}

	public static DaoFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SQL")) {
			if (sqlDaoFactory == null) {
				sqlDaoFactory = new SqlDaoFactory();
			}
			return sqlDaoFactory;
		} else if (choice.equalsIgnoreCase("NOSQL")) {
			if (nosqlDaoFactory == null) {
				nosqlDaoFactory = new NoSqlDaoFactory();
			}
			return nosqlDaoFactory;
		}
		return null;
	}
}
