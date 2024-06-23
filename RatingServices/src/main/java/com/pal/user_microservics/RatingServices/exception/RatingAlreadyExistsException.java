package com.pal.user_microservics.RatingServices.exception;

public class RatingAlreadyExistsException extends RuntimeException{
    public RatingAlreadyExistsException(String message)
    {
        super(message);
    }
}
