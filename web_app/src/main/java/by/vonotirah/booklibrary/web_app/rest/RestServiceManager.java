package by.vonotirah.booklibrary.web_app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;

import by.vonotirah.booklibrary.web_app.ServiceManager;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.DbUtilService;

@Path("/setup")
public class RestServiceManager implements ServiceManager {

	private DbUtilService dbUtilService;
	
	public RestServiceManager() {
		this.dbUtilService = (DbUtilService)AppContext.getInstance().getBean(AppContext.DB_UTILS_SERVICE);
	}
	
	@Override
	@PUT
	@Path("/book/{db}")
	@Consumes(MediaType.APPLICATION_JSON)
	public void changeDb(@PathParam("db") String db) {
		dbUtilService.changeDB(db);
	}

}
