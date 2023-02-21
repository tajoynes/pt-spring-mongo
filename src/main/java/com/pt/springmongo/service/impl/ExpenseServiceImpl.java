package com.pt.springmongo.service.impl;

import com.pt.springmongo.model.Expense;
import com.pt.springmongo.repository.ExpenseRepository;
import com.pt.springmongo.service.ExpenseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl implements ExpenseService {
    private final ExpenseRepository expenseRepository;

    public ExpenseServiceImpl(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public void addExpense(Expense expense) {
        expenseRepository.insert(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void updateExpense(Expense expense) {
        Expense existingExpense = expenseRepository.findById(expense.getId())
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        existingExpense.setExpenseName(expense.getExpenseName());
        existingExpense.setExpenseCategory(expense.getExpenseCategory());
        existingExpense.setExpenseAmount(expense.getExpenseAmount());
        expenseRepository.save(existingExpense);
    }

    @Override
    public void deleteExpense(String id) {
        Expense expense = expenseRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Expense not found"));
        expenseRepository.delete(expense);
    }

    @Override
    public Expense getExpenseByName(String name) {
        Expense expense = expenseRepository.findByName(name);
        return expense;
    }
}
