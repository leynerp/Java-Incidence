package init.incidence.handlerexception;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
public class CustomError implements ErrorController {
    @Autowired
    private MessageSource messageSource;
    @RequestMapping("/error")
    public ResponseEntity handleError( ) {
        return  new ResponseEntity(messageSource.getMessage("api.error.notfound",null, Locale.getDefault()), HttpStatus.NOT_FOUND);
    }
}
