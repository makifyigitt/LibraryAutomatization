package com.may.LibraryAutomatization.model.blacklist;

import com.may.LibraryAutomatization.model.user.User;
import jakarta.persistence.*;


import java.io.Serializable;
import java.time.LocalDate;


@Entity
@Table(name = "blacklist")
public class BlackList implements Serializable {

    public BlackList() {
    }

    public BlackList(User user) {
        this.user = user;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @Column(name = "date")
    private LocalDate date =LocalDate.now();

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

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
