package com.learningspringboot.alugueldelivros.config;

import com.learningspringboot.alugueldelivros.entities.Loan;
import com.learningspringboot.alugueldelivros.entities.User;
import com.learningspringboot.alugueldelivros.repositories.LoanRepository;
import com.learningspringboot.alugueldelivros.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.List;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;

    @Override
    public void run(String...args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Loan l1 = new Loan(null, Instant.parse("2026-02-20T19:53:07Z"), u1);
        Loan l2 = new Loan(null, Instant.parse("2026-03-21T03:42:10Z"), u2);
        Loan l3 = new Loan(null, Instant.parse("2026-03-22T15:21:22Z"), u1);


        userRepository.saveAll(List.of(u1,u2));
        loanRepository.saveAll(List.of(l1, l2, l3));
    }
}
