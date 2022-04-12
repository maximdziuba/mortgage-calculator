package com.eliftech.creditcalculator.controller;

import com.eliftech.creditcalculator.model.Bank;
import com.eliftech.creditcalculator.service.BankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BankRestController {

    private final BankService bankService;

    @GetMapping("/banks/all")
    public List<Bank> getAllBanks() {
        var banks = bankService.findAll();
        return banks;
    }

    @PostMapping("/banks/save")
    public ResponseEntity saveBank(@RequestBody Bank bank) {
        bankService.saveBank(bank);
        return ResponseEntity.ok(bank);
    }

    @PutMapping("/banks/update")
    public ResponseEntity updateBank(@RequestBody Bank bank) {
        bankService.saveBank(bank);
        return ResponseEntity.ok(bank);
    }

    @DeleteMapping("/banks/delete/{bankId}")
    public ResponseEntity deleteBank(@PathVariable Long bankId) {
        bankService.deleteBank(bankId);
        return ResponseEntity.ok("Deleted");
    }
}
