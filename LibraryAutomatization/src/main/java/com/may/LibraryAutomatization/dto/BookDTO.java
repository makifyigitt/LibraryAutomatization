package com.may.LibraryAutomatization.dto;

import com.may.LibraryAutomatization.model.book.Author;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.model.book.BookType;



public class BookDTO {
    private int id;
    private String authorName;
    private String title;
    private String isbnno;
    private BookType bookType;
    private int totalStock;
    private int availableStock;

    public BookDTO(Book book){
        Author author= book.getAuthor();

        this.id = book.getId();
        this.authorName = author.getName();
        this.title = book.getTitle();
        this.isbnno = book.getIsbnno();
        this.bookType = book.getBookType();
        this.totalStock = book.getTotalStock();
        this.availableStock = book.getAvailableStock();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
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

    public int getAvailableStock() {
        return availableStock;
    }

    public void setAvailableStock(int availableStock) {
        this.availableStock = availableStock;
    }
}
