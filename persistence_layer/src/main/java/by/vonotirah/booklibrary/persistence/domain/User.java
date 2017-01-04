package by.vonotirah.booklibrary.persistence.domain;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {

	@NotNull(message = "User 'id' field must be specified")
	private String id;

	@NotNull(message = "User 'firstName' field must be specified")
	@Size(min = 2, max = 20, message = "User 'firstName' field must be at least {min} characters, and less than {max} characters")
	private String firstName;

	@NotNull(message = "User 'lastName' field must be specified")
	@Size(min = 2, max = 20, message = "User 'lastName' field must be at least {min} characters, and less than {max} characters")
	private String lastName;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
