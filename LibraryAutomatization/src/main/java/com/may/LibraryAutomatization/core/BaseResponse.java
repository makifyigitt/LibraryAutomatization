package com.may.LibraryAutomatization.core;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;



public class BaseResponse {
    public BaseResponse(String message) {
        this.message = message;
    }

    @JsonView(View.Base.class)
   private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
