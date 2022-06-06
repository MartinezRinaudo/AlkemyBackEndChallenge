package alkemy.api.disney.exceptions;

public class ErrorMessage {
	private int code;
	private String description;
	private String field;
	
	public ErrorMessage(int code, String description, String field) {
		super();
		this.code = code;
		this.description = description;
		this.field = field;
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

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
}
