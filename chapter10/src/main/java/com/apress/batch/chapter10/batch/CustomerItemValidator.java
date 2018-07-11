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

import java.util.Collections;
import java.util.Map;
import javax.sql.DataSource;

import com.apress.batch.chapter10.domain.CustomerUpdate;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

/**
 * @author Michael Minella
 */
@Component
public class CustomerItemValidator implements Validator<CustomerUpdate> {

	private final NamedParameterJdbcTemplate jdbcTemplate;

	protected static final String FIND_CUSTOMER = "SELECT COUNT(*) FROM CUSTOMER WHERE customer_id = :id";

	protected CustomerItemValidator(NamedParameterJdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	public CustomerItemValidator(DataSource dataSource) {
		this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
	}

	@Override
	public void validate(CustomerUpdate customer) throws ValidationException {
		Map<String, Long> parameterMap = Collections.singletonMap("id", customer.getCustomerId());

		Long count = jdbcTemplate.queryForObject(FIND_CUSTOMER, parameterMap, Long.class);

		if(count != null && count == 0) {
			throw new ValidationException(String.format("Customer id %s was not able to be found", customer.getCustomerId() ));
		}
	}
}
