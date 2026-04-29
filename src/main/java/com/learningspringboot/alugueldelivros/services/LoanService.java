package com.learningspringboot.alugueldelivros.services;

import com.learningspringboot.alugueldelivros.entities.Loan;
import com.learningspringboot.alugueldelivros.repositories.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoanService {

    @Autowired
    private LoanRepository repository;

    public List<Loan> findAll() {
        return repository.findAll();
    }

    public Loan findById(Long id) {
        Optional<Loan> obj = repository.findById(id);
        return obj.get();
    }


}
