package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class FixedWidthJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerItemReader(
//			@Value("#{jobParameters['customerFile']}") Resource inputFile) {
//
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.resource(inputFile)
//				.fixedLength()
//				.columns(new Range[]{new Range(1,11), new Range(12, 12), new Range(13, 22),
//						new Range(23, 26), new Range(27,46), new Range(47,62), new Range(63,64),
//						new Range(65,69)})
//				.names(new String[] {"firstName", "middleInitial", "lastName",
//						"addressNumber", "street", "city", "state","zipCode"})
//				.targetType(Customer.class)
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
//		List<String> realArgs = Arrays.asList("customerFile=/input/customerFixedWidth.txt");
//
//		SpringApplication.run(FixedWidthJob.class, realArgs.toArray(new String[1]));
//	}

}

