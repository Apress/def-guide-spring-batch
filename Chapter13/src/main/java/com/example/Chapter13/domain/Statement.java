package com.example.Chapter13.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Statement {

	private final Customer customer;
	private List<Account> accounts = new ArrayList<>();

	public Statement(Customer customer, List<Account> accounts) {
		this.customer = customer;
		this.accounts.addAll(accounts);
	}

	public Statement(Customer customer) {
		this.customer = customer;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts.addAll(accounts);
	}

	public List<Account> getAccounts() {
		return Collections.unmodifiableList(accounts);
	}
}
