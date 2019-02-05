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

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.example.Chapter07.domain.Customer;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamSupport;

/**
 * @author Michael Minella
 */
public class CustomerItemReader extends ItemStreamSupport implements ItemReader<Customer> {

	private List<Customer> customers;
	private int curIndex;
	private String INDEX_KEY = "current.index.customers";

	private String [] firstNames = {"Michael", "Warren", "Ann", "Terrence",
			"Erica", "Laura", "Steve", "Larry"};
	private String middleInitial = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	private String [] lastNames = {"Gates", "Darrow", "Donnelly", "Jobs",
			"Buffett", "Ellison", "Obama"};
	private String [] streets = {"4th Street", "Wall Street", "Fifth Avenue",
			"Mt. Lee Drive", "Jeopardy Lane",
			"Infinite Loop Drive", "Farnam Street",
			"Isabella Ave", "S. Greenwood Ave"};
	private String [] cities = {"Chicago", "New York", "Hollywood", "Aurora",
			"Omaha", "Atherton"};
	private String [] states = {"IL", "NY", "CA", "NE"};

	private Random generator = new Random();

	public CustomerItemReader() {
		curIndex = 0;

		customers = new ArrayList<>();

		for(int i = 0; i < 100; i++) {
			customers.add(buildCustomer());
		}
	}

	private Customer buildCustomer() {
		Customer customer = new Customer();

		customer.setId((long) generator.nextInt(Integer.MAX_VALUE));
		customer.setFirstName(
				firstNames[generator.nextInt(firstNames.length - 1)]);
		customer.setMiddleInitial(
				String.valueOf(middleInitial.charAt(
						generator.nextInt(middleInitial.length() - 1))));
		customer.setLastName(
				lastNames[generator.nextInt(lastNames.length - 1)]);
		customer.setAddress(generator.nextInt(9999) + " " +
				streets[generator.nextInt(streets.length - 1)]);
		customer.setCity(cities[generator.nextInt(cities.length - 1)]);
		customer.setState(states[generator.nextInt(states.length - 1)]);
		customer.setZipCode(String.valueOf(generator.nextInt(99999)));

		return customer;
	}

	@Override
	public Customer read() {
		Customer cust = null;

		if(curIndex == 50) {
			throw new RuntimeException("This will end your execution");
		}

		if(curIndex < customers.size()) {
			cust = customers.get(curIndex);
			curIndex++;
		}

		return cust;
	}

	public void close() throws ItemStreamException {
	}

	public void open(ExecutionContext executionContext) throws ItemStreamException {
		if(executionContext.containsKey(getExecutionContextKey(INDEX_KEY))) {
			int index = executionContext.getInt(getExecutionContextKey(INDEX_KEY));

			if(index == 50) {
				curIndex = 51;
			} else {
				curIndex = index;
			}
		} else {
			curIndex = 0;
		}
	}

	public void update(ExecutionContext executionContext) throws ItemStreamException {
		executionContext.putInt(getExecutionContextKey(INDEX_KEY), curIndex);
	}
}
