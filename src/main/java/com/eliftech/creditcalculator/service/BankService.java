package com.eliftech.creditcalculator.service;

import com.eliftech.creditcalculator.model.Bank;
import com.eliftech.creditcalculator.repository.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BankService {

    private final BankRepository bankRepository;

    public List<Bank> findAll() {
        var banks = bankRepository.findAll();
        return banks;
    }

    public void saveBank(Bank bank) {
        bankRepository.save(bank);
    }

    public void deleteBank(Long bankId) {
        bankRepository.deleteById(bankId);
    }

    public Bank findById(Long bankId) {
        var bank = bankRepository.findById(bankId).orElseThrow();
        return bank;
    }

    public Bank findByName(String bankName) {
        var bank = bankRepository.findByName(bankName).orElseThrow();
        return bank;
    }
}
