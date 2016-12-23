package by.vonotirah.booklibrary.web_app.services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import by.vonotirah.booklibrary.web_app.services.impl.BookServiceImpl;
import by.vonotirah.booklibrary.web_app.services.impl.DbUtilServiceImpl;
import by.vonotirah.booklibrary.web_app.services.impl.UserServiceImpl;

/*
 * Simple bean holder - one place where we create bean and then we can use bean at any point of the app  
*/
public class AppContext {

	public static final String DAO_FACTORY_KEY = "daoFactory";
	public static final String BOOK_SERVICE_KEY = "bookService";
	public static final String USER_SERVICE_KEY = "userService";
	public static final String DB_UTILS_SERVICE = "dbUtilsService";
	
	private Map<String, Object> beans;
	private static AppContext instance;
	
	private AppContext(){
		beans = new HashMap<>();
		beans.put(DB_UTILS_SERVICE, new DbUtilServiceImpl(this, "SQL"));
		beans.put(USER_SERVICE_KEY, new UserServiceImpl(this));
		beans.put(BOOK_SERVICE_KEY, new BookServiceImpl(this));
	}
	
	public static AppContext getInstance(){
		if (instance == null){
			instance = new AppContext();
		}
		return instance;
	}
	
	public void registerBean(String name, Object bean){
		beans.put(name, bean);
	}

	public Object getBean(String name){
		return beans.get(name);
	}

	public List<Object> getBeans(Class<?> clazz){
		List<Object> result = new ArrayList<>();
		for (Object bean : beans.values()) {
			if (bean.getClass().equals(clazz)){
				result.add(bean);
				continue;
			}else{
				if (clazz.isAssignableFrom(bean.getClass())) {
				   result.add(bean);
				   continue;
				}
			}
		}
		return result;
	}

}
