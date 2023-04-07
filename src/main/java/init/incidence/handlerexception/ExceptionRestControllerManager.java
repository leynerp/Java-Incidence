package init.incidence.handlerexception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

@RestControllerAdvice(annotations = RestController.class)
public class ExceptionRestControllerManager {
    @Autowired
    private MessageSource messageSource;
    private final Locale locate=Locale.getDefault();
    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<ErrorFormat> handleException(RuntimeException ex) {
        return new ResponseEntity(messageSource.getMessage("api.error.notfound", null, Locale.getDefault()), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BindException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ErrorFormat> handleException(BindException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            errors.put(fieldName,getMessage("api.error.notBlank"));
        });
        return new ResponseEntity<>(new ErrorFormat(HttpStatus.BAD_REQUEST.value(), ex.getMessage(), errors.toString()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({DataIntegrityViolationException.class})
    public ResponseEntity<ErrorFormat> handleExceptionIntegrity(DataIntegrityViolationException ex) {
        return new ResponseEntity(getError("api.error.integrityError", ex.getMessage(), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler
    public ResponseEntity<ErrorFormat> handleExceptionDuplicateData(DuplicateDataException ex) {
        return new ResponseEntity<>(getError(ex.getMessage(), getMessage("api.error.duplicated"), HttpStatus.BAD_REQUEST.value()), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ErrorFormat> handleExceptionRecourseNotFound(RecourseNotFound ex) {

        return new ResponseEntity<>(getError(ex.getMessage(),getMessage("api.error.notfound"), HttpStatus.NOT_FOUND.value()), HttpStatus.NOT_FOUND);
    }
    private ErrorFormat getError(String message, String error, int status) {
        return new ErrorFormat(status, error, getMessage(message));
    }

    private String getMessage(String message){
      return   messageSource.getMessage(message, null, locate);
    }

}
