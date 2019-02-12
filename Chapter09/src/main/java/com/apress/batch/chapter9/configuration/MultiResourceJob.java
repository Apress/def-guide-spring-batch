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
public class MultiResourceJob {
//
//	private JobBuilderFactory jobBuilderFactory;
//
//	private StepBuilderFactory stepBuilderFactory;
//
//	public MultiResourceJob(JobBuilderFactory jobBuilderFactory,
//			StepBuilderFactory stepBuilderFactory) {
//
//		this.jobBuilderFactory = jobBuilderFactory;
//		this.stepBuilderFactory = stepBuilderFactory;
//	}
//
//	@Bean
//	public JdbcCursorItemReader<Customer> customerJdbcCursorItemReader(DataSource dataSource) {
//
//		return new JdbcCursorItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.dataSource(dataSource)
//				.sql("select * from customer")
//				.rowMapper(new BeanPropertyRowMapper<>(Customer.class))
//				.build();
//	}
//
//	@Bean
//	public MultiResourceItemWriter<Customer> multiCustomerFileWriter(CustomerOutputFileSuffixCreator suffixCreator) throws Exception {
//
//		return new MultiResourceItemWriterBuilder<Customer>()
//				.name("multiCustomerFileWriter")
//				.delegate(delegateItemWriter(null))
//				.itemCountLimitPerResource(25)
//				.resource(new FileSystemResource("Chapter09/target/customer"))
//				.resourceSuffixCreator(suffixCreator)
//				.build();
//	}
//
//	@Bean
//	@StepScope
//	public StaxEventItemWriter<Customer> delegateItemWriter(CustomerXmlHeaderCallback headerCallback) throws Exception {
//
//		Map<String, Class> aliases = new HashMap<>();
//		aliases.put("customer", Customer.class);
//
//		XStreamMarshaller marshaller = new XStreamMarshaller();
//
//		marshaller.setAliases(aliases);
//
//		marshaller.afterPropertiesSet();
//
//		return new StaxEventItemWriterBuilder<Customer>()
//				.name("customerItemWriter")
//				.marshaller(marshaller)
//				.rootTagName("customers")
//				.headerCallback(headerCallback)
//				.build();
//	}
//
//	@Bean
//	public Step multiXmlGeneratorStep() throws Exception {
//		return this.stepBuilderFactory.get("multiXmlGeneratorStep")
//				.<Customer, Customer>chunk(10)
//				.reader(customerJdbcCursorItemReader(null))
//				.writer(multiCustomerFileWriter(null))
//				.build();
//	}
//
//	@Bean
//	public Job xmlGeneratorJob() throws Exception {
//		return this.jobBuilderFactory.get("xmlGeneratorJob")
//				.start(multiXmlGeneratorStep())
//				.build();
//	}
}
