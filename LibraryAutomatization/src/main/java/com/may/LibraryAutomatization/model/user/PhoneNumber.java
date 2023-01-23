package com.may.LibraryAutomatization.model.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
@Data
@Entity
@Table(name = "phone_number")
public class PhoneNumber implements Serializable {
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
    @Pattern(regexp = "^[\\+]?[(]?[0-9]{3}[)]?[-\\s\\.]?[0-9]{3}[-\\s\\.]?[0-9]{4,6}$",message ="{Your phone number format does not meet the phone number requirements.}")
    @Column(name = "phone_number")
    private String phoneNumber;
}
