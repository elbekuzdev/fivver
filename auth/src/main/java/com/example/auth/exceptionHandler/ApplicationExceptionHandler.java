package com.example.auth.exceptionHandler;

import com.example.auth.model.ResMessage;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.validation.UnexpectedTypeException;

@ControllerAdvice
public class ApplicationExceptionHandler {
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, InvalidFormatException.class, UnexpectedTypeException.class})
    public ResMessage methodValidException(Exception e){
        return new ResMessage(-1, e.getMessage(), null);
    }
}