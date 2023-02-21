package com.pt.springmongo.repository;

import com.pt.springmongo.model.Expense;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ExpenseRepository extends MongoRepository<Expense, String> {
    @Query("{'name' :?0}")
    Expense findByName(String name);
}
