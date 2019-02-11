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
package com.apress.batch.chapter10.batch;

import com.apress.batch.chapter10.domain.AccountResultSetExtractor;
import com.apress.batch.chapter10.domain.Statement;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Michael Minella
 */
@Component
public class AccountItemProcessor implements ItemProcessor<Statement, Statement> {

	@Autowired
	private final JdbcTemplate jdbcTemplate;

	public AccountItemProcessor(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Statement process(Statement item) throws Exception {

//		String memoryBuster = "memoryBuster";
//
//		for (int i = 0; i < 200; i++) {
//			memoryBuster += memoryBuster;
//		}

		item.setAccounts(this.jdbcTemplate.query("select a.account_id," +
				"       a.balance," +
				"       a.last_statement_date," +
				"       t.transaction_id," +
				"       t.description," +
				"       t.credit," +
				"       t.debit," +
				"       t.timestamp " +
				"from account a left join " +  //HSQLDB
				"    transaction t on a.account_id = t.account_account_id " +
//				"from account a left join " +  //MYSQL
//				"    transaction t on a.account_id = t.account_account_id " +
				"where a.account_id in " +
				"	(select account_account_id " +
				"	from customer_account " +
				"	where customer_customer_id = ?) " +
				"order by t.timestamp",
				new Object[] {item.getCustomer().getId()},
					new AccountResultSetExtractor()));

		return item;
	}
}
