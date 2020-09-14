package com.expensetracker.controller;

import com.expensetracker.model.Expense;
import com.expensetracker.repository.ExpenseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.Optional;
import java.util.logging.Logger;


@RestController
@RequestMapping("/api")
public class ExpenseController {

    @Autowired
    private ExpenseRepository expenseRepository;


    Logger log = Logger.getLogger(getClass().getName());


    public ExpenseController(ExpenseRepository expenseRepository) {
        super();
        this.expenseRepository = expenseRepository;
    }

    @GetMapping("/expenses")
    Collection<Expense> expenses() {
        return expenseRepository.findAll();
    }

    @GetMapping("/expense/{id}")
    ResponseEntity<?> getExpense(@PathVariable Long id) {
        Optional<Expense> expense = expenseRepository.findById(id);
        return expense.map(response -> ResponseEntity.ok().body(response))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/expense")
    ResponseEntity<Expense> addExpense(@Validated @RequestBody Expense expense) throws URISyntaxException {

        Expense result = expenseRepository.save(expense);

        log.info("After saving expense --> "+ result);

        return ResponseEntity.created(new URI("/api/expense/" + result.getId())).body(result);
    }

    @PutMapping("/expense/{id}")
    ResponseEntity<Expense> updateExpense(@Validated @RequestBody Expense expense) {
        Expense update = expenseRepository.save(expense);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/expense/{id}")
    ResponseEntity<?> deleteExpense(@PathVariable Long id) {
        expenseRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
