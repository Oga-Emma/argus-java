package com.github.ogaemma.argus.exception;

public class ArgusException extends RuntimeException {

    public ArgusException(String message) {
        super(message);
    }

    public ArgusException(Throwable cause) {
        super(cause);
    }
}
