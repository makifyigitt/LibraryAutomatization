package com.may.LibraryAutomatization.core.exceptions;

import lombok.Setter;

public enum ErrorCode {
    USER_NOT_FOUN_EXCEPTATION(1,"Kulanıcı bulunamadı"),
    BOOK_NOT_FOUN_EXCEPTATION(2,"BOOK bulunamadı"),
    ;

    private final int errorCode;
    private final String errorMessage;

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
