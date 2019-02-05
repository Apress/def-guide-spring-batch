package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class JsonJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public JsonItemReader<Customer> customerFileReader(
//			@Value("#{jobParameters['customerFile']}") Resource inputFile) {
//
//		ObjectMapper objectMapper = new ObjectMapper();
//		objectMapper.setDateFormat(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss"));
//
//		JacksonJsonObjectReader<Customer> jsonObjectReader = new JacksonJsonObjectReader<>(Customer.class);
//		jsonObjectReader.setMapper(objectMapper);
//
//		return new JsonItemReaderBuilder<Customer>()
//				.name("customerFileReader")
//				.jsonObjectReader(jsonObjectReader)
//				.resource(inputFile)
//				.build();
//	}
//
//	@Bean
//	public ItemWriter itemWriter() {
//		return (items) -> items.forEach(System.out::println);
//	}
//
//	@Bean
//	public Step copyFileStep() {
//		return this.stepBuilderFactory.get("copyFileStep")
//				.<Customer, Customer>chunk(10)
//				.reader(customerFileReader(null))
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
//		List<String> realArgs = Collections.singletonList("customerFile=/input/customer.json");
//
//		SpringApplication.run(JsonJob.class, realArgs.toArray(new String[1]));
//	}

}

