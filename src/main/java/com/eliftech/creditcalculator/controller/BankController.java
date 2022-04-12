package com.eliftech.creditcalculator.controller;

import com.eliftech.creditcalculator.model.Bank;
import com.eliftech.creditcalculator.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
public class BankController {

    private final BankService bankService;

    @GetMapping
    public String getAllBanks(Model model) {
        var banks = bankService.findAll();
        if (banks.isEmpty()) {
            model.addAttribute("banks",0);
        } else {
            model.addAttribute("banks", banks);
        }
        return "index";
    }

    @GetMapping("/create")
    public String getCreateBankPage() {
        return "createBank";
    }

    @PostMapping("/create")
    public String createBank(@RequestParam String bankName, @RequestParam Double interestRate,
                             @RequestParam Double maxLoan, @RequestParam Double minDownPayment,
                             @RequestParam Double loanTerm) {
        var bankToSave = Bank.builder()
                .name(bankName)
                .interestRate(interestRate)
                .maximumLoan(maxLoan)
                .minimumDownPayment(minDownPayment)
                .loanTerm(loanTerm)
                .build();
        bankService.saveBank(bankToSave);
        return "redirect:/";
    }

    @GetMapping("/edit/{bankId}")
    public String editBank(@PathVariable Long bankId, Model model) {
        var bankFromDb = bankService.findById(bankId);
        model.addAttribute("bank", bankFromDb);
        return "editBank";
    }

    @PostMapping("/edit/{bankId}")
    public String saveEditedBank(@PathVariable Long bankId, @RequestParam String bankName, @RequestParam Float interestRate,
                                 @RequestParam Double maxLoan, @RequestParam Double minDownPayment,
                                 @RequestParam Double loanTerm) {
        var bank = Bank.builder()
                .id(bankId)
                .name(bankName)
                .maximumLoan(maxLoan)
                .minimumDownPayment(minDownPayment)
                .loanTerm(loanTerm)
                .build();
        bankService.saveBank(bank);
        return "redirect:/";
    }

    @GetMapping("/delete/{bankId}")
    public String deleteBank(@PathVariable Long bankId) {
        bankService.deleteBank(bankId);
        return "redirect:/";
    }
}
