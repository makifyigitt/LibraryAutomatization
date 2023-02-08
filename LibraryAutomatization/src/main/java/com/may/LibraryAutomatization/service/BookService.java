package com.may.LibraryAutomatization.service;

import com.may.LibraryAutomatization.core.exceptions.AuthorNotFoundException;
import com.may.LibraryAutomatization.core.exceptions.BookNotFoundException;
import com.may.LibraryAutomatization.core.exceptions.ErrorCode;
import com.may.LibraryAutomatization.dto.AuthorDTO;
import com.may.LibraryAutomatization.dto.BookCreateDTO;
import com.may.LibraryAutomatization.model.book.Author;
import com.may.LibraryAutomatization.model.book.Book;
import com.may.LibraryAutomatization.dto.BookDTO;
import com.may.LibraryAutomatization.repository.AuthorRepository;
import com.may.LibraryAutomatization.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookService(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<BookDTO> getAllBooks() {
        List<Book> inDB =bookRepository.findAll();
        return inDB.stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }


    protected Book findById(int id) {
        return bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND_EXCEPTION));
    }

    public BookDTO getById(int id) {
        return new BookDTO(findById(id));
    }

    protected Author findAuthorById(int id){
        return authorRepository.findById(id)
                .orElseThrow(()-> new AuthorNotFoundException(ErrorCode.AUTHOR_NOT_FOUND_EXCEPTION));
    }
    public AuthorDTO getAuthorById(int id){
        return new AuthorDTO(findAuthorById(id));
    }


    public void updateBook(int id, int totalStock, int availableStock) {
        Book inDB = findById(id);
        inDB.setTotalStock(totalStock);
        inDB.setAvailableStock(availableStock);
        bookRepository.save(inDB);
    }


    public void addBook(BookCreateDTO addBookDTO) {
        Book inDB = new Book();
        Author author = findAuthorById(addBookDTO.getAuthorId());
        inDB.setAuthor(author);
        inDB.setTitle(addBookDTO.getTitle());
        inDB.setIsbnno(addBookDTO.getIsbnno());
        inDB.setBookType(addBookDTO.getBookType());
        inDB.setTotalStock(addBookDTO.getTotalStock());
        inDB.setAvailableStock(addBookDTO.getTotalStock());
        bookRepository.save(inDB);
    }


    public void deleteBook(int id) {
        Book inDB = findById(id);
        bookRepository.delete(inDB);
    }

    public void deleteBook(String isbnno){
        Book inDB = findByIsbnno(isbnno);
        bookRepository.delete(inDB);
    }

    protected Book findByIsbnno(String isbnno){
        return bookRepository.findByIsbnno(isbnno)
                .orElseThrow(()-> new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND_EXCEPTION));
    }

    public BookDTO getByIsbnno(String isbnno) {
            return new BookDTO(findByIsbnno(isbnno));
        }


}


