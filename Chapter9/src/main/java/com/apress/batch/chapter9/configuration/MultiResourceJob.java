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

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;

import com.apress.batch.chapter9.batch.CustomerOutputFileSuffixCreator;
import com.apress.batch.chapter9.batch.CustomerXmlHeaderCallback;
import com.apress.batch.chapter9.domain.Customer;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.batch.item.file.MultiResourceItemWriter;
import org.springframework.batch.item.file.builder.MultiResourceItemWriterBuilder;
import org.springframework.batch.item.xml.StaxEventItemWriter;
import org.springframework.batch.item.xml.builder.StaxEventItemWriterBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.oxm.xstream.XStreamMarshaller;

/**
 * @author Michael Minella
 */
@Configuration
public class MultiResourceJob {

	private JobBuilderFactory jobBuilderFactory;

	private StepBuilderFactory stepBuilderFactory;

	public MultiResourceJob(JobBuilderFactory jobBuilderFactory,
			StepBuilderFactory stepBuilderFactory) {

		this.jobBuilderFactory = jobBuilderFactory;
		this.stepBuilderFactory = stepBuilderFactory;
	}

	@Bean
	public JdbcCursorItemReader<Customer> customerJdbcCursorItemReader(DataSource dataSource) {

		return new JdbcCursorItemReaderBuilder<Customer>()
				.name("customerItemReader")
				.dataSource(dataSource)
				.sql("select * from customer")
				.rowMapper(new BeanPropertyRowMapper<>(Customer.class))
				.build();
	}

	@Bean
	public MultiResourceItemWriter<Customer> multiCustomerFileWriter(CustomerOutputFileSuffixCreator suffixCreator) throws Exception {

		return new MultiResourceItemWriterBuilder<Customer>()
				.name("multiCustomerFileWriter")
				.delegate(delegateItemWriter(null))
				.itemCountLimitPerResource(25)
				.resource(new FileSystemResource("Chapter9/target/customer"))
				.resourceSuffixCreator(suffixCreator)
				.build();
	}

	@Bean
	@StepScope
	public StaxEventItemWriter<Customer> delegateItemWriter(CustomerXmlHeaderCallback headerCallback) throws Exception {

		Map<String, Class> aliases = new HashMap<>();
		aliases.put("customer", Customer.class);

		XStreamMarshaller marshaller = new XStreamMarshaller();

		marshaller.setAliases(aliases);

		marshaller.afterPropertiesSet();

		return new StaxEventItemWriterBuilder<Customer>()
				.name("customerItemWriter")
				.marshaller(marshaller)
				.rootTagName("customers")
				.headerCallback(headerCallback)
				.build();
	}

	@Bean
	public Step multiXmlGeneratorStep() throws Exception {
		return this.stepBuilderFactory.get("multiXmlGeneratorStep")
				.<Customer, Customer>chunk(10)
				.reader(customerJdbcCursorItemReader(null))
				.writer(multiCustomerFileWriter(null))
				.build();
	}

	@Bean
	public Job xmlGeneratorJob() throws Exception {
		return this.jobBuilderFactory.get("xmlGeneratorJob")
				.start(multiXmlGeneratorStep())
				.build();
	}
}
