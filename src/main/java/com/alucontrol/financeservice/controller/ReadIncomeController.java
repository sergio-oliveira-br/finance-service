package com.alucontrol.financeservice.controller;

import com.alucontrol.financeservice.entity.Finance;
import com.alucontrol.financeservice.service.ReadIncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/finance/income")
public class ReadIncomeController {

    private final ReadIncomeService readIncomeService;

    @Autowired
    public ReadIncomeController(ReadIncomeService readIncomeService) {
        this.readIncomeService = readIncomeService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Finance> getIncomeById(@PathVariable Long id) {

        return ResponseEntity.ok().body(readIncomeService.findIncomeById(id));
    }

    @GetMapping()
    public ResponseEntity<List<Finance>> getAllIncomes() {
        return ResponseEntity.ok().body(readIncomeService.findAllIncomes());
    }
}
