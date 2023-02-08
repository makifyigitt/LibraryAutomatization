package com.may.LibraryAutomatization.model.user;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;


import java.io.Serializable;

@Entity
@Table(name = "email")
public class Email implements Serializable {
    public Email() {
    }

    public Email(InfoType infoType,String email) {
        this.infoType = infoType;
        this.email = email;
    }

    public Email(User user, InfoType infoType, String email) {
        this.user = user;
        this.infoType = infoType;
        this.email = email;
    }

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @NotNull
    @Column(name = "info_type")
    @Enumerated(EnumType.ORDINAL)
    private InfoType infoType;

    @NotNull
    @Column(name = "email")
    @Pattern(regexp = "^[a-zA-Z0-9_.-]+@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.[a-zA-Z0-9]{2,6}$",message ="{Your email does not meet the email requirements.}")
    private String email;



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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
