package com.learningspringboot.alugueldelivros.resources;


import com.learningspringboot.alugueldelivros.entities.Loan;
import com.learningspringboot.alugueldelivros.services.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/loans")
public class LoanResource {

    @Autowired
    private LoanService service;

    @GetMapping
    public ResponseEntity<List<Loan>> findAll() {
        return ResponseEntity.ok().body(service.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Loan> findById(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }
}
