package com.learningspringboot.alugueldelivros.entities;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.learningspringboot.alugueldelivros.entities.enums.LoanStatus;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="tb_loan")
@Getter
@Setter
@NoArgsConstructor
public class Loan implements Serializable {
    private static final long serialVersionUUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT") // Garante que o formato do Instant será padrão ISO 8601
    private Instant moment;

    private Integer loanStatus;

    @OneToMany(mappedBy = "id.loan")
    private Set<LoanBook> items = new HashSet<>();


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

    public Set<LoanBook> getItems() {
        return items;
    }

    public void setLoanStatus(LoanStatus loanStatus) {
        if (loanStatus != null) {
            this.loanStatus = loanStatus.getCode();
        }
    }
}
