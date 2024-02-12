package main.java.com.javarun.web.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(value=HttpStatus.BAD_REQUEST, reason="Invalid Id provided for this Entity")
public class InvalidIdentifierException extends Exception {
    static final long serialVersionUID = 1L;
    public InvalidIdentifierException(String message){
        super(message);
    }
}
