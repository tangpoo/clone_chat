package com.study.chat.domain.common.exception;

public class CustomNoSuchElementException extends CustomRuntimeException {

    public CustomNoSuchElementException() {
        super(ExceptionCode.NO_SUCH_ELEMENT_EXCEPTION.toString());
    }
}
