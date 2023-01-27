package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.core.exceptions.ReservationNotFoundException;
import com.may.LibraryAutomatization.dto.BookDTO;
import com.may.LibraryAutomatization.dto.ReservationDTO;
import com.may.LibraryAutomatization.model.Reservation;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ReservationService {
    private final ReservationRepository reservationRepository;
    private final UserService userService;
    private final BookService bookService;

    public ReservationService(ReservationRepository reservationRepository, UserService userService, BookService bookService) {
        this.reservationRepository = reservationRepository;
        this.userService = userService;
        this.bookService = bookService;
    }

    public List<ReservationDTO> getAllReservations(){
        return reservationRepository.findAll()
                .stream()
                .map(ReservationDTO::new)
                .collect(Collectors.toList());
    }

    public List<ReservationDTO> getAllActiveReservations(){
        return reservationRepository.getAllActiveReservations()
                .stream()
                .map(ReservationDTO::new)
                .collect(Collectors.toList());
    }
    protected Reservation findById(int id){
        return reservationRepository.findById(id)
                .orElseThrow(()-> new ReservationNotFoundException(ErrorCode.RESERVATION_NOT_FOUND_EXCEPTION));
    }

    public ReservationDTO getById(int id){
        return new ReservationDTO(findById(id));
    }

    public void createNewReservation(User user, Book book){  //içine user aldığı için exist mi diye kontrol etmeye gerek var mı
        Reservation newReservation = new Reservation(user,book);
        newReservation.setReservationDate(LocalDate.now());
        newReservation.setExpiryDate(newReservation.getReservationDate().plusDays(14));
        newReservation.setGiveBackStatus(false);
        reservationRepository.save(newReservation);

        bookService.updateBook(book.getId(),
                book.getTotalStock(),
                book.getAvailableStock()-1 );
    }

    public void terminateReservation(int id){
        Reservation inDB = findById(id);
        inDB.setGiveBackStatus(true);
        inDB.setGiveBackDate(LocalDate.now());
        reservationRepository.save(inDB);

        bookService.updateBook(inDB.getBook().getId(),
                inDB.getBook().getTotalStock(),
                inDB.getBook().getAvailableStock()+1);
    }

    public void extendReservationDate(int id){
        Reservation inDB = findById(id);
        inDB.setExpiryDate(inDB.getExpiryDate().plusDays(7));
        reservationRepository.save(inDB);
    }

    protected List<Reservation> findReservationsByUserId(int id){
        User user = userService.findUserById(id);
        return reservationRepository.findAllReservationsByUser(user)
                .orElseThrow(() -> new ReservationNotFoundException(ErrorCode.RESERVATION_NOT_FOUND_EXCEPTION));
    }

    public List<ReservationDTO> getReservationsByUserId(int id){
        return findReservationsByUserId(id)
                .stream()
                .map(ReservationDTO::new)
                .collect(Collectors.toList());
    }

}