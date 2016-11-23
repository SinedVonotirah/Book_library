package by.vonotirah.booklibrary.dao_layer.tests;

import org.apache.commons.lang3.RandomStringUtils;

import by.vonotirah.booklibrary.dao_layer.domain.Book;
import by.vonotirah.booklibrary.dao_layer.domain.User;

public abstract class AbstractTest {

	private static final int RANDOM_STRING_SIZE = 6;

	public AbstractTest() {
		super();
	}

	private static String randomString() {
		return RandomStringUtils.randomAlphabetic(RANDOM_STRING_SIZE);
	}

	public static String randomString(final String prefix) {
		return String.format("%s-%s", new Object[] { prefix, randomString() });
	}

	public Book getRandomBookObject() {
		Book book = new Book();
		book.setName(randomString("book_name"));
		return book;
	}

	public User getRandomUserObject() {
		User user = new User();
		user.setFirstname(randomString("first_name"));
		user.setLastName(randomString("last_name"));
		return user;
	}
}
