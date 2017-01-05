package by.vonotirah.booklibrary.web_app;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import by.vonotirah.booklibrary.web_app.rest.BookRestService;
import by.vonotirah.booklibrary.web_app.rest.RestServiceManager;
import by.vonotirah.booklibrary.web_app.rest.UserRestService;

@Component
@ApplicationPath("web_app/rest")
public class JerseyConfig extends ResourceConfig {
	public JerseyConfig() {
		registerEndpoints();
	}

	private void registerEndpoints() {
		register(BookRestService.class);
		register(UserRestService.class);
		register(RestServiceManager.class);
	}
}
