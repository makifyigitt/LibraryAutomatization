package com.may.LibraryAutomatization.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;



import java.io.Serializable;

@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {

    public PhoneNumber() {
    }

    public PhoneNumber(User user, InfoType infoType, String phoneNumber) {
        this.user = user;
        this.infoType = infoType;
        this.phoneNumber = phoneNumber;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;


    @NotNull
    @Column(name = "info_type")
    @Enumerated(EnumType.ORDINAL)
    private InfoType infoType;

    @NotNull
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",message ="{Your phone number format does not meet the phone number requirements.}")
    @Column(name = "phone_number")
    private String phoneNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public InfoType getInfoType() {
        return infoType;
    }

    public void setInfoType(InfoType infoType) {
        this.infoType = infoType;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
