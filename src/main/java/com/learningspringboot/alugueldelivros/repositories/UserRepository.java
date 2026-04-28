package com.learningspringboot.alugueldelivros.repositories;

import com.learningspringboot.alugueldelivros.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
