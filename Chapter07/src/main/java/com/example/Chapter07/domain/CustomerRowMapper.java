/*
 * Copyright 2019 the original author or authors.
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
package com.example.Chapter07.domain;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

/**
 * @author Michael Minella
 */
public class CustomerRowMapper implements RowMapper<Customer> {

	@Override
	public Customer mapRow(ResultSet resultSet, int rowNumber) throws
			SQLException {
		Customer customer = new Customer();

		customer.setId(resultSet.getLong("id"));
		customer.setAddress(resultSet.getString("address"));
		customer.setCity(resultSet.getString("city"));
		customer.setFirstName(resultSet.getString("firstName"));
		customer.setLastName(resultSet.getString("lastName"));
		customer.setMiddleInitial(resultSet.getString("middleInitial"));
		customer.setState(resultSet.getString("state"));
		customer.setZipCode(resultSet.getString("zipCode"));

		return customer;
	}
}
