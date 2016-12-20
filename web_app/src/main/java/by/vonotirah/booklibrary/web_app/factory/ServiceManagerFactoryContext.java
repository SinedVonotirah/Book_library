package by.vonotirah.booklibrary.web_app.factory;

import by.vonotirah.booklibrary.web_app.ServiceManagerFactory;

public class ServiceManagerFactoryContext {

	private static ServiceManagerFactory soapServiceManagerFactory;
	private static ServiceManagerFactory restServiceManagerFactory;

	private ServiceManagerFactoryContext() {

	}

	public static ServiceManagerFactory getFactory(String choice) {
		if (choice.equalsIgnoreCase("SOAP")) {
			if (soapServiceManagerFactory == null) {
				soapServiceManagerFactory = new SoapServiceManagerFactory();
			}
			return soapServiceManagerFactory;
		} else if (choice.equalsIgnoreCase("REST")) {
			if (restServiceManagerFactory == null) {
				restServiceManagerFactory = new RestServiceManagerFactory();
			}
			return restServiceManagerFactory;
		}
		return null;
	}

}
