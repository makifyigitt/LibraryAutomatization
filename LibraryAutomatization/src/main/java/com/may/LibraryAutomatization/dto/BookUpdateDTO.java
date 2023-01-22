package com.may.LibraryAutomatization.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookUpdateDTO {
    @NotEmpty
    private int totalStock;
    @NotEmpty
    private int availableStock;

}
