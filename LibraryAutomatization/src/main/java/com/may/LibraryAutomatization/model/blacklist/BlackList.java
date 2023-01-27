package com.may.LibraryAutomatization.model.blacklist;

import com.may.LibraryAutomatization.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Entity
@Table(name = "blacklist")
public class BlackList implements Serializable {

    public BlackList() {
    }

    public BlackList(User user, BlackListType blackListType) {
        this.user = user;
        this.blackListType = blackListType;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @Column(name = "black_list_type")
    @Enumerated(EnumType.STRING)
    private BlackListType blackListType;

    @Column(name = "date")
    private LocalDate date;



}
