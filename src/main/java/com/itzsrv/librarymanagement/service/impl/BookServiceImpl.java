package com.itzsrv.librarymanagement.service.impl;

import com.itzsrv.librarymanagement.backendservices.AppLogger;
import com.itzsrv.librarymanagement.exception.MultipleBookFoundException;
import com.itzsrv.librarymanagement.mapper.BookMapper;
import com.itzsrv.librarymanagement.model.Book;
import com.itzsrv.librarymanagement.model.BookRequest;
import com.itzsrv.librarymanagement.model.BookResponse;
import com.itzsrv.librarymanagement.repository.BookRepository;
import com.itzsrv.librarymanagement.service.BookService;
import com.itzsrv.librarymanagement.exception.BookNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BookServiceImpl implements BookService {

    /*@Autowired
    BookDao bookDao;*/

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookMapper bookMapper;

    @Autowired
    AppLogger logger;

    @Override
    public BookResponse createBook(BookRequest bookRequest, Map<String, String> headerMap) {

        // 1. convert request dto -> entity
        Book book = bookMapper.toEntity(bookRequest);

        // 2. persist entity to db
        Book savedBook = bookRepository.save(book);

        // 3. convert entity -> response dto
        BookResponse bookResponse = bookMapper.toBookResponse(savedBook);

        return bookResponse;
    }

    @Override
    public List<BookResponse> searchBook(BookRequest bookRequest, Map<String, String> headerMap) {

        Book book = bookMapper.toEntity(bookRequest);

        List<Book> searchedBooks = bookRepository.findByName(book.getName());

        if(searchedBooks.isEmpty()){
            throw new BookNotFoundException("No book with name "+ bookRequest.getName() + " found in the record");
        } else if (searchedBooks.size()>1) {
            //throw new MultipleBookFoundException("More than one book with name "+ bookRequest.getName() + " found in the record");
            return searchedBooks;
        }else{
            List<BookResponse> bookResponse = bookMapper.toBookResponse(searchedBooks.get(0));
            return bookResponse;
        }

    }


}
