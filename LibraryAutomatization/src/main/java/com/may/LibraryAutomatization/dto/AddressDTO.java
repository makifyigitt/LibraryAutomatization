package com.may.LibraryAutomatization.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.InfoType;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class AddressDTO {
    private int id;
    private int userId;
    private String address;
    private InfoType infoType;

    public AddressDTO(Address address) {
        this.id = address.getId();
        this.userId = address.getUser().getId();
        this.address = address.getAddress();
        this.infoType = address.getInfoType();
    }
}
