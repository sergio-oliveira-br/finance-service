package com.alucontrol.financeservice.controller;

import com.alucontrol.financeservice.entity.Finance;
import com.alucontrol.financeservice.service.CreateIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/finance/income")
public class CreateIncomeController {

    private final CreateIncomeService createIncomeService;

    @Autowired
    public CreateIncomeController(CreateIncomeService createIncomeService) {
        this.createIncomeService = createIncomeService;
    }

    @PostMapping()
    public ResponseEntity<Finance> createIncome(@RequestBody Finance finance) {

        createIncomeService.saveIncome(finance);
        return ResponseEntity.status(HttpStatus.CREATED).body(finance);
    }
}
