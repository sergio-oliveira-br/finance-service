package com.alucontrol.financeservice.service;

import com.alucontrol.financeservice.entity.Finance;
import com.alucontrol.financeservice.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateIncomeService {

    private final FinanceRepository financeRepository;

    @Autowired
    public CreateIncomeService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public Finance saveIncome(Finance finance) {
        return financeRepository.save(finance);
    }
}
