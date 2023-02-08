package com.may.LibraryAutomatization.repository;

import com.may.LibraryAutomatization.model.book.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author,Integer> {
}
