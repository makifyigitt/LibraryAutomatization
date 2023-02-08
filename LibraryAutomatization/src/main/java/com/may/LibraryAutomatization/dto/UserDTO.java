package com.may.LibraryAutomatization.dto;


import com.may.LibraryAutomatization.model.user.User;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;


public class UserDTO {
    private int id;
    private String name;
    private String surname;
    private int status;

    private List<EmailDTO> emailList;
    private List<AddressDTO> addressList;
    private List<PhoneNumberDTO> phoneNumberList;


    public UserDTO(User user){
        this.id = user.getId();
        this.name = user.getName();
        this.surname = user.getSurname();
        this.status = user.getStatus();
        this.emailList = user.getEmails()
                .stream()
                .map(EmailDTO::new)
                .collect(Collectors.toList());
        this.addressList = user.getAddresses()
                .stream()
                .map(AddressDTO::new)
                .collect(Collectors.toList());
        this.phoneNumberList = user.getPhoneNumbers()
                .stream()
                .map(PhoneNumberDTO::new)
                .collect(Collectors.toList());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public List<EmailDTO> getEmailList() {
        return emailList;
    }

    public void setEmailList(List<EmailDTO> emailList) {
        this.emailList = emailList;
    }

    public List<AddressDTO> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<AddressDTO> addressList) {
        this.addressList = addressList;
    }

    public List<PhoneNumberDTO> getPhoneNumberList() {
        return phoneNumberList;
    }

    public void setPhoneNumberList(List<PhoneNumberDTO> phoneNumberList) {
        this.phoneNumberList = phoneNumberList;
    }
}
