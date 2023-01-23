package com.may.LibraryAutomatization.model.user;

public enum InfoTypeE {

    HOME(1,"home type"),
    BUSINIESS(2,"businiess type"),
    OTHERS(3,"others")
    ;

    private final int typeId;
    private final String typeDes;

    ErrorCode(int errorCode, String errorMessage) {
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
}
