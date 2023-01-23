package com.may.LibraryAutomatization.dto;


import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.InfoType;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class EmailDTO {

    private int id;
    private int userId;
    private String email;
    private InfoType infoType;

    public EmailDTO(Email email) {
        this.id = email.getId();
        this.userId = email.getUser().getId();
        this.email = email.getEmail();
        this.infoType = email.getInfoType();
    }
}
