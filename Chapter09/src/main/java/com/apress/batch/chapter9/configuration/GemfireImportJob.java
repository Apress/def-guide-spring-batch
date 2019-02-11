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
//@PeerCacheApplication(name = "AccessingDataGemFireApplication", logLevel = "info")
//@EnableEntityDefinedRegions(basePackageClasses = Customer.class,
//		clientRegionShortcut = ClientRegionShortcut.LOCAL)
public class GemfireImportJob {
//
//	private JobBuilderFactory jobBuilderFactory;
//
//	private StepBuilderFactory stepBuilderFactory;
//
//	public GemfireImportJob(JobBuilderFactory jobBuilderFactory,
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
//	public GemfireItemWriter<Long, Customer> gemfireItemWriter(GemfireTemplate gemfireTemplate) {
//		return new GemfireItemWriterBuilder<Long, Customer>()
//				.template(gemfireTemplate)
//				.itemKeyMapper(new SpELItemKeyMapper<>(
//						"firstName + middleInitial + lastName"))
//				.build();
//	}
//
//	@Bean
//	public Step gemfireFormatStep() throws Exception {
//		return this.stepBuilderFactory.get("gemfireFormatStep")
//				.<Customer, Customer>chunk(10)
//				.reader(customerFileReader(null))
//				.writer(gemfireItemWriter(null))
//				.build();
//	}
//
//	@Bean
//	public Job gemfireFormatJob() throws Exception {
//		return this.jobBuilderFactory.get("gemfireFormatJob")
//				.start(gemfireFormatStep())
//				.build();
//	}
//
////	@Bean
////	public Properties gemfireProperties() {
////		Properties gemfireProperties = new Properties();
////		gemfireProperties.setProperty("name","SpringDataGemFireApplication");
////		gemfireProperties.setProperty("mcast-port", "0");
////		gemfireProperties.setProperty("log-level", "config");
////		return gemfireProperties;
////	}
//
////	@Bean
////	public CacheFactoryBean gemfireCache(Properties gemfireProperties) {
////		CacheFactoryBean gemfireCache = new CacheFactoryBean();
////		gemfireCache.setClose(true);
////		gemfireCache.setProperties(gemfireProperties);
////		return gemfireCache;
////	}
//
//	@Bean(name="customer")
//	public Region<Long, Customer> getCustomer(final GemFireCache cache) throws Exception {
//		LocalRegionFactoryBean<Long, Customer> customerRegion = new LocalRegionFactoryBean<>();
//		customerRegion.setCache(cache);
//		customerRegion.setName("customer");
//		customerRegion.afterPropertiesSet();
//		Region<Long, Customer> object = customerRegion.getRegion();
//		return object;
//	}
//
//	@Bean
//	public GemfireTemplate gemfireTemplate() throws Exception {
//		return new GemfireTemplate(getCustomer(null));
//	}
//
//
//	@Bean
//	public CommandLineRunner validator(final GemfireTemplate gemfireTemplate) {
//		return args -> {
//			List<Object> customers = gemfireTemplate.find("select * from /customer").asList();
//
//			for (Object customer : customers) {
//				System.out.println(">> object: " + customer);
//			}
//		};
//	}

}
