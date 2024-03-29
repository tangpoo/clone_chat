package com.study.chat.domain.common.exception;

public class CustomNotAllowAccess extends CustomRuntimeException {
    public CustomNotAllowAccess(){
        super(ExceptionCode.NOT_ALLOW_ACCESS.toString());
    }
}
