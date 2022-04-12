package com.eliftech.creditcalculator.controller;

import com.eliftech.creditcalculator.service.BankService;
import com.eliftech.creditcalculator.service.MortgageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class MortgageRestController {

    private final MortgageService mortgageService;
    private final BankService bankService;

    @PostMapping("/mortgage/count")
    public Double countMortgage(@RequestParam Double initLoan,
                                @RequestParam Double downPayment,
                                @RequestParam String bank) {
        Double res;
        try {
            var bankFromDb = bankService.findByName(bank);
            res = mortgageService.count(initLoan, downPayment, bankFromDb);
        } catch (Exception e) {
            res = Double.valueOf(0);
        }
        return res;

    }
}
