package by.vonotirah.booklibrary.web_app.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import by.vonotirah.booklibrary.persistence.domain.User;
import by.vonotirah.booklibrary.web_app.UserWebService;
import by.vonotirah.booklibrary.web_app.services.AppContext;
import by.vonotirah.booklibrary.web_app.services.UserService;

@Component
@Path("/user")
public class UserRestService implements UserWebService {

	private UserService userService;

	public UserRestService() {
		super();
		userService = (UserService) AppContext.getInstance().getBean(AppContext.USER_SERVICE_KEY);
	}

	@Override
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public void createUser(User user) {
		userService.createUser(user);
	}

	@Override
	@GET
	@Path("/id/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserById(@PathParam("id") String id) {
		return userService.getUserById(id);
	}

	@Override
	@GET
	@Path("/lastname/{last_name}")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public User getUserByLastName(@PathParam("last_name") String lastName) {
		return userService.getUserByLastName(lastName);
	}

	@Override
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	public void updateUser(User user) {
		userService.updateUser(user);
	}

	@Override
	@DELETE
	@Consumes(MediaType.APPLICATION_JSON)
	public void deleteUser(User user) {
		userService.deleteUser(user);
	}

}
