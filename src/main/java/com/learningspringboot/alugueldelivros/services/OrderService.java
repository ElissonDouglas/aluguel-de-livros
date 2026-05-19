package com.learningspringboot.alugueldelivros.services;

import com.learningspringboot.alugueldelivros.entities.Order;
import com.learningspringboot.alugueldelivros.repositories.OrderRepository;
import com.learningspringboot.alugueldelivros.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    public List<Order> findAll() {
        return repository.findAll();
    }

    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }


}
