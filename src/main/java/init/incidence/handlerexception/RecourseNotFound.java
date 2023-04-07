package init.incidence.handlerexception;

public class RecourseNotFound extends RuntimeException{
    public RecourseNotFound(String message){
        super(message);
    }
}
