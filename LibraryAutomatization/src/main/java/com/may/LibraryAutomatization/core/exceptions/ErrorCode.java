package com.may.LibraryAutomatization.core.exceptions;

import lombok.Setter;

public enum ErrorCode {
    USER_NOT_FOUND_EXCEPTION(1,"Kulanıcı bulunamadı"),
    BOOK_NOT_FOUND_EXCEPTION(2,"BOOK bulunamadı"),
    RESERVATION_NOT_FOUND_EXCEPTION(3,"Rezarvasyon bulunamadı"),
    BLACKLIST_NOT_FOUND_EXCEPTION(4,"BlackList bulunamadı")
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
