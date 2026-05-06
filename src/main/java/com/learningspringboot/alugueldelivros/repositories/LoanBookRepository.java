package com.learningspringboot.alugueldelivros.repositories;

import com.learningspringboot.alugueldelivros.entities.LoanItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanBookRepository extends JpaRepository<LoanItem, Long> {
}
