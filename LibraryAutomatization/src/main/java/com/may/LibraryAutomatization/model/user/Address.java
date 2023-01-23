package com.may.LibraryAutomatization.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "address")
public class Address implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "info_type")
    private InfoType infoType;

    @NotNull
    @Column(name = "address")
    private String address;
}
