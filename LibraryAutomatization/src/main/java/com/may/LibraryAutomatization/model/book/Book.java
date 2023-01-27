package com.may.LibraryAutomatization.model.book;

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
@Data
public class Book implements Serializable {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "author_id")
    private Author author;

    @NotNull
    @Column(name = "title")
    private String title;

    @NotNull
    @Size(max = 13)
    @Column(name = "ISBNNO",unique = true)
    private String isbnno;

    @NotNull
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name = "type_id")
    private BookType bookType;

    @NotNull
    @Column(name = "total_stock")
    private int totalStock;

    @NotNull
    @Column(name = "available_stock")
    private int availableStock = totalStock; //sor

    @OneToMany(mappedBy = "book",cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Reservation> reservationList = new ArrayList<Reservation>();
}
