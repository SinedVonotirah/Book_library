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

import by.vonotirah.booklibrary.persistence.UserDao;
import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.UserWebService;

@Path("/user")
public class UserRestService implements UserWebService {

	private UserDao userDao;

	public UserRestService() {
		super();
		userDao = DaoManagerRestService.getUserDao();
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user) {
		try {
			userDao.createUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@GET
	@Path("/id/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") String id) {
		try {
			return userDao.getUserById(id);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@GET
	@Path("/lastname/{last_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByLastName(@PathParam("last_name") String lastName) {
		try {
			return userDao.getUserByLastName(lastName);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user) {
		try {
			userDao.updateUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(User user) {
		try {
			userDao.deleteUser(user);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
