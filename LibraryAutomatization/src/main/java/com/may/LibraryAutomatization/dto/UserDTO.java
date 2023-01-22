package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.user.Address;
import com.may.LibraryAutomatization.model.user.Email;
import com.may.LibraryAutomatization.model.user.PhoneNumber;
import com.may.LibraryAutomatization.model.user.User;
import lombok.Data;

import java.util.List;

@Data
public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private int status;

    private List<Email> emailList;
    private List<Address> addressList;
    private List<PhoneNumber> phoneNumberList;


    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.status = user.getStatus();
        this.emailList = user.getEmails();
        this.addressList = user.getAddresses();
        this.phoneNumberList = user.getPhoneNumbers();
    }
}
