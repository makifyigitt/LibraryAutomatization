package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.book.Author;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.model.book.BookType;
import lombok.Data;

@Data
public class BookDTO {
    private int id;
    private String authorName;
    private String title;
    private String isbnno;
    private String typeName;
    private int totalStock;
    private int availableStock;

    public BookDTO(Book book){
        Author author= book.getAuthor();
        BookType bookType = book.getBookType();

        this.id = book.getId();
        this.authorName = author.getName();
        this.title = book.getTitle();
        this.isbnno = book.getIsbnno();
        this.typeName = bookType.getType();
        this.totalStock = book.getTotalStock();
        this.availableStock = book.getAvailableStock();
    }

}
