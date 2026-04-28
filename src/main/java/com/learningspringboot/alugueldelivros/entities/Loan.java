package com.learningspringboot.alugueldelivros.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspringboot.alugueldelivros.entities.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

@Entity
@Data
@NoArgsConstructor
public class Loan implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // Garante que o formato do Instant será padrão ISO 8601
    private Instant moment;

    private Integer loanStatus;


    @ManyToOne // Relacionamento muitos para um
    @JoinColumn(name = "client_id") // Nome da coluna com a chave estrangeira
    private User client;


    public Loan(Long id, Instant moment, LoanStatus loanStatus, User client) {
        this.id = id;
        this.moment = moment;
        setLoanStatus(loanStatus);
        this.client = client;
    }


    public LoanStatus getLoanStatus() {
        return LoanStatus.valueOf(this.loanStatus);
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        if (loanStatus != null) {
            this.loanStatus = loanStatus.getCode();
        }
    }
}
