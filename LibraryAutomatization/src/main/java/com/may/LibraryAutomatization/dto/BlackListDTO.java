package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.blacklist.BlackList;


import java.time.LocalDate;


public class BlackListDTO {

    private int id;

    private int userId;

    private LocalDate date;

    public BlackListDTO(BlackList blackList){
        this.id = blackList.getId();
        this.userId = blackList.getUser().getId();
        this.date = blackList.getDate();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
