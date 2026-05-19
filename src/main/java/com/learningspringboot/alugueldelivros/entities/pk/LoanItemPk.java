package com.learningspringboot.alugueldelivros.entities.pk;


import com.learningspringboot.alugueldelivros.entities.Book;
import com.learningspringboot.alugueldelivros.entities.Order;
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
public class LoanItemPk implements Serializable {
    private static final long serialVersionUUID = 1L;

    @ManyToOne
    @JoinColumn(name = "loan_id")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "book_id")
    private Book book;

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
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
        LoanItemPk that = (LoanItemPk) o;
        return Objects.equals(order, that.order) && Objects.equals(book, that.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, book);
    }
}
