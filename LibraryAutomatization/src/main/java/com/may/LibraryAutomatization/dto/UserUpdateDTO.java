package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.user.InfoType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



public class UserUpdateDTO {

    public UserUpdateDTO() {
    }

    public UserUpdateDTO(int userId, String userName, String password, String name, String surname, String email, InfoType emailType, String phoneNumber, InfoType phoneNumberType, String address, InfoType addressType) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.emailType = emailType;
        this.phoneNumber = phoneNumber;
        this.phoneNumberType = phoneNumberType;
        this.address = address;
        this.addressType = addressType;
    }


    @NotNull
    private int userId;

    private String userName;
    @NotEmpty
    private String password;

    private String name;

    private String surname;

    @Email
    private String email;
    private InfoType emailType;

    @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$" ,
            message ="{Your phone number format does not meet the phone number requirements.}")
    private String phoneNumber;
    private InfoType phoneNumberType;
    private String address;
    private InfoType addressType;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

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
