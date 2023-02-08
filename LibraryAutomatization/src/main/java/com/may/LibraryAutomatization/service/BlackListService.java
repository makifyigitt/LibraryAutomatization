package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.BlackListIsFull;
import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.model.Reservation;
import com.may.LibraryAutomatization.model.blacklist.BlackList;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.repository.BlackListRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@EnableScheduling
@Service
public class BlackListService {

    private final UserService userService;
    private final ReservationService reservationService;
    private final BlackListRepository blackListRepository;

    public BlackListService(UserService userService, ReservationService reservationService,
                            BlackListRepository blackListRepository) {
        this.userService = userService;
        this.reservationService = reservationService;
        this.blackListRepository = blackListRepository;
    }

    @Scheduled(cron="* * 0 * * *", zone="Europe/Istanbul")
    public void controlTheBlackListStatus(){
        List<Reservation> activeReservations = reservationService
                .findAllActiveReservations()
                .stream()
                .filter(p -> p.getExpiryDate().isBefore(LocalDate.now()))
                .toList();

        List<User> users = activeReservations.stream()
                .map(Reservation::getUser)
                .toList();
        Optional.of(users).ifPresent(this::addToAllBlackLists);

    }


    protected void addToAllBlackLists(List<User> users){
        for (User user:users) {
            if (user.getBlackList().size()<3){
                blackListRepository.save(new BlackList(user));
            }
            else{
                userService.inactivateUser(user.getId());
                throw new BlackListIsFull(ErrorCode.BLACKLIST_IS_FULL,user);
            }
        }
    }


}
