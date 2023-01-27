package com.may.LibraryAutomatization.controller;

import com.may.LibraryAutomatization.core.BaseResponse;
import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.core.exceptions.ReservationNotFoundException;
import com.may.LibraryAutomatization.dto.ReservationDTO;
import com.may.LibraryAutomatization.model.Reservation;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.service.ReservationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    private final ReservationService reservationService;


    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<ReservationDTO>> getAllReservations(){
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    @GetMapping("/getallactive")
    public ResponseEntity<List<ReservationDTO> >getAllActiveReservations(){
        return ResponseEntity.ok(reservationService.getAllActiveReservations());
    }


    @GetMapping("/{id}")
    public ResponseEntity<ReservationDTO> getById(@PathVariable("id") int id){
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @PostMapping("/create")
    public BaseResponse createNewReservation(@RequestBody User user, @RequestBody Book book){
        reservationService.createNewReservation(user,book);

        return new BaseResponse("Reservation created successfully");
    }

    @PatchMapping("/terminate")
    public ResponseEntity<ReservationDTO> terminateReservation(int id){
        reservationService.terminateReservation(id);
        return ResponseEntity.ok(reservationService.getById(id));
    }

    @PatchMapping("/extend")
    public BaseResponse extendReservationDate(int id){
        reservationService.extendReservationDate(id);
        return new BaseResponse("Expiry date extend successfully. New expiry date: "
                + reservationService.getById(id).getExpiryDate().toString());
    }

//    public List<ReservationDTO> getReservationsByUserId(int id){
//
//    }

}
