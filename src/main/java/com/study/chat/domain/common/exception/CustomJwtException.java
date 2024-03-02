package com.study.chat.domain.common.exception;

public class CustomJwtException extends RuntimeException {

    public CustomJwtException() {
        super();
    }

    public CustomJwtException(Throwable cause) {
        super(cause);
    }
}
