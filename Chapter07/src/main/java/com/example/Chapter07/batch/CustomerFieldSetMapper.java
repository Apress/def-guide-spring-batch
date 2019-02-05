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
package com.example.Chapter07.batch;

import com.example.Chapter07.domain.Customer;

import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.transform.FieldSet;

/**
 * @author Michael Minella
 */
public class CustomerFieldSetMapper implements FieldSetMapper<Customer> {

	public Customer mapFieldSet(FieldSet fieldSet) {
		Customer customer = new Customer();

//		customer.setAddress(fieldSet.readString("addressNumber") +
//				" " + fieldSet.readString("street"));
		customer.setCity(fieldSet.readString("address"));
		customer.setCity(fieldSet.readString("city"));
		customer.setFirstName(fieldSet.readString("firstName"));
		customer.setLastName(fieldSet.readString("lastName"));
		customer.setMiddleInitial(fieldSet.readString("middleInitial"));
		customer.setState(fieldSet.readString("state"));
		customer.setZipCode(fieldSet.readString("zipCode"));

		return customer;
	}
}
