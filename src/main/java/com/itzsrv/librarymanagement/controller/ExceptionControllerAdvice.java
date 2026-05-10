package com.itzsrv.librarymanagement.controller;

import com.itzsrv.librarymanagement.backendservices.AppLogger;
import com.itzsrv.librarymanagement.exception.BookNotFoundException;
import com.itzsrv.librarymanagement.exception.MultipleBookFoundException;
import com.itzsrv.librarymanagement.model.Errors;
import com.itzsrv.librarymanagement.model.ResponseError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;

@ControllerAdvice
public class ExceptionControllerAdvice {

    @Autowired
    AppLogger logger;

    @ExceptionHandler(BookNotFoundException.class)
    @ResponseBody
    public ResponseEntity<?> handleBookNotFoundException(BookNotFoundException ex){
        logger.error(ex.getMessage());

        Errors errorsList = new Errors();
        ResponseError responseError = new ResponseError();

        // to fetch internal error code from db
        // InternalResponseErrorCode errorCode = errorCodeLoader.fetchErrorCode()

        responseError.setCode(HttpStatus.NOT_FOUND);
        responseError.setSystemMessage("book does not exist");
        responseError.setUserMessage("try with valid book name");

        errorsList.add(responseError);

        return new ResponseEntity<>(Collections.singletonMap("errors",errorsList),errorsList.get(0).getCode());
    }

    @ExceptionHandler(MultipleBookFoundException.class)
    public ResponseEntity<?> handleMultipleBookFoundException(MultipleBookFoundException ex){

        Errors errorList = new Errors();
        ResponseError responseError = new ResponseError();

        responseError.setCode(HttpStatus.FOUND);
        responseError.setUserMessage("search with unique name");
        responseError.setSystemMessage(ex.getMessage());

        errorList.add(responseError);


        return new ResponseEntity<>(Collections.singletonMap("errors",errorList),errorList.get(0).getCode());
    }
}
