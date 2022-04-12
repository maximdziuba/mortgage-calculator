package com.eliftech.creditcalculator.controller;

import com.eliftech.creditcalculator.service.BankService;
import com.eliftech.creditcalculator.service.MortgageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class MortgageController {

    private final BankService bankService;
    private final MortgageService mortgageService;

    @GetMapping("/count")
    public String getDataForMortgage(Model model) {
        var allBanks = bankService.findAll();
        model.addAttribute("banks", allBanks);
        return "calculator";
    }

    @PostMapping("/count")
    public String countMortgage(@RequestParam Double initLoan,
                                @RequestParam Double downPayment,
                                @RequestParam String bank,
                                Model model) {
        Double res;
        try {
            var bankFromDb = bankService.findByName(bank);
            res = mortgageService.count(initLoan, downPayment, bankFromDb);
        } catch (Exception e) {
            res = Double.valueOf(0);
        }
       model.addAttribute("res", res);
       return "result";
    }

}
