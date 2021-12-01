package com.saib.services;



import java.time.LocalDate;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import com.saib.models.Transaction;
import com.saib.repository.TransactionRepository;
import com.saib.util.Results;

@Service
public class TransactionService {
	
	@Autowired
	TransactionRepository transactionRepository;
	
	public List<Transaction> getAllTransaction()
	{
		List<Transaction> list=transactionRepository.findAll();
		return list;
	
		
	}
	
	public Transaction getTransactionByTransactionID(long transactionId)
	{
		Optional<Transaction> optional=transactionRepository.findById(transactionId);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"no transaction found eith this id ::"+transactionId+"doesn't exist");
		}
		
	}
	
	
	public String addTransaction(Transaction transaction)
	{
		String result="";
		Transaction storedTransaction = transactionRepository.save(transaction);
		if(storedTransaction!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"transaction is not completed ");
		}
		
		return result;
	}
	
	public String updateTransaction(Transaction transaction, int transactionId)
	{
		String result="";
		
		transaction.setTransaction_id(transactionId);
		Transaction updatedTransaction = transactionRepository.save(transaction);
		
		if(updatedTransaction!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
		
	}



	public List<Transaction> getTransactionByDate(LocalDate date) {
		List<Transaction> list = transactionRepository.findByDate( date);	
		return list;
	}

	
	public String deleteTransaction(long transactionId)
	{
		String result="";
		try {
		transactionRepository.deleteById(transactionId);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
	}
	
	

	public String updateTransaction(Transaction transaction, long transactionId) {
		

		String result="";
		
		transaction.setTransaction_id(transactionId);
		Transaction updatedtransaction = transactionRepository.save(transaction);
		
		if(updatedtransaction!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
	}





	public List<Transaction> getTransactionByTypeAndDate(String type, LocalDate date) {
	
		List<Transaction> list=transactionRepository.findByTransactionTypeAndDate(type , date);
		return list;
	}

	
	
	public List<Transaction> getTransactionByType(String transactionType) {
		
		List<Transaction> list=transactionRepository.findByTransactionType(transactionType);
		return list;
	}

	
	

	


}
