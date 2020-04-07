package edu.xalead.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SystemExceptionHandller {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ResponseStatus> executeException(TBSystemException e){
        ResponseStatus status=new ResponseStatus(500,e.getMessage());
        return ResponseEntity.status(status.getCode()).body(status);
    }
}
