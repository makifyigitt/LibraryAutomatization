package com.may.LibraryAutomatization.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.may.LibraryAutomatization.model.user.InfoType;
import com.may.LibraryAutomatization.model.user.PhoneNumber;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PhoneNumberDTO {
    private int id;
    private int userId;
    private String phoneNumber;
    private InfoType infoType;

    public PhoneNumberDTO(PhoneNumber phoneNumber) {
        this.id = phoneNumber.getId();
        this.userId = phoneNumber.getUser().getId();
        this.phoneNumber = phoneNumber.getPhoneNumber();
        this.infoType = phoneNumber.getInfoType();
    }
}
