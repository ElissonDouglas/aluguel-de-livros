package com.learningspringboot.alugueldelivros.repositories;

import com.learningspringboot.alugueldelivros.entities.Loan;
import com.learningspringboot.alugueldelivros.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
