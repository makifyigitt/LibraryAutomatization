package com.may.LibraryAutomatization.model.blacklist;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.io.Serializable;

@Data
@Entity
@Table(name = "blacklist_type")
public class BlackListType implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Column(name = "type")
    private String type;

    @Size(max = 255)
    @Column(name = "description")
    private String description;
}
