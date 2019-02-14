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
package com.example.Chapter13.batch;

import javax.sql.DataSource;

import com.example.Chapter13.domain.CustomerUpdate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author Michael Minella
 */
@ExtendWith(SpringExtension.class)
@JdbcTest
public class CustomerItemValidatorIntegrationTests {

	@Autowired
	private DataSource dataSource;

	private CustomerItemValidator customerItemValidator;

	@BeforeEach
	public void setUp() {
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(this.dataSource);
		this.customerItemValidator = new CustomerItemValidator(template);
	}

	@Test
	public void testNoCustomers() {
		CustomerUpdate customerUpdate = new CustomerUpdate(-5L);

		ValidationException exception =
				assertThrows(ValidationException.class,
						() -> this.customerItemValidator.validate(customerUpdate));

		assertEquals("Customer id -5 was not able to be found",
				exception.getMessage());

	}

	@Test
	public void testCustomers() {
		CustomerUpdate customerUpdate = new CustomerUpdate(5L);
		this.customerItemValidator.validate(customerUpdate);
	}
}
