package com.itzsrv.librarymanagement.mapper;

import com.itzsrv.librarymanagement.model.Book;
import com.itzsrv.librarymanagement.model.BookRequest;
import com.itzsrv.librarymanagement.model.BookResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BookMapper {

    public Book toEntity(BookRequest bookRequest){
        Book book = new Book();
        book.setName(bookRequest.getName());
        book.setAuthor(bookRequest.getAuthor());
        book.setPublisher(bookRequest.getPublisher());
        book.setPrice(bookRequest.getPrice());
        book.setIssueDate(bookRequest.getIssueDate());
        book.setCategory(bookRequest.getCategory());
        book.setStatus(bookRequest.getStatus());
        return book;
    }
    
    public List<BookResponse> toBookResponse(Book book){
        List<BookResponse> bookResponses = new ArrayList<BookResponse>();
        BookResponse bookResponse = new BookResponse();
        bookResponse.setName(book.getName());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setCategory(book.getCategory());
        bookResponse.setPrice(book.getPrice());
        bookResponse.setPublisher(book.getPublisher());
        bookResponse.setStatus(book.getStatus());
        bookResponse.setIssueDate(book.getIssueDate());
        bookResponse.setId(book.getId());
        bookResponses.add(bookResponse);
        return bookResponses;
    }
}
