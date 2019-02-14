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

import java.util.Map;

import com.example.Chapter13.domain.CustomerUpdate;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import org.springframework.batch.item.validator.ValidationException;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import static org.mockito.Mockito.eq;
import static org.mockito.Mockito.when;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Michael Minella
 */
public class CustomerItemValidatorTests {

	@Mock
	private NamedParameterJdbcTemplate template;

	private CustomerItemValidator validator;

	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		this.validator = new CustomerItemValidator(this.template);
	}

	@Test
	public void testValidCustomer() {

		// given

		CustomerUpdate customer = new CustomerUpdate(5L);

		// when
		ArgumentCaptor<Map<String, Long>> parameterMap =
				ArgumentCaptor.forClass(Map.class);
		when(this.template.queryForObject(eq(CustomerItemValidator.FIND_CUSTOMER),
				parameterMap.capture(),
				eq(Long.class)))
				.thenReturn(2L);

		this.validator.validate(customer);

		// then

		assertEquals(5L, (long) parameterMap.getValue().get("id"));
	}

	@Test
	public void testInvalidCustomer() {

		// given

		CustomerUpdate customerUpdate = new CustomerUpdate(5L);

		// when
		ArgumentCaptor<Map<String, Long>> parameterMap =
				ArgumentCaptor.forClass(Map.class);
		when(this.template.queryForObject(eq(CustomerItemValidator.FIND_CUSTOMER),
				parameterMap.capture(),
				eq(Long.class)))
				.thenReturn(0L);

		Throwable exception = assertThrows(ValidationException.class,
				() -> this.validator.validate(customerUpdate));

		// then

		assertEquals("Customer id 5 was not able to be found",
				exception.getMessage());
	}
}
