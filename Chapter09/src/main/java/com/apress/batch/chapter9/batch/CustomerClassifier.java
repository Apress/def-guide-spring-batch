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
package com.apress.batch.chapter9.batch;

import com.apress.batch.chapter9.domain.Customer;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.classify.Classifier;

/**
 * @author Michael Minella
 */
public class CustomerClassifier implements
		Classifier<Customer, ItemWriter<? super Customer>> {

	private ItemWriter<Customer> fileItemWriter;
	private ItemWriter<Customer> jdbcItemWriter;

	public CustomerClassifier(StaxEventItemWriter<Customer> fileItemWriter, JdbcBatchItemWriter<Customer> jdbcItemWriter) {
		this.fileItemWriter = fileItemWriter;
		this.jdbcItemWriter = jdbcItemWriter;
	}

	@Override
	public ItemWriter<Customer> classify(Customer customer) {
		if(customer.getState().matches("^[A-M].*")) {
			return fileItemWriter;
		} else {
			return jdbcItemWriter;
		}
	}
}
