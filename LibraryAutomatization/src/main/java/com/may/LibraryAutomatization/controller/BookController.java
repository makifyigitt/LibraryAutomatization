package com.may.LibraryAutomatization.controller;

import com.may.LibraryAutomatization.dto.BookDTO;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/book")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookManager) {
        this.bookService = bookManager;
    }

    @GetMapping("/getall")
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @GetMapping("{id}")
    public ResponseEntity<Book> findById(@PathVariable int id){
        return ResponseEntity.ok(bookService.findById(id));
    }

//    @PutMapping("/update/{id}")
//    public BaseResponse updateBook(@PathVariable int id,@PathVariable BookUpdateDTO bookUpdateDTO){
//        bookManager.updateBook(id,bookUpdateDTO);
//        return new BaseResponse();
//    }




}
