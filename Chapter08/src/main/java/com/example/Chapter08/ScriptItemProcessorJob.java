package com.example.Chapter08;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class ScriptItemProcessorJob {
//
//
//	@Autowired
//	public JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	public StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerItemReader(
//			@Value("#{jobParameters['customerFile']}")Resource inputFile) {
//
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.delimited()
//				.names(new String[] {"firstName",
//						"middleInitial",
//						"lastName",
//						"address",
//						"city",
//						"state",
//						"zip"})
//				.targetType(Customer.class)
//				.resource(inputFile)
//				.build();
//	}
//
//	@Bean
//	public ItemWriter<Customer> itemWriter() {
//		return (items) -> items.forEach(System.out::println);
//	}
//
//	@Bean
//	@StepScope
//	public ScriptItemProcessor<Customer, Customer> itemProcessor(@Value("#{jobParameters['script']}") Resource script) {
//		ScriptItemProcessor<Customer, Customer> itemProcessor = new ScriptItemProcessor<>();
//
//		itemProcessor.setScript(script);
//
//		return itemProcessor;
//	}
//
//	@Bean
//	public Step copyFileStep() {
//
//		return this.stepBuilderFactory.get("copyFileStep")
//				.<Customer, Customer>chunk(5)
//				.reader(customerItemReader(null))
//				.processor(itemProcessor(null))
//				.writer(itemWriter())
//				.build();
//	}
//
//	@Bean
//	public Job job() throws Exception {
//
//		return this.jobBuilderFactory.get("job")
//				.start(copyFileStep())
//				.build();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ScriptItemProcessorJob.class, "customerFile=/input/customer.csv", "script=/upperCase.js");
//	}
}

