package init.incidence.handlerexception;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
public class DuplicateDataException extends RuntimeException {
   public DuplicateDataException(String message){
      super(message);
    }

}
