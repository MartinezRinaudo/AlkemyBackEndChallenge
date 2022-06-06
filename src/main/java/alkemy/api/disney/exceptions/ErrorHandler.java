package alkemy.api.disney.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErrorHandler {
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	@ResponseBody
	public ErrorMessage returnError(Exception e) {
		ErrorMessage resp = new ErrorMessage(500, "Internal server error.", e.getMessage());
		return resp;
	}
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(BadRequestException.class)
	@ResponseBody
	public ErrorMessage badRequest(BadRequestException e) {
		ErrorMessage resp = new ErrorMessage(e.getCode(), e.getMessage(), e.getField());
		return resp;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	@ResponseBody
	public ErrorMessage notFound(NotFoundException e) {
		ErrorMessage resp = new ErrorMessage(e.getCode(), e.getMessage(), null);
		return resp;
	}
}
