package main.java.com.javarun.web.exceptions;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Entity Already exists")
public class EntityAlreadyExistsException extends Exception{
    static final long serialVersionUID = 1L;
    public EntityAlreadyExistsException(String message){
        super(message);
    }
}
