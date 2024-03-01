package clustered.data.warehouse.exceptions.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.stream.Collectors;

/**
 * GlobalExceptionHandler is a global exception handler for the application.
 * It handles exceptions thrown by the application and returns appropriate HTTP responses.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * Handles validation exceptions.
     *
     * @param ex The MethodArgumentNotValidException thrown by the application.
     * @return A ResponseEntity containing the error message and a 400 Bad Request status.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> handleValidationExceptions(MethodArgumentNotValidException ex) {
        String errorMessage = ex.getBindingResult().getFieldErrors().stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.joining(", "));
        logger.error("Validation error: {}", errorMessage);
        return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);
    }

    /**
     * Handles duplicate FxDeal exceptions.
     *
     * @param ex The DuplicateFxDealException thrown by the application.
     * @return A ResponseEntity containing the error message and a 409 Conflict status.
     */
    @ExceptionHandler(DuplicateFxDealException.class)
    public ResponseEntity<String> handleDuplicateFxDealException(DuplicateFxDealException ex) {
        logger.error("Duplicate FxDeal error: {}", ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }
}
