package com.saib.repository;

import java.time.LocalDate;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.saib.models.Transaction;

	public interface TransactionRepository extends JpaRepository<Transaction,Long> {

		List<Transaction> findByDate(LocalDate date);
		List<Transaction> findByTransactionTypeAndDate(String type, LocalDate date);
		List<Transaction> findByTransactionType(String transactiontype );

	}
	