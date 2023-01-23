package com.may.LibraryAutomatization.core;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class BaseResponse {

    @JsonView(View.Base.class)
   private String message;
}
