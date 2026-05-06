package com.learningspringboot.alugueldelivros.config;

import com.learningspringboot.alugueldelivros.entities.*;
import com.learningspringboot.alugueldelivros.entities.enums.LoanStatus;
import com.learningspringboot.alugueldelivros.repositories.*;
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

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private LoanBookRepository loanBookRepository;

    @Override
    public void run(String...args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1,u2));

        Loan l1 = new Loan(null, Instant.parse("2026-02-20T19:53:07Z"), LoanStatus.valueOf(1), u1);
        Loan l2 = new Loan(null, Instant.parse("2026-03-21T03:42:10Z"), LoanStatus.valueOf(2), u2);
        Loan l3 = new Loan(null, Instant.parse("2026-03-22T15:21:22Z"), LoanStatus.valueOf(2), u1);

        loanRepository.saveAll(Arrays.asList(l1, l2, l3));

        Category c1 = new Category(null, "Horror");
        Category c2 = new Category(null, "Adventure");
        Category c3 = new Category(null, "Romance");
        Category c4 = new Category(null, "Fiction");

        categoryRepository.saveAll(Arrays.asList(c1, c2, c3, c4));

        Book p1 = new Book(null,
                "O Iluminado",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                59.90,
                "https://example.com/books/horror/iluminado.jpg"
        );

        Book p2 = new Book(null,
                "O Hobbit",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                64.00,
                "https://example.com/books/adventure/hobbit.jpg"
        );

        Book p3 = new Book(null,
                "Orgulho e Preconceito",
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                39.90,
                "https://example.com/books/romance/orgulho-preconceito.jpg"
        );

       // productRepository.saveAll(Arrays.asList(p1, p2, p3));
        // associando produtos com categorias
        p1.getCategories().add(c1);
     p1.getCategories().add(c4);
       p2.getCategories().add(c2);
       p2.getCategories().add(c4);
      p3.getCategories().add(c3);


        bookRepository.saveAll(Arrays.asList(p1, p2, p3));

        LoanItem oi1 = new LoanItem(l1, p1, 2, p1.getPrice());
        LoanItem oi2 = new LoanItem(l1, p3, 1, p3.getPrice());
        LoanItem oi3 = new LoanItem(l2, p3, 2, p3.getPrice());
        LoanItem oi4 = new LoanItem(l3, p2, 2, p2.getPrice());

        loanBookRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

    }
}
