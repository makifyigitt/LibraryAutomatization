package com.may.LibraryAutomatization.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;

import java.util.List;


@Data
@Entity
@Table(name = "info_type")
public class InfoType implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "type")
    private String type;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "infoType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<Email> emails = new ArrayList<Email>();

    @OneToMany(mappedBy = "infoType",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();

    @OneToMany(mappedBy = "infoType", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<Address>();


}
