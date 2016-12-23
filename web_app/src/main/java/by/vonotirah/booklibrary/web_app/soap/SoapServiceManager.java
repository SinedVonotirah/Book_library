package by.vonotirah.booklibrary.web_app.soap;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

import by.vonotirah.booklibrary.web_app.ServiceManager;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.DbUtilService;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public class SoapServiceManager implements ServiceManager {

	private DbUtilService dbUtilService;
	
	public SoapServiceManager() {
		this.dbUtilService = (DbUtilService)AppContext.getInstance().getBean(AppContext.DB_UTILS_SERVICE);
	}

	@Override
	@WebMethod
	public void changeDb(String db) {
		dbUtilService.changeDB(db);
	}

}
