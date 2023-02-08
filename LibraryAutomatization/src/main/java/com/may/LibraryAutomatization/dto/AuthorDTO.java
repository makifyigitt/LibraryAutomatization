package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.book.Author;

import java.util.List;
import java.util.stream.Collectors;

public class AuthorDTO {

    private int id;
    private String name;
    private String surname;
    private List<BookDTO> bookDTOS;

    public AuthorDTO(Author author) {
        this.id = author.getId();
        this.name = author.getName();
        this.surname = author.getSurname();
        this.bookDTOS = author.getBooks()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }
}
