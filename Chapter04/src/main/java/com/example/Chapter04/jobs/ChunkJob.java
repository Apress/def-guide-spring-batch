/**
 * Copyright 2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.Chapter04.jobs;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.policy.CompositeCompletionPolicy;
import org.springframework.batch.repeat.policy.SimpleCompletionPolicy;
import org.springframework.batch.repeat.policy.TimeoutTerminationPolicy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import com.example.Chapter04.batch.LoggingStepStartStopListener;
import com.example.Chapter04.batch.RandomChunkSizePolicy;

/**
 * @author Michael Minella
 */
@EnableBatchProcessing
@SpringBootApplication
public class ChunkJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Job chunkBasedJob() {
		return this.jobBuilderFactory.get("chunkBasedJob")
				.start(chunkStep())
				.build();
	}

	@Bean
	public Step chunkStep() {
		return this.stepBuilderFactory.get("chunkStep")
//				.<String, String>chunk(1000)
				.<String, String>chunk(randomCompletionPolicy())
				.reader(itemReader())
				.writer(itemWriter())
				.listener(new LoggingStepStartStopListener())
				.taskExecutor(taskExecutor(0))
				.build();
	}

	@Bean
	@StepScope
	public TaskExecutor taskExecutor(@Value("#{jobParameters['poolSize']}") int poolSize) {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(poolSize);
		executor.setMaxPoolSize(poolSize);
		return executor;
	}

	@Bean
	public ListItemReader<String> itemReader() {
		List<String> items = new ArrayList<>(100000);

		for (int i = 0; i < 100000; i++) {
			items.add(UUID.randomUUID().toString());
		}

		return new ListItemReader<>(items);
	}

	@Bean
	public ItemWriter<String> itemWriter() {
		return items -> {
			for (String item : items) {
				System.out.println(">> current item = " + item);
			}
		};
	}

	@Bean
	public CompletionPolicy completionPolicy() {
		CompositeCompletionPolicy policy =
				new CompositeCompletionPolicy();

		policy.setPolicies(
				new CompletionPolicy[] {
						new TimeoutTerminationPolicy(3),
						new SimpleCompletionPolicy(1000)});

		return policy;
	}

	@Bean
	public CompletionPolicy randomCompletionPolicy() {
		return new RandomChunkSizePolicy();
	}

	public static void main(String[] args) {
		SpringApplication.run(ChunkJob.class, new String[] { "poolSize=null" });
	}
}
