package by.vonotirah.booklibrary.web_app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.vonotirah.booklibrary.web_app.services.impl.BookServiceImpl;
import by.vonotirah.booklibrary.web_app.services.impl.DbUtilServiceImpl;
import by.vonotirah.booklibrary.web_app.services.impl.UserServiceImpl;

public class AppContext {

	public static final String DAO_FACTORY_KEY = "daoFactory";
	public static final String BOOK_SERVICE_KEY = "bookService";
	public static final String USER_SERVICE_KEY = "userService";
	public static final String DB_UTILS_SERVICE = "dbUtilsService";

	private Map<String, Object> beans;
	private static AppContext instance;

	private AppContext() {
		super();
		beans = new HashMap<>();
		beans.put(DB_UTILS_SERVICE, new DbUtilServiceImpl(this, "SQL"));
		beans.put(BOOK_SERVICE_KEY, new BookServiceImpl(this));
		beans.put(USER_SERVICE_KEY, new UserServiceImpl(this));
	}

	public static AppContext getInstance() {
		if (instance == null) {
			instance = new AppContext();
		}
		return instance;
	}

	public Object getBean(String key) {
		return beans.get(key);
	}

	public void registrBean(String key, Object bean) {
		beans.put(key, bean);
	}

	public List<Object> getBeans(Class<?> clazz) {
		List<Object> result = new ArrayList<>();
		for (Object bean : beans.values()) {
			if (bean.getClass().equals(clazz)) {
				result.add(bean);
				continue;
			} else {
				if (clazz.isAssignableFrom(bean.getClass())) {
					result.add(bean);
					continue;
				}
			}
		}
		return result;
	}
}
