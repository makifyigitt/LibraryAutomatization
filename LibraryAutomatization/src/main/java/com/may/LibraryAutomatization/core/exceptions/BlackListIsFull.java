package com.may.LibraryAutomatization.core.exceptions;

import com.may.LibraryAutomatization.model.user.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
public class BlackListIsFull extends RuntimeException{
    private ErrorCode errorCode;
    private User user;

    public BlackListIsFull(ErrorCode errorCode, User user) {
        this.errorCode = errorCode;
        this.user = user;
    }

    @Override
    public String getMessage() {
        return errorCode.getErrorMessage() + "User id: " + user.getId();
    }
}
