package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.BookNotFoundException;
import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.dto.BookCreateDTO;
import com.may.LibraryAutomatization.dto.BookUpdateDTO;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.dto.BookDTO;
import com.may.LibraryAutomatization.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<Book>inDB =bookRepository.findAll();
        return inDB.stream().map(BookDTO::new).collect(Collectors.toList());
    }


    public Book findById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException(ErrorCode.BOOK_NOT_FOUN_EXCEPTATION));
    }


    public Book updateBook(int id, BookUpdateDTO bookUpdateDTO) {
        Book inDB = findById(id);
        inDB.setTotalStock(bookUpdateDTO.getTotalStock());
        inDB.setAvailableStock(bookUpdateDTO.getAvailableStock());
        return bookRepository.save(inDB);
    }


    public void addBook(BookCreateDTO addBookDTO) {
        Book inDB = new Book();
        inDB.setAuthor(addBookDTO.getAuthor());
        inDB.setTitle(addBookDTO.getTitle());
        inDB.setIsbnno(addBookDTO.getIsbnno());
        inDB.setBookType(addBookDTO.getBookType());
        inDB.setTotalStock(addBookDTO.getTotalStock());
        bookRepository.save(inDB);
    }


    public void deleteBook(int id) {
        Book inDB = findById(id); // to control id does not exist
        bookRepository.delete(inDB);
    }


    public BookDTO getByIsbnno(String isbnno) {
        if(bookRepository.findByIsbnno(isbnno)==null){
            throw new BookNotFoundException(ErrorCode.BOOK_NOT_FOUN_EXCEPTATION);
        }
        else{
            Book inDB = bookRepository.findByIsbnno(isbnno);
            return new BookDTO(inDB);
        }
    }

}
