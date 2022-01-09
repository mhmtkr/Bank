package com.sense.pass.repository;

import com.sense.pass.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

// "JpaRepository" returns "List" while "CrudRepository" returns "Iterator"
public interface TransactionRepository extends JpaRepository<Transaction, String> {
}
