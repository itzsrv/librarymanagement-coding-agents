package com.itzsrv.librarymanagement.service;

import com.itzsrv.librarymanagement.model.BookRequest;
import com.itzsrv.librarymanagement.model.BookResponse;

import java.util.List;
import java.util.Map;

public interface BookService {

    BookResponse createBook(BookRequest bookRequest, Map<String, String> headerMap);
    List<BookResponse> searchBook(BookRequest bookRequest, Map<String, String> headerMap);
}
