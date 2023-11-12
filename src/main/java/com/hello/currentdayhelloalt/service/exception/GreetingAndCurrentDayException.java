package com.hello.currentdayhelloalt.service.exception;

import java.io.Serial;

public class GreetingAndCurrentDayException extends RuntimeException{

    @Serial
    private static final long serialVersionUID = 1L;

    public GreetingAndCurrentDayException(String message) {
        super(message);
    }
}
