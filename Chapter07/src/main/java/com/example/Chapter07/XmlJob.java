package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing
@SpringBootApplication
public class XmlJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public StaxEventItemReader<Customer> customerFileReader(
//			@Value("#{jobParameters['customerFile']}") Resource inputFile) {
//
//		return new StaxEventItemReaderBuilder<Customer>()
//				.name("customerFileReader")
//				.resource(inputFile)
//				.addFragmentRootElements("customer")
//				.unmarshaller(customerMarshaller())
//				.build();
//	}
//
//	@Bean
//	public Jaxb2Marshaller customerMarshaller() {
//		Jaxb2Marshaller jaxb2Marshaller = new Jaxb2Marshaller();
//
//		jaxb2Marshaller.setClassesToBeBound(Customer.class,
//				Transaction.class);
//
//		return jaxb2Marshaller;
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
//		List<String> realArgs = Collections.singletonList("customerFile=/input/customer.xml");
//
//		SpringApplication.run(XmlJob.class, realArgs.toArray(new String[1]));
//	}

}

