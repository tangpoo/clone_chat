package com.study.chat.domain.common.exception;

public class CustomIncorrectPassword extends CustomRuntimeException {
    public CustomIncorrectPassword(){
        super(ExceptionCode.INCORRECT_PASSWORD.toString());
    }
}
