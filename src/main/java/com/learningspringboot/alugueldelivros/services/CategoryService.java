package com.learningspringboot.alugueldelivros.services;

import com.learningspringboot.alugueldelivros.entities.Category;
import com.learningspringboot.alugueldelivros.entities.User;
import com.learningspringboot.alugueldelivros.repositories.CategoryRepository;
import com.learningspringboot.alugueldelivros.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll() {
        return repository.findAll();
    }

    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }
}
