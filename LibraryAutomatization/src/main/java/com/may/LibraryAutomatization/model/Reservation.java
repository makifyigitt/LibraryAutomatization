package com.may.LibraryAutomatization.model;

import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;


import java.io.Serializable;
import java.time.LocalDate;


@Entity

public class Reservation implements Serializable {

    public Reservation() {
    }

    public Reservation(User user, Book book) {
        this.user = user;
        this.book = book;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull
    @ManyToOne(cascade=CascadeType.ALL)
    @JoinColumn(name = "book_id")
    private Book book;

    @Column(name = "reservation_date")
    private LocalDate reservationDate = LocalDate.now();
    @Column(name = "expiry_date")
    private LocalDate expiryDate = LocalDate.now().plusDays(14);
    @Column(name = "give_back_status")
    private boolean giveBackStatus = false;
    @Column(name = "give_back_date")
    private LocalDate giveBackDate;

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

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public LocalDate getReservationDate() {
        return reservationDate;
    }

    public void setReservationDate(LocalDate reservationDate) {
        this.reservationDate = reservationDate;
    }

    public LocalDate getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(LocalDate expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isGiveBackStatus() {
        return giveBackStatus;
    }

    public void setGiveBackStatus(boolean giveBackStatus) {
        this.giveBackStatus = giveBackStatus;
    }

    public LocalDate getGiveBackDate() {
        return giveBackDate;
    }

    public void setGiveBackDate(LocalDate giveBackDate) {
        this.giveBackDate = giveBackDate;
    }
}
