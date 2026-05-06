package com.learningspringboot.alugueldelivros.entities.pk;


import com.learningspringboot.alugueldelivros.entities.Book;
import com.learningspringboot.alugueldelivros.entities.Loan;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
@AllArgsConstructor
public class LoanBookPk implements Serializable {
    private static final long serialVersionUUID = 1L;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Loan loan;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Loan getLoan() {
        return loan;
    }

    public void setLoan(Loan loan) {
        this.loan = loan;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        LoanBookPk that = (LoanBookPk) o;
        return Objects.equals(loan, that.loan) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(loan, book);
    }
}
