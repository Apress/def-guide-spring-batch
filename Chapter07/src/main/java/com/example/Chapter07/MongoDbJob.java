package com.example.Chapter07;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * To load the data for this job into MongoDB, unzip the zip file src/main/resources/input/tweets.zip.  Then execute
 * the following command:
 * <code>mongorestore -d tweets -c tweets_collection &lt;PATH_TO_UNZIPED_DIR&gt;/dump\ 2/twitter/tweets.bson</code>
 */
@EnableBatchProcessing
@SpringBootApplication
public class MongoDbJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	@StepScope
//	public MongoItemReader<Map> tweetsItemReader(MongoOperations mongoTemplate,
//			@Value("#{jobParameters['hashTag']}") String hashtag) {
//		return new MongoItemReaderBuilder<Map>()
//				.name("tweetsItemReader")
//				.targetType(Map.class)
//				.jsonQuery("{ \"entities.hashtags.text\": { $eq: ?0 }}")
//				.collection("tweets_collection")
//				.parameterValues(Collections.singletonList(hashtag))
//				.pageSize(10)
//				.sorts(Collections.singletonMap("created_at", Sort.Direction.ASC))
//				.template(mongoTemplate)
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
//				.reader(tweetsItemReader(null, null))
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
//		SpringApplication.run(MongoDbJob.class, "hashTag=nodejs");
//	}

}

