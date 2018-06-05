/*
 * Copyright 2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.apress.batch.chapter10.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Michael Minella
 */
@XmlRootElement(name = "transaction")
public class Transaction {

	private long transactionId;

	private long accountId;

	private BigDecimal credit;

	private BigDecimal debit;

	private Date timestamp;

	public Transaction() {
	}

	public Transaction(long transactionId, long accountId, BigDecimal credit, BigDecimal debit, Date timestamp) {
		this.transactionId = transactionId;
		this.accountId = accountId;
		this.credit = credit;
		this.debit = debit;
		this.timestamp = timestamp;
	}

	public void setTransactionId(long transactionId) {
		this.transactionId = transactionId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public void setCredit(BigDecimal credit) {
		this.credit = credit;
	}

	public void setDebit(BigDecimal debit) {
		this.debit = debit;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public long getTransactionId() {
		return transactionId;
	}

	public long getAccountId() {
		return accountId;
	}

	public BigDecimal getCredit() {
		return credit;
	}

	public BigDecimal getDebit() {
		return debit;
	}

	public Date getTimestamp() {
		return timestamp;
	}
}
