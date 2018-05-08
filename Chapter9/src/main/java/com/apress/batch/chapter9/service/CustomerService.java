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
package com.apress.batch.chapter9.service;

import com.apress.batch.chapter9.domain.Customer;

import org.springframework.stereotype.Service;

/**
 * @author Michael Minella
 */
@Service
public class CustomerService {

	public void logCustomer(Customer customer) {
		System.out.println(customer);
	}

	public void logCustomerAddress(String address,
			String city,
			String state,
			String zip) {
		System.out.println(
				String.format("I just saved the address:\n%s\n%s, %s\n%s",
						address,
						city,
						state,
						zip));
	}
}
