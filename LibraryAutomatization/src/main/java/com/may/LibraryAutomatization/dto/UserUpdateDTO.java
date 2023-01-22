package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.PhoneNumber;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserUpdateDTO {
    @NotNull
    private String name;
    @NotNull
    private String surname;
    @NotEmpty
    private Email email;
    @NotEmpty
    private PhoneNumber phoneNumber;
    @NotEmpty
    private Address address;


}
