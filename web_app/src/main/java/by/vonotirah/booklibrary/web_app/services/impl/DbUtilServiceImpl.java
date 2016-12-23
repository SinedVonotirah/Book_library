package by.vonotirah.booklibrary.web_app.services.impl;

import by.vonotirah.booklibrary.persistence.factory.DaoFactoryContext;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.DbUtilService;

public class DbUtilServiceImpl implements DbUtilService {

	
	private AppContext context;
	
	public DbUtilServiceImpl(AppContext context, String defaultDaoType) {
		this.context = context;
		//Put default DAO Factory into context
		this.context.registerBean(AppContext.DAO_FACTORY_KEY, DaoFactoryContext.getFactory(defaultDaoType));
	}
	
	@Override
	public void changeDB(String newDbType) {
		this.context.registerBean(AppContext.DAO_FACTORY_KEY, DaoFactoryContext.getFactory(newDbType));
	}


}
