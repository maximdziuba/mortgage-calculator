package com.eliftech.creditcalculator.service;

import com.eliftech.creditcalculator.model.Bank;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MortgageService {

    public Double count(Double initLoan, Double downPayment, Bank bank) {
        Double res = Double.valueOf(0);
        var interestRate = bank.getInterestRate();
        var loanTerm = bank.getLoanTerm();
        if (downPayment >= bank.getMinimumDownPayment()) {
            res = (initLoan * (interestRate/12) * Math.pow((1 +  interestRate/12), loanTerm)) / (Math.pow((1 + interestRate/12), loanTerm) - 1);
        }
        return res;
    }
}
