package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.book.Author;
import com.may.LibraryAutomatization.model.book.BookType;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class BookCreateDTO {
    @NotNull
    private Author author;
    @NotBlank
    private String title;
    @NotBlank
    private String isbnno;
    @NotNull
    private BookType bookType;
    @NotEmpty
    @Min(0)
    private int totalStock;

}
