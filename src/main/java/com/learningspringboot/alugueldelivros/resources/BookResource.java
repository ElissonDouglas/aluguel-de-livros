package com.learningspringboot.alugueldelivros.resources;

import com.learningspringboot.alugueldelivros.entities.Book;
import com.learningspringboot.alugueldelivros.services.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/books")
public class BookResource {

    @Autowired
    private BookService service;

    @GetMapping
    public ResponseEntity<List<Book>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
