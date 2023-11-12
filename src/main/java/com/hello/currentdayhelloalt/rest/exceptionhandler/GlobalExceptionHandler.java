package com.hello.currentdayhelloalt.rest.exceptionhandler;

import com.hello.currentdayhelloalt.service.exception.GreetingAndCurrentDayException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GreetingAndCurrentDayException.class)
    public ResponseEntity<String> handleGreetingAndCurrentDayException(){
        return ResponseEntity.internalServerError().body("Error getting greeting and current day");
    }
}
