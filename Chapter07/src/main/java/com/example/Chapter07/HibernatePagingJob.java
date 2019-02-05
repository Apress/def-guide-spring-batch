package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class HibernatePagingJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public HibernatePagingItemReader<Customer> customerItemReader(
//			EntityManagerFactory entityManagerFactory,
//			@Value("#{jobParameters['city']}") String city) {
//
//		return new HibernatePagingItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.sessionFactory(entityManagerFactory.unwrap(SessionFactory.class))
//				.queryString("from Customer where city = :city")
//				.parameterValues(Collections.singletonMap("city", city))
//				.pageSize(10)
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
//		SpringApplication.run(HibernatePagingJob.class, "city=Chicago");
//	}

}

