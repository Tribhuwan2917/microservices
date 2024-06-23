package com.pal.User_Microservics.UserServices.exceptions;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String message)
    {
        super(message);
    }
}
