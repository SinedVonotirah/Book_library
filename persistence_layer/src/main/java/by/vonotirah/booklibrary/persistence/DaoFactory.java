package by.vonotirah.booklibrary.persistence;

public interface DaoFactory {

	BookDao getBookDao();

	UserDao getUserDao();
}
