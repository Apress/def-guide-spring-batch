package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.neo4j.Neo4jProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

/**
 * To load the data for this job into MongoDB, unzip the zip file src/main/resources/input/tweets.zip.  Then execute
 * the following command:
 * <code>mongorestore -d tweets -c tweets_collection &lt;PATH_TO_UNZIPED_DIR&gt;/dump\ 2/twitter/tweets.bson</code>
 */
@EnableBatchProcessing
@EnableConfigurationProperties(Neo4jProperties.class)
@SpringBootApplication
public class Neo4jJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	public SessionFactory sessionFactory(org.neo4j.ogm.config.Configuration configuration,
//			ObjectProvider<EventListener> eventListeners) {
//		SessionFactory sessionFactory = new SessionFactory(configuration,
//				"com.example.Chapter07.domain");
//		eventListeners.stream().forEach(sessionFactory::register);
//		return sessionFactory;
//	}
//
//	@Bean
//	public org.neo4j.ogm.config.Configuration configuration(Neo4jProperties properties) {
//		return properties.createConfiguration();
//	}
//
//	@Bean
//	public Neo4jItemReader<Map> catagoriesBySupplierItemReader(SessionFactory sessionFactory) {
//		return new Neo4jItemReaderBuilder<Map>()
//				.name("catagoriesBySupplierItemReader")
//				.startStatement("n=node(*)")
//				.matchStatement("(s:Supplier)-->(:Product)-->(c:Category)")
////				.returnStatement("s.companyName, collect(distinct c.categoryName) as categories")
//				.returnStatement("s.companyName, c.categoryName")
////				.returnStatement("s.companyName")
//				.orderByStatement("s.companyName")
//				.parameterValues(Collections.emptyMap())
//				.pageSize(10)
////				.targetType(Company.class)
//				.targetType(Map.class)
////				.targetType(String.class)
//				.sessionFactory(sessionFactory)
//				.build();
//	}
//
//	@Bean
//	public ItemWriter<Map> itemWriter() {
//		return (items) -> items.forEach(System.out::println);
//	}
//
//	@Bean
//	public Step copyFileStep() {
//		return this.stepBuilderFactory.get("copyFileStep")
//				.<Map, Map>chunk(10)
//				.reader(catagoriesBySupplierItemReader(null))
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
//		SpringApplication.run(Neo4jJob.class, args);
//	}

}

