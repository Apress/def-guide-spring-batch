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
package com.apress.batch.chapter9.configuration;

import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Minella
 */
@Configuration
public class ItemWriterAdapterJob {
//
//	private JobBuilderFactory jobBuilderFactory;
//
//	private StepBuilderFactory stepBuilderFactory;
//
//	public ItemWriterAdapterJob(JobBuilderFactory jobBuilderFactory,
//			StepBuilderFactory stepBuilderFactory) {
//
//		this.jobBuilderFactory = jobBuilderFactory;
//		this.stepBuilderFactory = stepBuilderFactory;
//	}
//
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerFileReader(
//			@Value("#{jobParameters['customerFile']}")Resource inputFile) {
//
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerFileReader")
//				.resource(inputFile)
//				.delimited()
//				.names(new String[] {"firstName",
//						"middleInitial",
//						"lastName",
//						"address",
//						"city",
//						"state",
//						"zip"})
//				.targetType(Customer.class)
//				.build();
//	}
//
//	@Bean
//	public ItemWriterAdapter<Customer> itemWriter(CustomerService customerService) {
//		ItemWriterAdapter<Customer> customerItemWriterAdapter = new ItemWriterAdapter<>();
//
//		customerItemWriterAdapter.setTargetObject(customerService);
//		customerItemWriterAdapter.setTargetMethod("logCustomer");
//
//		return customerItemWriterAdapter;
//	}
//
//
//	@Bean
//	public Step formatStep() throws Exception {
//		return this.stepBuilderFactory.get("jpaFormatStep")
//				.<Customer, Customer>chunk(10)
//				.reader(customerFileReader(null))
//				.writer(itemWriter(null))
//				.build();
//	}
//
//	@Bean
//	public Job itemWriterAdapterFormatJob() throws Exception {
//		return this.jobBuilderFactory.get("itemWriterAdapterFormatJob")
//				.start(formatStep())
//				.build();
//	}
}
