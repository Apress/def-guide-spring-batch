package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JdbcPagingJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public JdbcPagingItemReader<Customer> customerItemReader(DataSource dataSource,
//			PagingQueryProvider queryProvider,
//			@Value("#{jobParameters['city']}") String city) {
//
//		Map<String, Object> parameterValues = new HashMap<>(1);
//		parameterValues.put("city", city);
//
//		return new JdbcPagingItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.dataSource(dataSource)
//				.queryProvider(queryProvider)
//				.parameterValues(parameterValues)
//				.pageSize(10)
//				.rowMapper(new CustomerRowMapper())
//				.build();
//	}
//
//	@Bean
//	public SqlPagingQueryProviderFactoryBean pagingQueryProvider(DataSource dataSource) {
//		SqlPagingQueryProviderFactoryBean factoryBean = new SqlPagingQueryProviderFactoryBean();
//
//		factoryBean.setDataSource(dataSource);
//		factoryBean.setSelectClause("select *");
//		factoryBean.setFromClause("from Customer");
//		factoryBean.setWhereClause("where city = :city");
//		factoryBean.setSortKey("lastName");
//
//		return factoryBean;
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
//				.reader(customerItemReader(null, null, null))
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
//		SpringApplication.run(JdbcPagingJob.class, "city=Chicago");
//	}

}

