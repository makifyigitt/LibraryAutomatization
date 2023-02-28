package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.Reservation;


import java.time.LocalDate;


public class ReservationDTO {
    private int id;
    private int userID;
    private int bookID;
    private LocalDate reservationDate;
    private LocalDate expiryDate ;
    private boolean giveBackStatus ;
    private LocalDate giveBackDate;

    public ReservationDTO(Reservation reservation) {
        this.id = reservation.getId();
        this.userID = reservation.getUser().getId();
        this.bookID = reservation.getBook().getId();
        this.reservationDate = reservation.getReservationDate();
        this.expiryDate = reservation.getExpiryDate();
        this.giveBackStatus = reservation.isGiveBackStatus();
        this.giveBackDate = reservation.getGiveBackDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public int getBookID() {
        return bookID;
    }

    public void setBookID(int bookID) {
        this.bookID = bookID;
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
