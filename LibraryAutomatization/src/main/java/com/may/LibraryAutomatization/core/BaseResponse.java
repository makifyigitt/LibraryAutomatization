package com.may.LibraryAutomatization.core;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class BaseResponse {

    @JsonView(View.Base.class)
    private int response =-1;
    private int errorCode = 0;
    private String message = "Successfuly";

    public BaseResponse(int response, int errorCode, String message) {
        this.response = response;
        this.errorCode = errorCode;
        this.message = message;
    }
}
