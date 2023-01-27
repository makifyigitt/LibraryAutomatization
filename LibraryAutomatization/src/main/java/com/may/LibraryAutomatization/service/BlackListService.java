package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.BlackListNotFoundException;
import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.dto.BlackListDTO;

import com.may.LibraryAutomatization.model.blacklist.BlackList;
import com.may.LibraryAutomatization.model.blacklist.BlackListType;
import com.may.LibraryAutomatization.model.user.User;
import com.may.LibraryAutomatization.repository.BlackListRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BlackListService {

    private final BlackListRepository blackListRepository;
    private final UserService userService;

    public BlackListService(BlackListRepository blackListRepository, UserService userService) {
        this.blackListRepository = blackListRepository;
        this.userService = userService;
    }

    public List<BlackListDTO> getAllBlackLists(){
        List<BlackList> blackLists = blackListRepository.findAll();
        return blackLists
                .stream()
                .map(BlackListDTO::new)
                .collect(Collectors.toList());
    }

    protected BlackList findById(int id){
        return blackListRepository.findById(id)
                .orElseThrow(() -> new BlackListNotFoundException(ErrorCode.BLACKLIST_NOT_FOUND_EXCEPTION));
    }

    public BlackListDTO getById(int id){
        return new BlackListDTO(findById(id));
    }

    protected List<BlackList> findBlackListByUserId(int id){
        return blackListRepository.findAllBlackListsByUser(userService.findUserById(id))
                .orElseThrow(()-> new BlackListNotFoundException(ErrorCode.BLACKLIST_NOT_FOUND_EXCEPTION));
    }

    public List<BlackListDTO> getBlackListByUserId(int id){
        return findBlackListByUserId(id)
                .stream()
                .map(BlackListDTO::new)
                .collect(Collectors.toList());
    }

    public void create(User user, BlackListType blackListType){
        if (findBlackListByUserId(user.getId()).size() < 3){
            BlackList blackList = new BlackList(user,blackListType);
            blackList.setDate(LocalDate.now());
            blackListRepository.save(blackList);
            System.out.println("The user is warned!! The reason for warning: " + blackListType.getTypeDescription());
        }else { //to make user inactive
            System.out.println("The user get warning 3 times. That is mean user temporarily banned.");
            userService.inactivateUser(user.getId());
        }

    }

}
