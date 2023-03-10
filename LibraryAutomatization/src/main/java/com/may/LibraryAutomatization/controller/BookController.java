package com.may.LibraryAutomatization.controller;

import com.may.LibraryAutomatization.core.BaseResponse;
import com.may.LibraryAutomatization.dto.BookCreateDTO;
import com.may.LibraryAutomatization.dto.BookDTO;
import com.may.LibraryAutomatization.service.BookService;
import jakarta.validation.Valid;
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

    @GetMapping("/id")
    public ResponseEntity<BookDTO> getById(@RequestParam int id){
        return ResponseEntity.ok(bookService.getById(id));
    }

    @GetMapping("/isbnno")
    public ResponseEntity<BookDTO> getByIsbnno(@RequestParam String isbnno) {
        return ResponseEntity.ok(bookService.getByIsbnno(isbnno));
    }

    @PutMapping("/update")
    public ResponseEntity<BookDTO> updateBook(@RequestParam int id,
                                              @RequestParam int total,
                                              @RequestParam int available){
        bookService.updateBook(id,total,available);
        return ResponseEntity.ok(bookService.getById(id));
    }

    @PostMapping("/add")
    public ResponseEntity<BookDTO> addBook(@RequestBody @Valid BookCreateDTO addBookDTO){
        bookService.addBook(addBookDTO);
        return ResponseEntity.ok(bookService.getByIsbnno(addBookDTO.getIsbnno()));
    }

    @DeleteMapping("/delete/id")
    public BaseResponse deleteBook(@RequestParam int id){
        bookService.deleteBook(id);
        return new BaseResponse("Book has this id: " + id + "is deleted successfully");
    }

    @DeleteMapping("/delete/isbnno")
    public BaseResponse deleteBook(@RequestParam String isbnno){
        bookService.deleteBook(isbnno);
        return new BaseResponse("Book has this ISBNNO: " + isbnno + "is deleted successfully");
    }








}
