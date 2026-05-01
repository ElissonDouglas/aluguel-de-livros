package com.learningspringboot.alugueldelivros.entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tb_category")
@Getter
@Setter
@NoArgsConstructor
public class Category implements Serializable {
    private static final Long serialVersionUUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @JsonIgnore
    @ManyToMany(mappedBy = "categories") // nome da coleçao de categorias na entidade product
    private Set<Book> books = new HashSet<>();


    public Category(Long id, String name) {
        this.id = id;
        this.name = name;
    }
}
