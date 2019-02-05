package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JpaJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
////	@Bean
////	@StepScope
////	public JpaPagingItemReader<Customer> customerItemReader(
////			EntityManagerFactory entityManagerFactory,
////			@Value("#{jobParameters['city']}") String city) {
////
////		return new JpaPagingItemReaderBuilder<Customer>()
////				.name("customerItemReader")
////				.entityManagerFactory(entityManagerFactory)
////				.queryString("select c from Customer c where c.city = :city")
////				.parameterValues(Collections.singletonMap("city", city))
////				.build();
////	}
//
//	@Bean
//	@StepScope
//	public JpaPagingItemReader<Customer> customerItemReader(
//			EntityManagerFactory entityManagerFactory,
//			@Value("#{jobParameters['city']}") String city) {
//
//		CustomerByCityQueryProvider queryProvider =
//				new CustomerByCityQueryProvider();
//		queryProvider.setCityName(city);
//
//		return new JpaPagingItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.entityManagerFactory(entityManagerFactory)
//				.queryProvider(queryProvider)
//				.parameterValues(Collections.singletonMap("city", city))
//				.build();
//	}
//
//	@Bean
//	public ItemWriter<Customer> itemWriter() {
//		return (items) -> items.forEach(System.out::println);
//	}
//
//	@Bean
//	public Step copyFileStep() {
//		return this.stepBuilderFactory.get("copyFileStep")
//				.<Customer, Customer>chunk(10)
//				.reader(customerItemReader(null, null))
//				.writer(itemWriter())
//				.build();
//	}
//
//	@Bean
//	public Job job() {
//		return this.jobBuilderFactory.get("job")
//				.start(copyFileStep())
//				.build();
//	}
//
//
//	public static void main(String[] args) {
//
//		SpringApplication.run(JpaJob.class, "city=Chicago");
//	}

}

