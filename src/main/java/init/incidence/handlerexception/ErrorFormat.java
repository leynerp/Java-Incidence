package init.incidence.handlerexception;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorFormat {
    private final int status;
    private final String error;
    private final String message;
    public ErrorFormat(int status, String error, String message) {
        this.status = status;
        this.error = error;
        this.message = message;
    }
}
