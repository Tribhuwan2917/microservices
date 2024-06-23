package com.pal.user_microservics.HotalServices.exceptionHandler;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class HotalValidationExcetionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String,String> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException methodArgumentNotValidException)
    {
        Map<String,String>errors=new HashMap<>();
        methodArgumentNotValidException.getBindingResult().getAllErrors().forEach((error)->{
            String nameOfField=((FieldError)error).getField();
            String valueOfField=error.getDefaultMessage();
            errors.put(nameOfField,valueOfField);
        });
        return errors;
    }
}
