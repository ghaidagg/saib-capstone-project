package com.saib.models;

import java.time.LocalDate;
import java.time.LocalDateTime;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")

public class Transaction {
	
	
	@Id
	@Column(name="transaction_id")
	private long transactionid;
	
	@Column(name="from_account")
	private int fromAccount;
	
	@Column(name="to_account")
	private int toAccount;
	
	@Column(name="from_account_name")
	private String fromAccountName;
	
	@Column(name="to_account_name")
	private String toAccountName;
	
	@Column(name="same_bank_transaction")
	private boolean sameBankTransaction;
	
	@Column(name="other_bank")
	private String otherBank;
	
	@Column(name="amount")
	private double amount;
	
	@Column(name="date")
	private LocalDate date ;
	
	@Column(name="time")
	private LocalDateTime time ;
	
	@Column(name="transaction_type")
	private String transactionType ;
	
	@Column(name="status")
	private String status;
	
	

	public Transaction(long transaction_id, int fromAccount, int toAccount, String fromAccountName,
			String toAccountName, boolean sameBankTransaction, String otherBank, double amount, LocalDate date,
			LocalDateTime time, String transactionType , String status) {
		super();
		this.transactionid = transaction_id;
		this.fromAccount = fromAccount;
		this.toAccount = toAccount;
		this.fromAccountName = fromAccountName;
		this.toAccountName = toAccountName;
		this.sameBankTransaction = sameBankTransaction;
		this.otherBank = otherBank;
		this.amount = amount;
		this.date = date;
		this.time = time;
		this.transactionType  = transactionType ;
		this.status = status;
	}
	
	
	
	public Transaction() {
		super();
	
	}



	public long getTransaction_id() {
		return transactionid;
	}
	public void setTransaction_id(long transaction_id) {
		this.transactionid = transaction_id;
	}
	public int getFromAccount() {
		return fromAccount;
	}
	public void setFromAccount(int fromAccount) {
		this.fromAccount = fromAccount;
	}
	public int getToAccount() {
		return toAccount;
	}
	public void setToAccount(int toAccount) {
		this.toAccount = toAccount;
	}
	public String getFromAccountName() {
		return fromAccountName;
	}
	public void setFromAccountName(String fromAccountName) {
		this.fromAccountName = fromAccountName;
	}
	public String getToAccountName() {
		return toAccountName;
	}
	public void setToAccountName(String toAccountName) {
		this.toAccountName = toAccountName;
	}
	public boolean getSameBankTransaction() {
		return sameBankTransaction;
	}
	public void setSameBankTransaction(boolean sameBankTransaction) {
		this.sameBankTransaction = sameBankTransaction;
	}
	public String getotherBank() {
		return otherBank;
	}
	public void setotherBank(String otherBank) {
		this.otherBank = otherBank;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public LocalDateTime getTime() {
		return time;
	}
	public void setTime(LocalDateTime time) {
		this.time = time;
	}
	public String gettransactionType () {
		return transactionType;
	}
	public void settransactionType(String transactionType ) {
		this.transactionType  = transactionType ;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "Transaction [transaction_id=" + transactionid + ", from_account=" + fromAccount + ", to_account="
				+ toAccount + ", from_account_name=" + fromAccountName + ", to_account_name=" + toAccountName
				+ ", same_bank_transaction=" + sameBankTransaction + ", otherBank=" + otherBank + ", amount="
				+ amount + ", date=" + date + ", time=" + time + ", transactionType  =" + transactionType  + ", status="
				+ status + "]";
	}

	
}
