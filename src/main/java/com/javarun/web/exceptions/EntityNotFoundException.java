package main.java.com.javarun.web.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Entity does not exist in the databse")
public class EntityNotFoundException extends Exception{
    public EntityNotFoundException(String message){
        super(message);
    }
}
