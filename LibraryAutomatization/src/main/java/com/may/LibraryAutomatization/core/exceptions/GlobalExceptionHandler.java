package com.may.LibraryAutomatization.core.exceptions;

import jakarta.validation.constraints.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    @NotNull
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  @NotNull HttpHeaders headers,
                                                                  @NotNull HttpStatusCode status,
                                                                  @NotNull WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error ->{
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> userNotFoundExceptionHandler(UserNotFoundException exception)  {
        logger.error("Error is handling.",new UserNotFoundException(ErrorCode.USER_NOT_FOUND_EXCEPTION));
        return new ResponseEntity<>(ErrorCode.USER_NOT_FOUND_EXCEPTION.getErrorMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BookNotFoundException.class)
    public final ResponseEntity<Object> handleBookNotFoundExceptions(BookNotFoundException bookNotFoundException){
        logger.error("Error is handling",new BookNotFoundException(ErrorCode.BOOK_NOT_FOUND_EXCEPTION));
        return new ResponseEntity<>(ErrorCode.BOOK_NOT_FOUND_EXCEPTION.getErrorMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ReservationNotFoundException.class)
    public final ResponseEntity<Object> handleReservationNotFoundExceptions(ReservationNotFoundException reservationNotFoundException){
        logger.error("Error is handling",new ReservationNotFoundException(ErrorCode.RESERVATION_NOT_FOUND_EXCEPTION));
        return new ResponseEntity<>(ErrorCode.BOOK_NOT_FOUND_EXCEPTION.getErrorMessage(),HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AuthorNotFoundException.class)
    public final ResponseEntity<Object> handleAuthorNotFoundExceptions(ReservationNotFoundException authorNotFoundException){
        logger.error("Error is handling",new AuthorNotFoundException(ErrorCode.AUTHOR_NOT_FOUND_EXCEPTION));
        return new ResponseEntity<>(ErrorCode.AUTHOR_NOT_FOUND_EXCEPTION.getErrorMessage(),HttpStatus.NOT_FOUND);
    }

//    @ExceptionHandler(BlackListIsFull.class)
//    public final ResponseEntity<Object> handleBlackListNotFoundExceptions(BlackListIsFull blackListIsFull){
//        return new ResponseEntity<>(ErrorCode.BLACKLIST_IS_FULL.getErrorMessage(),HttpStatus.NOT_ACCEPTABLE);
//    }


}
