/*
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
package com.example.Chapter13.batch;

import java.util.Arrays;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.batch.test.JobLauncherTestUtils;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author Michael Minella
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {JobTests.BatchConfiguration.class, BatchAutoConfiguration.class})
@SpringBatchTest
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class JobTests {

	@Autowired
	private JobLauncherTestUtils jobLauncherTestUtils;

	@Test
	public void test() throws Exception {
		JobExecution jobExecution =
				this.jobLauncherTestUtils.launchJob();

		assertEquals(BatchStatus.COMPLETED,
				jobExecution.getStatus());

		StepExecution stepExecution =
				jobExecution.getStepExecutions().iterator().next();

		assertEquals(BatchStatus.COMPLETED, stepExecution.getStatus());
		assertEquals(3, stepExecution.getReadCount());
		assertEquals(3, stepExecution.getWriteCount());
	}

	@Configuration
	@EnableBatchProcessing
	public static class BatchConfiguration {

		@Autowired
		private JobBuilderFactory jobBuilderFactory;

		@Autowired
		private StepBuilderFactory stepBuilderFactory;

		@Bean
		public ListItemReader<String> itemReader() {
			return new ListItemReader<>(Arrays.asList("foo", "bar", "baz"));
		}

		@Bean
		public ItemWriter<String> itemWriter() {
			return (list -> {
				list.forEach(System.out::println);
			});
		}

		@Bean
		public Step step1() {
			return this.stepBuilderFactory.get("step1")
					.<String, String>chunk(10)
					.reader(itemReader())
					.writer(itemWriter())
					.build();
		}

		@Bean
		public Job job() {
			return this.jobBuilderFactory.get("job")
					.start(step1())
					.build();
		}

		@Bean
		public DataSource dataSource() {
			return new EmbeddedDatabaseBuilder().build();
		}

	}
}
