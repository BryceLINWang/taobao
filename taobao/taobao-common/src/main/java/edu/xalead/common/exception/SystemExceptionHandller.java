package edu.xalead.common.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class SystemExceptionHandller {
    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<ResponseStatus> executeException(TBSystemException e){
        return ResponseEntity.status(e.getStatusCode()).body(new ResponseStatus(e.getStatusCode(),e.getMessage()));
    }
}
