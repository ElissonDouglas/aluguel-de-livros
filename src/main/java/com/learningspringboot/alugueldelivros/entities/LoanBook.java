package com.learningspringboot.alugueldelivros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspringboot.alugueldelivros.entities.pk.LoanBookPk;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Objects;


@Entity
@Table(name = "tb_loan_book")
@Getter
@Setter
@NoArgsConstructor
public class LoanBook implements Serializable {
    private static final long serialVersionUUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private LoanBookPk id = new LoanBookPk();

    private Integer quantity;
    private Double price;

    public LoanBook(Loan loan, Book book, Integer quantity, Double price) {
        super();
        id.setLoan(loan);
        id.setBook(book);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Loan getLoan() {
        return id.getLoan();
    }

    public Book getBook() {
        return id.getBook();
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanBook loanBook = (LoanBook) o;
        return Objects.equals(quantity, loanBook.quantity) && Objects.equals(price, loanBook.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price);
    }
}
