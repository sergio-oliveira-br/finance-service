package com.alucontrol.financeservice.service;

import com.alucontrol.financeservice.entity.Finance;
import com.alucontrol.financeservice.exceptions.ExpenseNotFoundException;
import com.alucontrol.financeservice.exceptions.IncomeNotFoundException;
import com.alucontrol.financeservice.repository.FinanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReadIncomeService {

    private final FinanceRepository financeRepository;

    @Autowired
    public ReadIncomeService(FinanceRepository financeRepository) {
        this.financeRepository = financeRepository;
    }

    public Finance findIncomeById(Long id) {

       Optional<Finance> finance = financeRepository.findById(id);
       if (finance.isPresent()) {
           return finance.get();

       }
       throw new IncomeNotFoundException("Despesa id" + id + " não foi encontrada");
    }


    public List<Finance> findAllIncomes() {
        return financeRepository.findAll();
    }
}
