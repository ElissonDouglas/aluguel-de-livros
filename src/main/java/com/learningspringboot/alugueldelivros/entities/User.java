package com.learningspringboot.alugueldelivros.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUUID = 1L;

    
    private Long id;
    private String name;
    private String email;
    private String phone;
    private String password;
}
