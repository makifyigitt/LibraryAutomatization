package com.may.LibraryAutomatization.model.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.may.LibraryAutomatization.model.Reservation;
import com.may.LibraryAutomatization.model.blacklist.BlackList;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Size;


import java.util.*;




@Entity
@Table(name = "user", schema = "public")

public class User  { //implements UserDetails
    public User() {
        emails = new ArrayList<>();
        phoneNumbers = new ArrayList<>();
        addresses = new ArrayList<>();
        blackList = new ArrayList<>();
        reservationList = new ArrayList<>();
    }

    public User(String username, String password, String name, String surname) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.surname = surname;
        emails = new ArrayList<>();
        phoneNumbers = new ArrayList<>();
        addresses = new ArrayList<>();
        blackList = new ArrayList<>();
        reservationList = new ArrayList<>();

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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Size(min = 4,max = 30)
    @Column(name = "username",unique = true)
    private String username;

    @NotNull
    @Size(min = 8,max = 30)
    @Column(name = "password")
    private String password;

    @Enumerated(EnumType.ORDINAL)
    private UserRole userRole;

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

    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
    private List<BlackList> blackList = new ArrayList<BlackList>();

//    @JsonIgnore
//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority(userRole.name()));
//    }
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    @JsonIgnore
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserRole getUserRole() {
        return userRole;
    }

    public void setUserRole(UserRole userRole) {
        this.userRole = userRole;
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

    public List<Email> getEmails() {
        return emails;
    }

    public void setEmails(List<Email> emails) {
        this.emails = emails;
    }

    public List<PhoneNumber> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<PhoneNumber> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public List<BlackList> getBlackList() {
        return blackList;
    }

    public void setBlackList(List<BlackList> blackList) {
        this.blackList = blackList;
    }
}
