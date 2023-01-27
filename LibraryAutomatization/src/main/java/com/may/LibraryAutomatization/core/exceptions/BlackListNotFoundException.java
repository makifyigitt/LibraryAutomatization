package com.may.LibraryAutomatization.core.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class BlackListNotFoundException extends RuntimeException{
    private ErrorCode errorCode;

    public BlackListNotFoundException(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getMessage() {
        return errorCode.getErrorMessage();
    }
}
