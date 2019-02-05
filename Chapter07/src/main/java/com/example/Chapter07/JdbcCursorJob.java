package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JdbcCursorJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	public JdbcCursorItemReader<Customer> customerItemReader(DataSource dataSource) {
//		return new JdbcCursorItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.dataSource(dataSource)
//				.sql("select * from customer where city = ?")
//				.rowMapper(new CustomerRowMapper())
//				.preparedStatementSetter(citySetter(null))
//				.build();
//	}
//
//	@Bean
//	@StepScope
//	public ArgumentPreparedStatementSetter citySetter(
//			@Value("#{jobParameters['city']}") String city) {
//
//		return new ArgumentPreparedStatementSetter(new Object [] {city});
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
//				.reader(customerItemReader(null))
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
//		SpringApplication.run(JdbcCursorJob.class, "city=Chicago");
//	}

}

