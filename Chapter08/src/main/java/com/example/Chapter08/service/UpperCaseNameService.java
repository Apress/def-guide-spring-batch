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
package com.example.Chapter08.service;

import com.example.Chapter08.domain.Customer;

import org.springframework.stereotype.Service;

/**
 * @author Michael Minella
 */
@Service
public class UpperCaseNameService {

	public Customer upperCase(Customer customer) {
		Customer newCustomer = new Customer(customer);

		newCustomer.setFirstName(newCustomer.getFirstName().toUpperCase());
		newCustomer.setMiddleInitial(newCustomer.getMiddleInitial().toUpperCase());
		newCustomer.setLastName(newCustomer.getLastName().toUpperCase());

		return newCustomer;
	}

}
