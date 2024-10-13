package com.insert.advice;


import com.insert.exceptions.NonExistentIdValueException;
import com.insert.exceptions.errors.ErrorDetails;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {

    @ExceptionHandler(NonExistentIdValueException.class)
    public ResponseEntity<ErrorDetails> nonExistentIdValueException() {
        ErrorDetails errorDetails = new ErrorDetails();
        errorDetails.setMessage("Такой строки не существует");
        return ResponseEntity.badRequest().body(errorDetails);
    }
}