package by.vonotirah.booklibrary.web_app.services.impl;

import java.util.List;

import by.vonotirah.booklibrary.persistence.factory.DaoFactoryContext;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.DbUtilService;
import by.vonotirah.booklibrary.web_app.services.DynamicDaoListener;

public class DbUtilServiceImpl implements DbUtilService {

	private AppContext context;

	public DbUtilServiceImpl(AppContext context, String defaulDaoType) {
		super();
		this.context = context;
		this.context.registrBean(AppContext.DAO_FACTORY_KEY, DaoFactoryContext.getFactory(defaulDaoType));
	}

	@Override
	public void changeDb(String newDbType) {
		this.context.registrBean(AppContext.DAO_FACTORY_KEY, DaoFactoryContext.getFactory(newDbType));
		updateServices();
	}

	private void updateServices() {
		List<Object> servicesList = context.getBeans(DynamicDaoListener.class);
		for (Object servise : servicesList) {
			((DynamicDaoListener) servise).onDaoChange();
		}
	}
}
