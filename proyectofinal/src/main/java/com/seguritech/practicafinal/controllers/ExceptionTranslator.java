package com.seguritech.practicafinal.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class ExceptionTranslator {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public String processNullPointerException(NullPointerException npe){
        return npe.getMessage();
    }
}
