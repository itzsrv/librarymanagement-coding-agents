package com.itzsrv.librarymanagement.repository;

import com.itzsrv.librarymanagement.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

    // Exact match
    List<Book> findByName(String name);

    // Case-insensitive match
    List<Book> findByNameIgnoreCase(String name);

    // Partial match (e.g., LIKE %keyword%)
    List<Book> findByNameContainingIgnoreCase(String keyword);

}
