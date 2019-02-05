package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class DelimitedJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerItemReader(@Value("#{jobParameters['customerFile']}")Resource inputFile) {
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.delimited()
//				.names(new String[] {"firstName",
//						"middleInitial",
//						"lastName",
//						"addressNumber",
//						"street",
//						"city",
//						"state",
//						"zipCode"})
//				.fieldSetMapper(new CustomerFieldSetMapper())
//				.resource(inputFile)
//				.build();
//	}
//	@Bean
//	@StepScope
//	public FlatFileItemReader<Customer> customerItemReader(@Value("#{jobParameters['customerFile']}")Resource inputFile) {
//		return new FlatFileItemReaderBuilder<Customer>()
//				.name("customerItemReader")
//				.lineTokenizer(new CustomerFileLineTokenizer())
//				.fieldSetMapper(new CustomerFieldSetMapper())
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
//		List<String> realArgs = Arrays.asList("customerFile=/input/customer.csv");
//
//		SpringApplication.run(DelimitedJob.class, realArgs.toArray(new String[1]));
//	}

}


