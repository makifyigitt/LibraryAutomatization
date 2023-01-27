package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.Reservation;
import lombok.Data;

import java.time.LocalDate;

@Data
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
}
