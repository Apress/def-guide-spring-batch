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

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

/**
 * @author Michael Minella
 */
public class AccountResultSetExtractor implements ResultSetExtractor<List<Account>> {

	private List<Account> accounts = new ArrayList<>();
	private Account curAccount;

	@Nullable
	@Override
	public List<Account> extractData(ResultSet rs) throws SQLException, DataAccessException {

		while (rs.next()) {
			if(curAccount == null) {
				curAccount = new Account(
						rs.getLong("account_id"),
						rs.getBigDecimal("balance"),
						rs.getDate("last_statement_date"));
			}
			else if (rs.getLong("account_id") != curAccount.getId()) {
				accounts.add(curAccount);

				curAccount = new Account(rs.getLong("account_id"),
						rs.getBigDecimal("balance"),
						rs.getDate("last_statement_date"));
			}

			if(StringUtils.hasText(rs.getString("description"))) {
				curAccount.addTransaction(
						new Transaction(rs.getLong("transaction_id"),
								rs.getLong("account_id"),
								rs.getString("description"),
								rs.getBigDecimal("credit"),
								rs.getBigDecimal("debit"),
								new Date(rs.getTimestamp("timestamp").getTime())));
			}
		}

		if(curAccount != null) {
			accounts.add(curAccount);
		}

		return accounts;
	}
}
