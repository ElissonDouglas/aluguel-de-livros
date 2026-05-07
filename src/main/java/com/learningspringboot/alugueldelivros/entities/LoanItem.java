package com.learningspringboot.alugueldelivros.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspringboot.alugueldelivros.entities.pk.LoanItemPk;
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
public class LoanItem implements Serializable {
    private static final long serialVersionUUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private LoanItemPk id = new LoanItemPk();

    private Integer quantity;
    private Double price;

    public LoanItem(Loan loan, Book book, Integer quantity, Double price) {
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

    public Double getSubTotal() {
        return price * quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanItem loanBook = (LoanItem) o;
        return Objects.equals(quantity, loanBook.quantity) && Objects.equals(price, loanBook.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price);
    }
}
