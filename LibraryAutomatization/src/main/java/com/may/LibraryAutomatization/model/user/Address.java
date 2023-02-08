package com.may.LibraryAutomatization.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.Type;

import java.io.Serializable;

@Entity
@Table(name = "address")
public class Address implements Serializable {
    public Address() {
    }

    public Address(User user, InfoType infoType, String address) {
        this.user = user;
        this.infoType = infoType;
        this.address = address;
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
    @Column(name = "address")
    private String address;

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
