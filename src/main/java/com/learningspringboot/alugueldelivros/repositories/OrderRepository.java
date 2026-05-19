package com.learningspringboot.alugueldelivros.repositories;

import com.learningspringboot.alugueldelivros.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
