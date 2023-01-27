package com.may.LibraryAutomatization.model.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.may.LibraryAutomatization.model.Reservation;
import com.may.LibraryAutomatization.model.blacklist.BlackList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;



@Data
@Entity
@Table(name = "user", schema = "public")

public class User implements Serializable {
    public User() {
    }

    public User(int id,
                String name,
                String surname,
                int status,
                List<Email> emails,
                List<PhoneNumber> phoneNumbers,
                List<Address> addresses,
                List<Reservation> reservationList,
                List<BlackList> blackList) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
        this.reservationList = reservationList;
        this.blackList = blackList;
    }

    public User(String name,
                String surname,
                int status,
                List<Email> emails,
                List<PhoneNumber> phoneNumbers,
                List<Address> addresses,
                List<Reservation> reservationList,
                List<BlackList> blackList) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.emails = emails;
        this.phoneNumbers = phoneNumbers;
        this.addresses = addresses;
        this.reservationList = reservationList;
        this.blackList = blackList;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name")
    private String name;

    @NotNull
    @Column(name = "surname")
    private String surname;

    @NotNull
    @Column(name = "status")
    private int status = 1;


    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<Email>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<Address>();

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Reservation> reservationList = new ArrayList<Reservation>();

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BlackList> blackList = new ArrayList<BlackList>();
}
