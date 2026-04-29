package com.learningspringboot.alugueldelivros.config;

import com.learningspringboot.alugueldelivros.entities.Category;
import com.learningspringboot.alugueldelivros.entities.Loan;
import com.learningspringboot.alugueldelivros.entities.User;
import com.learningspringboot.alugueldelivros.entities.enums.LoanStatus;
import com.learningspringboot.alugueldelivros.repositories.CategoryRepository;
import com.learningspringboot.alugueldelivros.repositories.LoanRepository;
import com.learningspringboot.alugueldelivros.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoanRepository loanRepository;
    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void run(String...args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        Loan l1 = new Loan(null, Instant.parse("2026-02-20T19:53:07Z"), LoanStatus.valueOf(1), u1);
        Loan l2 = new Loan(null, Instant.parse("2026-03-21T03:42:10Z"), LoanStatus.valueOf(2), u2);
        Loan l3 = new Loan(null, Instant.parse("2026-03-22T15:21:22Z"), LoanStatus.valueOf(2), u1);

        Category c1 = new Category(null, "Horror");
        Category c2 = new Category(null, "Adventure");
        Category c3 = new Category(null, "Romance");



        userRepository.saveAll(Arrays.asList(u1,u2));
        loanRepository.saveAll(Arrays.asList(l1, l2, l3));
        categoryRepository.saveAll(Arrays.asList(c1, c2, c3));
    }
}
