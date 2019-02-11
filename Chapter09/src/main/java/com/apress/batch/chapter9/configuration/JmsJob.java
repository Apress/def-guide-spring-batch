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
public class JmsJob {
//
//	private JobBuilderFactory jobBuilderFactory;
//
//	private StepBuilderFactory stepBuilderFactory;
//
//	public JmsJob(JobBuilderFactory jobBuilderFactory,
//			StepBuilderFactory stepBuilderFactory) {
//
//		this.jobBuilderFactory = jobBuilderFactory;
//		this.stepBuilderFactory = stepBuilderFactory;
//	}
//
//	@Bean // Serialize message content to json using TextMessage
//	public MessageConverter jacksonJmsMessageConverter() {
//		MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
//		converter.setTargetType(MessageType.TEXT);
//		converter.setTypeIdPropertyName("_type");
//		return converter;
//	}
//
//	@Bean
//	public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory) {
//		CachingConnectionFactory cachingConnectionFactory = new CachingConnectionFactory(connectionFactory);
//		cachingConnectionFactory.afterPropertiesSet();
//
//		JmsTemplate jmsTemplate = new JmsTemplate(cachingConnectionFactory);
//		jmsTemplate.setDefaultDestinationName("customers");
//		jmsTemplate.setReceiveTimeout(5000L);
//
//		return jmsTemplate;
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
//	@StepScope
//	public StaxEventItemWriter<Customer> xmlOutputWriter(
//			@Value("#{jobParameters['outputFile']}") Resource outputFile) {
//
//		Map<String, Class> aliases = new HashMap<>();
//		aliases.put("customer", Customer.class);
//
//		XStreamMarshaller marshaller = new XStreamMarshaller();
//		marshaller.setAliases(aliases);
//
//		return new StaxEventItemWriterBuilder<Customer>()
//				.name("xmlOutputWriter")
//				.resource(outputFile)
//				.marshaller(marshaller)
//				.rootTagName("customers")
//				.build();
//	}
//
//	@Bean
//	public JmsItemReader<Customer> jmsItemReader(JmsTemplate jmsTemplate) {
//
//		return new JmsItemReaderBuilder<Customer>()
//				.jmsTemplate(jmsTemplate)
//				.itemType(Customer.class)
//				.build();
//	}
//
//	@Bean
//	public JmsItemWriter<Customer> jmsItemWriter(JmsTemplate jmsTemplate) {
//
//		return new JmsItemWriterBuilder<Customer>()
//				.jmsTemplate(jmsTemplate)
//				.build();
//	}
//
//	@Bean
//	public Step formatInputStep() throws Exception {
//		return this.stepBuilderFactory.get("formatInputStep")
//				.<Customer, Customer>chunk(10)
//				.reader(customerFileReader(null))
//				.writer(jmsItemWriter(null))
//				.build();
//	}
//
//	@Bean
//	public Step formatOutputStep() throws Exception {
//		return this.stepBuilderFactory.get("formatOutputStep")
//				.<Customer, Customer>chunk(10)
//				.reader(jmsItemReader(null))
//				.writer(xmlOutputWriter(null))
//				.build();
//	}
//
//	@Bean
//	public Job jmsFormatJob() throws Exception {
//		return this.jobBuilderFactory.get("jmsFormatJob")
//				.start(formatInputStep())
//				.next(formatOutputStep())
//				.build();
//	}
}
