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
package com.example.Chapter08.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamSupport;
import org.springframework.batch.item.validator.ValidationException;
import org.springframework.batch.item.validator.Validator;

/**
 * @author Michael Minella
 */
public class UniqueLastNameValidator extends ItemStreamSupport implements Validator<Customer> {

	private Set<String> lastNames = new HashSet<>();

	@Override
	public void validate(Customer value) throws ValidationException {
		if(lastNames.contains(value.getLastName())) {
			throw new ValidationException("Duplicate last name was found: " + value.getLastName());
		}

		this.lastNames.add(value.getLastName());
	}

	@Override
	public void update(ExecutionContext executionContext) {
		executionContext.put(getExecutionContextKey("lastNames"), this.lastNames);
	}

	@Override
	public void open(ExecutionContext executionContext) {
		String lastNames = getExecutionContextKey("lastNames");

		if(executionContext.containsKey(lastNames)) {
			this.lastNames = (Set<String>) executionContext.get(lastNames);
		}
	}
}
