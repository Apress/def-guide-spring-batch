package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class StoredProcedureJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public StoredProcedureItemReader<Customer> customerItemReader(DataSource dataSource,
//			@Value("#{jobParameters['city']}") String city) {
//
//		return new StoredProcedureItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.dataSource(dataSource)
//				.procedureName("customer_list")
//				.parameters(new SqlParameter[]{new SqlParameter("cityOption", Types.VARCHAR)})
//				.preparedStatementSetter(new ArgumentPreparedStatementSetter(new Object[] {city}))
//				.rowMapper(new CustomerRowMapper())
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
//		SpringApplication.run(StoredProcedureJob.class, "city=Chicago");
//	}

}

