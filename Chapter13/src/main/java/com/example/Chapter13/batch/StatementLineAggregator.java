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
package com.example.Chapter13.batch;

import java.math.BigDecimal;
import java.util.Date;

import com.example.Chapter13.domain.Account;
import com.example.Chapter13.domain.Customer;
import com.example.Chapter13.domain.Statement;
import com.example.Chapter13.domain.Transaction;

import org.springframework.batch.item.file.transform.LineAggregator;
import org.springframework.util.CollectionUtils;

/**
 * @author Michael Minella
 */
public class StatementLineAggregator implements LineAggregator<Statement> {

	private static final String ADDRESS_LINE_ONE =
			String.format("%121s\n", "Apress Banking");
	private static final String ADDRESS_LINE_TWO =
			String.format("%120s\n", "1060 West Addison St.");
	private static final String ADDRESS_LINE_THREE =
			String.format("%120s\n\n", "Chicago, IL 60613");
	private static final String STATEMENT_DATE_LINE =
			String.format("Your Account Summary %78s ", "Statement Period") + "%tD to %tD\n\n";

	public String aggregate(Statement statement) {
		StringBuilder output = new StringBuilder();

		formatHeader(statement, output);
		formatAccount(statement, output);

		return output.toString();
	}

	private void formatAccount(Statement statement, StringBuilder output) {
		if(!CollectionUtils.isEmpty(statement.getAccounts())) {

			for (Account account : statement.getAccounts()) {

				output.append(
						String.format(STATEMENT_DATE_LINE,
								account.getLastStatementDate(),
								new Date()));

				BigDecimal creditAmount = new BigDecimal(0);
				BigDecimal debitAmount = new BigDecimal(0);
				for (Transaction transaction : account.getTransactions()) {
					if(transaction.getCredit() != null) {
						creditAmount = creditAmount.add(transaction.getCredit());
					}

					if(transaction.getDebit() != null) {
						debitAmount = debitAmount.add(transaction.getDebit());
					}

					output.append(String.format("               %tD          %-50s    %8.2f\n",
							transaction.getTimestamp(),
							transaction.getDescription(),
							transaction.getTransactionAmount()));
				}

				output.append(String.format("%80s %14.2f\n", "Total Debit:" , debitAmount));
				output.append(String.format("%81s %13.2f\n", "Total Credit:", creditAmount));
				output.append(String.format("%76s %18.2f\n\n", "Balance:", account.getBalance()));
			}
		}
	}

	private void formatHeader(Statement statement, StringBuilder output) {
		Customer customer = statement.getCustomer();

		String customerName = String.format("\n%s %s", customer.getFirstName(), customer.getLastName());
		output.append(customerName + ADDRESS_LINE_ONE.substring(customerName.length()));

		output.append(customer.getAddress1() + ADDRESS_LINE_TWO.substring(customer.getAddress1().length()));

		String addressString = String.format("%s, %s %s", customer.getCity(), customer.getState(), customer.getPostalCode());
		output.append(addressString + ADDRESS_LINE_THREE.substring(addressString.length()));
	}
}