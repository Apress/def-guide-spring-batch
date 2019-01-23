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

import javax.sql.DataSource;

import com.apress.batch.chapter9.domain.Customer;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcBatchItemWriterBuilder;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.mail.SimpleMailMessageItemWriter;
import org.springframework.batch.item.mail.builder.SimpleMailMessageItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

/**
 * @author Michael Minella
 */
@Configuration
public class EmailSendingJob {

	private JobBuilderFactory jobBuilderFactory;

	private StepBuilderFactory stepBuilderFactory;

	public EmailSendingJob(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) {

		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	@StepScope
	public FlatFileItemReader<Customer> customerEmailFileReader(
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
						"zip",
						"email"})
				.targetType(Customer.class)
				.build();
	}

	@Bean
	public JdbcBatchItemWriter<Customer> customerBatchWriter(DataSource dataSource) {

		return new JdbcBatchItemWriterBuilder<Customer>()
				.namedParametersJdbcTemplate(new NamedParameterJdbcTemplate(dataSource))
				.sql("INSERT INTO CUSTOMER (first_name, middle_initial, last_name, address, city, state, zip, email) " +
						"VALUES(:firstName, :middleInitial, :lastName, :address, :city, :state, :zip, :email)")
				.beanMapped()
				.build();
	}

	@Bean
	public JdbcCursorItemReader<Customer> customerCursorItemReader(DataSource dataSource) {

		return new JdbcCursorItemReaderBuilder<Customer>()
				.name("customerItemReader")
				.dataSource(dataSource)
				.sql("select * from customer")
				.rowMapper(new BeanPropertyRowMapper<>(Customer.class))
				.build();
	}

	@Bean
	public SimpleMailMessageItemWriter emailItemWriter(MailSender mailSender) {

		return new SimpleMailMessageItemWriterBuilder()
				.mailSender(mailSender)
				.build();
	}

	@Bean
	public Step importStep() throws Exception {
		return this.stepBuilderFactory.get("importStep")
				.<Customer, Customer>chunk(10)
				.reader(customerEmailFileReader(null))
				.writer(customerBatchWriter(null))
				.build();
	}

	@Bean
	public Step emailStep() throws Exception {
		return this.stepBuilderFactory.get("emailStep")
				.<Customer, SimpleMailMessage>chunk(10)
				.reader(customerCursorItemReader(null))
				.processor((ItemProcessor<Customer, SimpleMailMessage>) customer -> {
					SimpleMailMessage mail = new SimpleMailMessage();

					mail.setFrom("prospringbatch@gmail.com");
					mail.setTo(customer.getEmail());
					mail.setSubject("Welcome!");
					mail.setText(String.format("Welcome %s %s,\nYou were imported into the system using Spring Batch!",
							customer.getFirstName(), customer.getLastName()));

					return mail;
				})
				.writer(emailItemWriter(null))
				.build();
	}

	@Bean
	public Job emailJob() throws Exception {
		return this.jobBuilderFactory.get("emailJob")
				.start(importStep())
				.next(emailStep())
				.build();
	}
}
