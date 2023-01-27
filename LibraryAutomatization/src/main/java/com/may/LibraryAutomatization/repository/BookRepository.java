package com.may.LibraryAutomatization.repository;

import com.may.LibraryAutomatization.model.book.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface BookRepository extends JpaRepository<Book,Integer> {

    @Query("Select c From Book c where (c.isbnno =: isbnno) or (c.isbnno is null)")
    Optional<Book> findByIsbnno(@Param("isbnno") String isbnno);

}
