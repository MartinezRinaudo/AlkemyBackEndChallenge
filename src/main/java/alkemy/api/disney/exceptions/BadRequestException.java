package alkemy.api.disney.exceptions;

public class BadRequestException extends GenericException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String field;
	ErrorEnum error;
	
	public BadRequestException( String field, ErrorEnum error) {
		super(error.getDescription(), error.getCode());
		this.field = field;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}
	
	
	
}
