package com.pal.user_microservics.RatingServices.exceptionHandler;

import com.pal.user_microservics.RatingServices.exception.RatingAlreadyExistsException;
import com.pal.user_microservics.RatingServices.exception.RatingNotFoundException;
import com.pal.user_microservics.RatingServices.services.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class RatingExceptionHandler {
    @ExceptionHandler(RatingNotFoundException.class)
    public ResponseEntity<ApiResponse> ratingNotFoundExceptionHandler(RatingNotFoundException ratingNotFoundException)
    {
        return new ResponseEntity<>(ApiResponse.builder().errorCode(404).message(ratingNotFoundException.getMessage()).status("BAD_REQUEST").build(), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(RatingAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> ratingAlreadyExistsExceptionHandler(RatingAlreadyExistsException ratingAlreadyExistsException)
    {
        return new ResponseEntity<>(ApiResponse.builder().errorCode(403).message(ratingAlreadyExistsException.getMessage()).status("BAD_REQUEST").build(),HttpStatus.ALREADY_REPORTED);
    }
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String>methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,String> errors=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String nameOfErrorField=((FieldError)error).getField();
            String valueOfErrorField=error.getDefaultMessage();
            errors.put(nameOfErrorField,valueOfErrorField);
        });
        return errors;
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> globalExceptionHandler(Exception exception)
    {
        return new ResponseEntity<>(ApiResponse.builder().errorCode(403).message(exception.getMessage()).status("BAD_REQUEST").build(),HttpStatus.BAD_REQUEST);
    }
}
