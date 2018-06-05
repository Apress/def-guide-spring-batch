package com.apress.batch.chapter10.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Account {

	private final long id;
	private final BigDecimal balance;
	private final Date lastStatementDate;
	private final List<Transaction> transactions;

	public Account(long id, BigDecimal balance, Date lastStatementDate, List<Transaction> transactions) {
		this.id = id;
		this.balance = balance;
		this.lastStatementDate = lastStatementDate;
		this.transactions = transactions;
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
		return transactions;
	}
}
