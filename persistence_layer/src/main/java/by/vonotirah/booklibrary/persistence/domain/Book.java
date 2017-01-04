package by.vonotirah.booklibrary.persistence.domain;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Book {

	@NotNull(message = "Book 'id' field must be specified")
	private String id;

	@NotNull(message = "Book 'name' field must be specified")
	@Size(min = 2, max = 30, message = "Book 'name' field must be at least {min} characters, and less than {max} characters")
	private String name;

	private String userId;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
