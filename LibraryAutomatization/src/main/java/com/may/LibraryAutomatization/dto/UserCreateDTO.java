package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.PhoneNumber;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserCreateDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    private int status = 1;
//    @NotNull
    private Email email;
//    @NotNull
    private PhoneNumber phoneNumber;
//    @NotNull
    private Address address;

}
