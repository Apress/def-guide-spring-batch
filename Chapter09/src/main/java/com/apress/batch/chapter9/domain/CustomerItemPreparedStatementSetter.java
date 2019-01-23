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
package com.apress.batch.chapter9.domain;

/**
 * @author Michael Minella
 */
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.springframework.batch.item.database.ItemPreparedStatementSetter;

public class CustomerItemPreparedStatementSetter implements
		ItemPreparedStatementSetter<Customer> {

	public void setValues(Customer customer, PreparedStatement ps)
			throws SQLException {

		ps.setString(1, customer.getFirstName());
		ps.setString(2, customer.getMiddleInitial());
		ps.setString(3, customer.getLastName());
		ps.setString(4, customer.getAddress());
		ps.setString(5, customer.getCity());
		ps.setString(6, customer.getState());
		ps.setString(7, customer.getZip());
	}
}
