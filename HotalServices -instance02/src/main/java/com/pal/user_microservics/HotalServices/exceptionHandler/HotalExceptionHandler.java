package com.pal.user_microservics.HotalServices.exceptionHandler;

import com.pal.user_microservics.HotalServices.exception.HotalAlreadyExistsException;
import com.pal.user_microservics.HotalServices.exception.HotalNotFoundException;
import com.pal.user_microservics.HotalServices.services.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class HotalExceptionHandler {
    @ExceptionHandler(HotalAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> hotalAlreadyExistsExceptionHandler(HotalAlreadyExistsException hotalAlreadyExistsException)
    {
        return new ResponseEntity<>(ApiResponse.builder().errorCode(403).message(hotalAlreadyExistsException.getMessage()).status("BAD_REQUEST").build(), HttpStatus.ALREADY_REPORTED);
    }
    @ExceptionHandler(HotalNotFoundException.class)
    public  ResponseEntity<ApiResponse> HotalNotFoundExceptionHandler(HotalNotFoundException hotalNotFoundException)
    {
        return new ResponseEntity<>(ApiResponse.builder().status("BAD_REQUEST").message(hotalNotFoundException.getMessage()).errorCode(404).build(),HttpStatus.NOT_FOUND);
    }
//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<ApiResponse> globalExceptionHandler(Exception exception)
//    {
//       return new ResponseEntity<>(ApiResponse.builder().errorCode(400).message(exception.getMessage()).status("BAD_REQUEST").build(), HttpStatus.BAD_REQUEST);
//    }
}
