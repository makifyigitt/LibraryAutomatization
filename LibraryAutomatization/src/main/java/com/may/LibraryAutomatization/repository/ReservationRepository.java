package com.may.LibraryAutomatization.repository;

import com.may.LibraryAutomatization.model.Reservation;
import com.may.LibraryAutomatization.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation,Integer> {

    @Query("Select c From Reservation c where c.giveBackStatus = false")
    Optional<List<Reservation>> findAllActiveReservations();

    @Query("select c from Reservation c where c.user.id = :user ")
    Optional<List<Reservation>> findAllReservationsByUser(@Param("user")int userId);

    //TODO JOIN Lİ QUERY OLUŞTUR
}
