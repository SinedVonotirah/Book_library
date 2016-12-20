package by.vonotirah.booklibrary.web_app.factory;

import by.vonotirah.booklibrary.web_app.ServiceManager;
import by.vonotirah.booklibrary.web_app.ServiceManagerFactory;

public class RestServiceManagerFactory implements ServiceManagerFactory {

	@Override
	public ServiceManager getServiceManager() {
		// TODO Auto-generated method stub
		return (ServiceManager) new RestServiceManagerFactory();
	}
}
