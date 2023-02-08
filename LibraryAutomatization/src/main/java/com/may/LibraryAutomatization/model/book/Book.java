package com.may.LibraryAutomatization.model.book;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.may.LibraryAutomatization.model.Reservation;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "book")
public class Book implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id",nullable = false)
    private Author author;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(max = 13)
    @Column(name = "isbnno",unique = true)
    private String isbnno;

    @NotNull
    @Column(name = "book_type")
    @Enumerated(EnumType.ORDINAL)
    private BookType bookType;

    @NotNull
    @Column(name = "total_stock")
    private int totalStock;

    @NotNull
    @Column(name = "available_stock")
    private int availableStock;

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservationList = new ArrayList<Reservation>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
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

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }
}
