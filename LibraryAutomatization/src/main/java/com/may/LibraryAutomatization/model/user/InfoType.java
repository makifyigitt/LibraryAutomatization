package com.may.LibraryAutomatization.model.user;

import jakarta.persistence.Entity;


public enum InfoType {

    home(1,"Home type"),
    bussines(2,"Business type"),
    others(3,"Others types"),
    ;

    private final int typeId;
    private final String typeDescription;

    InfoType(int typeId,String typeDescription) {
        this.typeId = typeId;
        this.typeDescription = typeDescription;
    }

    public int getTypeId() {
        return typeId;
    }

    public String getTypeDescription() {
        return typeDescription;
    }
}
