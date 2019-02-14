package com.example.Chapter13.domain;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Account {

	private final long id;
	private final BigDecimal balance;
	private final Date lastStatementDate;
	private final List<Transaction> transactions = new ArrayList<>();

	public Account(long id, BigDecimal balance, Date lastStatementDate) {
		this.id = id;
		this.balance = balance;
		this.lastStatementDate = lastStatementDate;
	}

	public long getId() {
		return id;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public Date getLastStatementDate() {
		return lastStatementDate;
	}

	public List<Transaction> getTransactions() {
		return Collections.unmodifiableList(transactions);
	}

	public void addTransaction(Transaction transaction) {
		this.transactions.add(transaction);
	}
}
