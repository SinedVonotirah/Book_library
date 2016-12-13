package by.vonotirah.booklibrary.web_app.rest;

import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.DaoManagerWebService;
import by.vonotirah.booklibrary.web_app.UserWebService;
import by.vonotirah.booklibrary.web_app.soap.DaoManagerSoapService;

@Path("/user")
public class UserRestService implements UserWebService {

	private DaoManagerWebService daoManager;

	public UserRestService() {
		super();
		daoManager = new DaoManagerSoapService();
	}

	@Override
	@POST
	@Path("/create")
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user) {
		try {
			daoManager.getUserDao().createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@GET
	@Path("/getbyid/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") String id) {
		try {
			return daoManager.getUserDao().getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GET
	@Path("/getbylastname/{last_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByLastName(@PathParam("last_name") String lastName) {
		try {
			return daoManager.getUserDao().getUserByLastName(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PUT
	@Path("/update")
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user) {
		try {
			daoManager.getUserDao().updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@DELETE
	@Path("/delete")
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(User user) {
		try {
			daoManager.getUserDao().deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
