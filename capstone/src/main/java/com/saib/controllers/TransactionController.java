package com.saib.controllers;




import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.saib.config.ApiSuccessPayload;

import com.saib.models.Transaction;
import com.saib.services.TransactionService;
import com.saib.util.Results;


@RestController
public class TransactionController {
	
	@Autowired
	TransactionService transactionService;
	
	@GetMapping("/transactions/All")
	public ResponseEntity<ApiSuccessPayload> getAllTransaction()
	{
		List<Transaction> list=transactionService.getAllTransaction();
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transaction Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		
	}
	
	@GetMapping("/transactions/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByTransactionID(@PathVariable long transactionId)
	{
		Transaction transaction = transactionService.getTransactionByTransactionID(transactionId);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(transaction, "Success",HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/MakeTransaction")
	public ResponseEntity<ApiSuccessPayload> MakeTransaction(@RequestBody Transaction transaction)
	{
		ResponseEntity<ApiSuccessPayload> response=null;
		System.out.println(transaction);
		String result=transactionService.addTransaction(transaction);
		if(result.equalsIgnoreCase(Results.SUCCESS))
		{
			ApiSuccessPayload payload=ApiSuccessPayload.build(result, "transaction was made", HttpStatus.CREATED);
			response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.CREATED);
		}
		
		return response;
	
	}
	

	
	
	@GetMapping("/transactions/getByDate/{date}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByDate(@PathVariable @DateTimeFormat(iso=DateTimeFormat.ISO.DATE) LocalDate date)
	{

		List<Transaction> list = transactionService.getTransactionByDate(date);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transactions Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
		
	}
	
	
	@GetMapping("/transactions/getByTypeAndDate/{transactiontype}/{date}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByTypeAndDate(@PathVariable String transactiontype ,@PathVariable LocalDate date )
	{

		List<Transaction> list = transactionService.getTransactionByTypeAndDate(transactiontype , date);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transactions Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
		
	}
	

	
	
	@PutMapping("/Transactions/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> updateTransaction(@RequestBody Transaction transaction, @PathVariable long transactionId)
	{
		String result=transactionService.updateTransaction(transaction, transactionId);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	@DeleteMapping("/Transactions/{transactionId}")
	public ResponseEntity<ApiSuccessPayload> deleteTransaction(@PathVariable int transactionId)
	{
		String result = transactionService.deleteTransaction(transactionId);
		ApiSuccessPayload payload=ApiSuccessPayload.build(result,result,HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/transactions/transactiontype/{transactionType}")
	public ResponseEntity<ApiSuccessPayload> getTransactionByType(@PathVariable String transactionType)
	{

		List<Transaction> list = transactionService.getTransactionByType(transactionType);
		
		ApiSuccessPayload payload=ApiSuccessPayload.build(list, "Transactions Fetched", HttpStatus.OK);
		ResponseEntity<ApiSuccessPayload> response=new ResponseEntity<ApiSuccessPayload>(payload,HttpStatus.OK);
		
		return response;
		   
		
	}


}

	


