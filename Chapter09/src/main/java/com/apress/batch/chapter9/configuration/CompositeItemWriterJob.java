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
public class CompositeItemWriterJob {
//
//	private JobBuilderFactory jobBuilderFactory;
//
//	private StepBuilderFactory stepBuilderFactory;
//
//	public CompositeItemWriterJob(JobBuilderFactory jobBuilderFactory,
//			StepBuilderFactory stepBuilderFactory) {
//
//		this.jobBuilderFactory = jobBuilderFactory;
//		this.stepBuilderFactory = stepBuilderFactory;
//	}
//
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> compositewriterItemReader(
//			@Value("#{jobParameters['customerFile']}")Resource inputFile) {
//
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("compositewriterItemReader")
//				.resource(inputFile)
//				.delimited()
//				.names(new String[] {"firstName",
//						"middleInitial",
//						"lastName",
//						"address",
//						"city",
//						"state",
//						"zip",
//						"email"})
//				.targetType(Customer.class)
//				.build();
//	}
//
//	@Bean
//	@StepScope
//	public StaxEventItemWriter<Customer> xmlDelegateItemWriter(
//			@Value("#{jobParameters['outputFile']}") Resource outputFile) throws Exception {
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
//				.resource(outputFile)
//				.marshaller(marshaller)
//				.rootTagName("customers")
//				.build();
//	}
//
//	@Bean
//	public JdbcBatchItemWriter<Customer> jdbcDelgateItemWriter(DataSource dataSource) {
//
//		return new JdbcBatchItemWriterBuilder<Customer>()
//				.namedParametersJdbcTemplate(new NamedParameterJdbcTemplate(dataSource))
//				.sql("INSERT INTO CUSTOMER (first_name, " +
//						"middle_initial, " +
//						"last_name, " +
//						"address, " +
//						"city, " +
//						"state, " +
//						"zip, " +
//						"email) " +
//						"VALUES(:firstName, " +
//						":middleInitial, " +
//						":lastName, " +
//						":address, " +
//						":city, " +
//						":state, " +
//						":zip, " +
//						":email)")
//				.beanMapped()
//				.build();
//	}
//
//	@Bean
//	public CompositeItemWriter<Customer> compositeItemWriter() throws Exception {
//		return new CompositeItemWriterBuilder<Customer>()
//				.delegates(Arrays.asList(xmlDelegateItemWriter(null),
//						jdbcDelgateItemWriter(null)))
//				.build();
//	}
//
//
//	@Bean
//	public Step compositeWriterStep() throws Exception {
//		return this.stepBuilderFactory.get("compositeWriterStep")
//				.<Customer, Customer>chunk(10)
//				.reader(compositewriterItemReader(null))
//				.writer(compositeItemWriter())
//				.build();
//	}
//
//	@Bean
//	public Job compositeWriterJob() throws Exception {
//		return this.jobBuilderFactory.get("compositeWriterJob")
//				.start(compositeWriterStep())
//				.build();
//	}
}
