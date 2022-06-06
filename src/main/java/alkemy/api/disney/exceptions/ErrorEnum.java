package alkemy.api.disney.exceptions;

public enum ErrorEnum {
	INVALIDUSER(404, "The user/s not found."),
	INVALIDCHARACTER(404, "The character/s not found."),
	INVALIDMOVIE(404, "The movie/s not found."),
	INVALIDGENDER(404, "The gender not found."),
	WRONGID(400, "You have entered an incorrect id."),
	WRONGORDER(400, "You have entered an incorrect id."),
	EXISTINGUSER(400, "This username already exists in the database."),
	EXISTINGCHARACTER(400, "This character already exists in the database."),
	EXISTINGMOVIE(400, "This movie already exists in the database."),
	EXISTINGGENDER(400, "This gender already exists in the database."),
	UNAUTHENTICATED(401, "Invalid username or password.");
	
	private int code;
	private String description;
	
	private ErrorEnum(int code, String description) {
		this.code = code;
		this.description = description;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	

	
}
