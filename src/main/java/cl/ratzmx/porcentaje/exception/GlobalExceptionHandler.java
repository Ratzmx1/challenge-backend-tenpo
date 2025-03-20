package cl.ratzmx.porcentaje.exception;

import cl.ratzmx.porcentaje.domain.dto.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> handleCustomException(CustomException ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(ex.getMessage().replaceAll("[\\n\\r\\t]", " ").trim());

        return ResponseEntity.status(ex.getStatus()).body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex) {
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setError(ex.getMessage().replaceAll("[\\n\\r\\t]", " ").trim());

        return ResponseEntity.internalServerError().body(errorResponse);
    }

}
