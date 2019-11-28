package we.blog.web.api.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class AllInterexception {
    @ExceptionHandler(Exception.class)
    public String handleException(Exception e){
        return "false";
    }
    @ExceptionHandler(SearchException.class)
    public String SearchException(SearchException e){
        return null;
    }
}
