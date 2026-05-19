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
public class OrderItem implements Serializable {
    private static final long serialVersionUUID = 1L;

    @EmbeddedId
    @JsonIgnore
    private LoanItemPk id = new LoanItemPk();

    private Integer quantity;
    private Double price;

    public OrderItem(Order order, Book book, Integer quantity, Double price) {
        super();
        id.setOrder(order);
        id.setBook(book);
        this.quantity = quantity;
        this.price = price;
    }

    @JsonIgnore
    public Order getLoan() {
        return id.getOrder();
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
        OrderItem loanBook = (OrderItem) o;
        return Objects.equals(quantity, loanBook.quantity) && Objects.equals(price, loanBook.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(quantity, price);
    }
}
