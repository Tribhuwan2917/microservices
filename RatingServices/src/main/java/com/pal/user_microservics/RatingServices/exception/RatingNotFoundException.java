package com.pal.user_microservics.RatingServices.exception;

public class RatingNotFoundException extends RuntimeException{
    public RatingNotFoundException(String message)
    {
        super(message);
    }
}
