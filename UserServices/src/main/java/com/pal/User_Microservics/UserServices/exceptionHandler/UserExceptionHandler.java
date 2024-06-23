package com.pal.User_Microservics.UserServices.exceptionHandler;

import com.pal.User_Microservics.UserServices.exceptions.UserAlreadyExistsException;
import com.pal.User_Microservics.UserServices.exceptions.UserNotFoundException;
import com.pal.User_Microservics.UserServices.services.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiResponse> userAlreadyExistsExceptionHandler(UserAlreadyExistsException userAlreadyExistsException)
    {
        return new ResponseEntity<>(ApiResponse.builder().message(userAlreadyExistsException.getMessage()).status("Bad_Request").errorCode(403).build(),HttpStatus.ALREADY_REPORTED);
    }
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponse> userNotFoundExceptionHandler(UserNotFoundException userNotFoundException)
    {
        return new ResponseEntity<>(ApiResponse.builder().message(userNotFoundException.getMessage()).status("Bad_Request").errorCode(404).build(),HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponse> globalExceptionHandler(Exception exception)
    {
        return new ResponseEntity<>(ApiResponse.builder().message(exception.getMessage()).status("Bad_Request").errorCode(403).build(),HttpStatus.BAD_REQUEST);
    }
}
