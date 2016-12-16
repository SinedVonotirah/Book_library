package by.vonotirah.booklibrary.web_app;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style = SOAPBinding.Style.RPC)
public interface DaoManagerWebService {

	@WebMethod
	void changeDb(String db);
}
