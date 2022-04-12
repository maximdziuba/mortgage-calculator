package com.eliftech.creditcalculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double interestRate;
    private Double maximumLoan;
    private Double minimumDownPayment;
    private Double loanTerm;

    public Bank(String name, Double interestRate, Double maximumLoan, Double minimumDownPayment, Double loanTerm) {
        this.name = name;
        this.interestRate = interestRate;
        this.maximumLoan = maximumLoan;
        this.minimumDownPayment = minimumDownPayment;
        this.loanTerm = loanTerm;
    }
}
