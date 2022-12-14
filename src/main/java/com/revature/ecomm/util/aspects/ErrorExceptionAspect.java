package com.revature.ecomm.util.aspects;

import com.revature.ecomm.exceptions.AuthenticationException;
import com.revature.ecomm.exceptions.InvalidRequestException;
import com.revature.ecomm.exceptions.ResourcePersistanceException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.io.IOException;

@RestControllerAdvice
public class ErrorExceptionAspect {
    @ExceptionHandler({InvalidRequestException.class, IOException.class})
    public ResponseEntity<String> handleException(Exception e){
        String message = "Caught invalid request with" + e.getMessage();
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler({AuthenticationException.class})
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public void handleNewException(Exception e){
        String message = "caught new exception" + e.getMessage();
        System.out.println(message);
    }
    @ExceptionHandler(ResourcePersistanceException.class)
    public ResponseEntity<String> resourceException(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<String> exception(Exception e){
        return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
    }

}
