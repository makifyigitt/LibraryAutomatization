package com.may.LibraryAutomatization.model.blacklist;

public enum BlackListType {
    late_hand_over(1,"due to late delivery"),
    damage_the_materials(2,"damaging the materials"),
    others(3,"others"),
    ;

    private final int typeId;
    private final String typeDescription;

    BlackListType(int typeId,String typeDescription) {
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
