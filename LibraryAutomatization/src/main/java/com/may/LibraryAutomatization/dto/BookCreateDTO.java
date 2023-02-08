package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.book.BookType;
import jakarta.validation.constraints.*;


public class BookCreateDTO {

    public BookCreateDTO(int authorId, String title, String isbnno, BookType bookType, int totalStock) {
        this.authorId = authorId;
        this.title = title;
        this.isbnno = isbnno;
        this.bookType = bookType;
        this.totalStock = totalStock;
    }

    @NotNull
    private int authorId;
    @NotEmpty
    private String title;
    @NotEmpty
    @Size(max = 13)
    private String isbnno;

    private BookType bookType;

    @NotNull
    @Min(0)
    private int totalStock;


    public int getAuthorId() {
        return authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbnno() {
        return isbnno;
    }

    public void setIsbnno(String isbnno) {
        this.isbnno = isbnno;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }
}
