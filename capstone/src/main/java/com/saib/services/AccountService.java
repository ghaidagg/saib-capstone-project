package com.saib.services;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;

import com.saib.models.Account;
import com.saib.repository.AccountRepository;
import com.saib.util.Results;

import net.bytebuddy.asm.Advice.OffsetMapping.Sort;

@Service
public class AccountService {
	
	@Autowired
	AccountRepository accountRepository;
	
	public List<Account> getAllAccount()
	{
		List<Account> list=accountRepository.findAll();
		return list;
	
		
	}
	
	public Account getAccountByAccountNumber(long accountNumber)
	{
		Optional<Account> optional=accountRepository.findById(accountNumber);
		
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account with Account Number:"+accountNumber+"doesn't exist");
		}
		
	}
	
	
	public String addAccount(Account account)
	{
		String result="";
		Account storedAccount=accountRepository.save(account);
		if(storedAccount!=null) {
			result=Results.SUCCESS;
		}
		else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Account not created");
		}
		
		return result;
	}
	
	public String updateAccount(Account account, long accountNumber)
	{
		String result="";
		
		account.setAccountNumber(accountNumber);
		Account updatedAccount=accountRepository.save(account);
		
		if(updatedAccount!=null)
		{
			result=Results.SUCCESS;
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Record was not updated");
		}
		return result;
		
	}
	
	public String deleteAccount(long accountNumber)
	{
		String result="";
		try {
		accountRepository.deleteById(accountNumber);
		
		
			result=Results.SUCCESS;
			return result;
		}
		catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, e.getMessage());
		}
		
		
	}
public List<Account> getAccountsByGender(String gender){
		
		List<Account> accounts=accountRepository.findAccountByGender(gender);
		return accounts;
	}
public List<Account>getAllAccount(Integer pageNO,Integer pageSize,String sortBy){
Pageable paging=PageRequest.of(pageNO,pageSize);
Page<Account> pagedResult=accountRepository.findAll(paging);
int totalElements=pagedResult.getNumberOfElements();
int total=pagedResult.getTotalPages();
System.out.print("total number of page are :"+total+"|total Element "+totalElements);
if (pagedResult.hasContent())
{
	return pagedResult.getContent();
	
}
else
{
	return new ArrayList<Account>();
}
}

}