package com.expensetracker.service.expense;

import com.expensetracker.model.Category;
import com.expensetracker.model.Expense;
import com.expensetracker.model.User;

import java.util.Collection;
import java.util.Optional;

public interface ExpenseService {

    Expense save(Expense expense);

    Optional<Expense> findById(Long expenseId);

    Expense update(Expense expense);

    void deleteById(Long expenseId);

    Collection<Expense> findAll();

}
