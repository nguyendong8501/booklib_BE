package com.example.demoapi.respository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demoapi.model.book.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
