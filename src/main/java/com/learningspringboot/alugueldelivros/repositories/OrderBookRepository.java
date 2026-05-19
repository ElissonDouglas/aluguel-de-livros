package com.learningspringboot.alugueldelivros.repositories;

import com.learningspringboot.alugueldelivros.entities.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderBookRepository extends JpaRepository<OrderItem, Long> {
}
