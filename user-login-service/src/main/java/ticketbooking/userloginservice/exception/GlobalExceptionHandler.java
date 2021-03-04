package ticketbooking.userloginservice.exception;

import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;



@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ResponseError> customerNotFoundException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	/*@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ResponseError> customerException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}
*/
	/*@ExceptionHandler(BankNotFoundException.class)
	public ResponseEntity<ResponseError> bankNotFoundException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	@ExceptionHandler(AccountExistException.class)
	public ResponseEntity<ResponseError> accountExistException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), ExceptionConstants.INVALID_CREDENTIAL_CODE);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}
	
*/

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseError> commonException(Exception e) {
		ResponseError error = new ResponseError(e.getMessage(), HttpStatus.UNAUTHORIZED.value());
		return new ResponseEntity<>(error, HttpStatus.UNAUTHORIZED);
	}

	@Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception,
			HttpHeaders headers,HttpStatus status, WebRequest request ){
		String allFieldErrors =exception.getBindingResult().getFieldErrors().stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(", "));
		ResponseError error = new ResponseError();
		error.setStatusCode(600);
		error.setMessage(allFieldErrors);
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}


}
