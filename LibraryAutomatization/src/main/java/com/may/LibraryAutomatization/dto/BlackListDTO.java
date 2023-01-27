package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.blacklist.BlackList;
import com.may.LibraryAutomatization.model.blacklist.BlackListType;
import com.may.LibraryAutomatization.model.user.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDate;

@Data
public class BlackListDTO {

    private int id;

    private int userId;

    private BlackListType blackListType;

    private LocalDate date;

    public BlackListDTO(BlackList blackList){
        this.id = blackList.getId();
        this.userId = blackList.getUser().getId();
        this.blackListType = blackList.getBlackListType();
        this.date = blackList.getDate();
    }
}
