package com.learningspringboot.alugueldelivros.services;

import com.learningspringboot.alugueldelivros.entities.Book;
import com.learningspringboot.alugueldelivros.repositories.BookRepository;
import com.learningspringboot.alugueldelivros.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public List<Book> findAll() {
        return repository.findAll();
    }

    public Book findById(Long id) {
        Optional<Book> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
