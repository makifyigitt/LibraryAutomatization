package com.may.LibraryAutomatization.core;

import com.fasterxml.jackson.annotation.JsonView;

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
