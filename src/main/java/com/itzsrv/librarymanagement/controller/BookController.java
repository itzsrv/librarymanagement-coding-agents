package com.itzsrv.librarymanagement.controller;


import com.itzsrv.librarymanagement.backendservices.AppLogger;
import com.itzsrv.librarymanagement.model.BookRequest;
import com.itzsrv.librarymanagement.model.BookResponse;
import com.itzsrv.librarymanagement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/lib")
public class BookController {

    @Autowired
    private AppLogger logger;

    @Autowired
    private BookService bookService;



    @PostMapping(value = "/books")
    public ResponseEntity<BookResponse> createBook(
            @RequestBody BookRequest bookRequest,
            @RequestHeader Map<String, String> headerMap
    ){
        logger.info("Method_Name=createBook, requestBody={}, requestHeader={}", bookRequest.toString(), headerMap.toString());

        BookResponse responseBody = bookService.createBook(bookRequest, headerMap);
        //logger.info("bookCreated name={}, id={}",responseBody.getName(), responseBody.getId());

        return ResponseEntity.ok().body(responseBody);
    }

    @GetMapping(value = "/books")
    public ResponseEntity<List<BookResponse>> getBook(
            @RequestBody BookRequest bookRequest,
            @RequestHeader Map<String, String> headerMap){
        logger.info("Method_Name=getBook, requestBody={}, requestHeader={}", bookRequest.toString(), headerMap.toString());

        List<BookResponse> responseBody = bookService.searchBook(bookRequest, headerMap);
        return ResponseEntity.ok().body(responseBody);
    }
}
