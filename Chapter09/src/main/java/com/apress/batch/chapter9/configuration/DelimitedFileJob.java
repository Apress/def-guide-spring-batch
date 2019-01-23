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

import com.apress.batch.chapter9.domain.Customer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.transform.BeanWrapperFieldExtractor;
import org.springframework.batch.item.file.transform.DelimitedLineAggregator;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

/**
 * @author Michael Minella
 */
@Configuration
public class DelimitedFileJob {

	private JobBuilderFactory jobBuilderFactory;

	private StepBuilderFactory stepBuilderFactory;

	public DelimitedFileJob(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) {

		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	@StepScope
	public FlatFileItemReader<Customer> customerFileReader(
			@Value("#{jobParameters['customerFile']}")Resource inputFile) {

		return new FlatFileItemReaderBuilder<Customer>()
				.name("customerFileReader")
				.resource(inputFile)
				.delimited()
				.names(new String[] {"firstName",
						"middleInitial",
						"lastName",
						"address",
						"city",
						"state",
						"zip"})
				.targetType(Customer.class)
				.build();
	}

	@Bean
	@StepScope
	public FlatFileItemWriter<Customer> delimitedCustomerItemWriter(
			@Value("#{jobParameters['outputFile']}") Resource outputFile) {

		BeanWrapperFieldExtractor<Customer> fieldExtractor = new BeanWrapperFieldExtractor<>();

		fieldExtractor.setNames(new String[] {"zip", "state", "city", "address", "lastName", "firstName"});

		fieldExtractor.afterPropertiesSet();

		DelimitedLineAggregator<Customer> lineAggregator = new DelimitedLineAggregator<>();

		lineAggregator.setFieldExtractor(fieldExtractor);
		lineAggregator.setDelimiter(";");

		return new FlatFileItemWriterBuilder<Customer>()
				.name("customerItemWriter")
				.resource(outputFile)
				.lineAggregator(lineAggregator)
				.append(true)
				.build();
	}

	@Bean
	public Step delimitedStep() {
		return this.stepBuilderFactory.get("delimitedStep")
				.<Customer, Customer>chunk(10)
				.reader(customerFileReader(null))
				.writer(delimitedCustomerItemWriter(null))
				.build();
	}

	@Bean
	public Job delimitedJob() {
		return this.jobBuilderFactory.get("delimitedJob")
				.start(delimitedStep())
				.build();
	}
}
