package com.pt.springmongo.service;

import com.pt.springmongo.model.Expense;

import java.util.List;

public interface ExpenseService {
    void addExpense(Expense expense);

    List<Expense> getAllExpenses();

    void updateExpense(Expense expense);

    void deleteExpense(String id);

    Expense getExpenseByName(String name);
}
