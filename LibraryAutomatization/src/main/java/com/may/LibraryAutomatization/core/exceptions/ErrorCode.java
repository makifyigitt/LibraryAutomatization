package com.may.LibraryAutomatization.core.exceptions;



public enum ErrorCode {
    USER_NOT_FOUND_EXCEPTION(1,"Kulanıcı bulunamadı"),
    BOOK_NOT_FOUND_EXCEPTION(2,"BOOK bulunamadı"),
    RESERVATION_NOT_FOUND_EXCEPTION(3,"Rezarvasyon bulunamadı"),
    AUTHOR_NOT_FOUND_EXCEPTION(4,"Yazar bulunamadı, lütfen yazarı ekleyin"),
    BLACKLIST_IS_FULL(5,"Kullanıcı black List sınırını aştığı için banlanmıştır")
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
