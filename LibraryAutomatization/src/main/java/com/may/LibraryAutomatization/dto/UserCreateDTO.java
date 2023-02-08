package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.user.InfoType;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;



public class UserCreateDTO {


    @NotEmpty
    @Size(min = 4,max = 30)
    private String userName;
    @NotEmpty
    private String password;

    @NotEmpty
    private String name;
    @NotEmpty
    private String surname;
    private int status = 1;

    @Email
    private String email;
    private InfoType emailType;

    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$" ,
            message ="{Your phone number format does not meet the phone number requirements.}")
    private String phoneNumber;
    private InfoType phoneNumberType;

    private String address;
    private InfoType addressType;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public InfoType getEmailType() {
        return emailType;
    }

    public void setEmailType(InfoType emailType) {
        this.emailType = emailType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public InfoType getPhoneNumberType() {
        return phoneNumberType;
    }

    public void setPhoneNumberType(InfoType phoneNumberType) {
        this.phoneNumberType = phoneNumberType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public InfoType getAddressType() {
        return addressType;
    }

    public void setAddressType(InfoType addressType) {
        this.addressType = addressType;
    }
}
