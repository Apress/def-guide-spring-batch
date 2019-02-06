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
package com.example.Chapter08.batch;

import com.example.Chapter08.domain.Customer;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.classify.Classifier;

/**
 * @author Michael Minella
 */
public class ZipCodeClassifier implements Classifier<Customer, ItemProcessor<Customer, Customer>> {

	private ItemProcessor<Customer, Customer> oddItemProcessor;
	private ItemProcessor<Customer, Customer> evenItemProcessor;

	public ZipCodeClassifier(ItemProcessor<Customer, Customer> oddItemProcessor,
			ItemProcessor<Customer, Customer> evenItemProcessor) {

		this.oddItemProcessor = oddItemProcessor;
		this.evenItemProcessor = evenItemProcessor;
	}

	@Override
	public ItemProcessor<Customer, Customer> classify(Customer classifiable) {
		if(Integer.parseInt(classifiable.getZip()) % 2 == 0) {
			return evenItemProcessor;
		}
		else {
			return oddItemProcessor;
		}
	}
}
