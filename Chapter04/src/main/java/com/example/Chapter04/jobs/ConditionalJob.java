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

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Michael Minella
 */
@EnableBatchProcessing
@SpringBootApplication
public class ConditionalJob {
//
//	@Autowired
//	private JobBuilderFactory jobBuilderFactory;
//
//	@Autowired
//	private StepBuilderFactory stepBuilderFactory;
//
//	@Bean
//	public Tasklet passTasklet() {
//		return (contribution, chunkContext) -> {
////			return RepeatStatus.FINISHED;
//			throw new RuntimeException("Causing a failure");
//		};
//	}
//
//	@Bean
//	public Tasklet successTasklet() {
//		return (contribution, context) -> {
//			System.out.println("Success!");
//			return RepeatStatus.FINISHED;
//		};
//	}
//
//	@Bean
//	public Tasklet failTasklet() {
//		return (contribution, context) -> {
//			System.out.println("Failure!");
//			return RepeatStatus.FINISHED;
//		};
//	}
//
//	@Bean
//	public Job job() {
//		return this.jobBuilderFactory.get("conditionalJob")
//				.start(firstStep())
//				.on("FAILED").stopAndRestart(successStep())
//				.from(firstStep())
//					.on("*").to(successStep())
//				.end()
//				.build();
//	}
//
//	@Bean
//	public Step firstStep() {
//		return this.stepBuilderFactory.get("firstStep")
//				.tasklet(passTasklet())
//				.build();
//	}
//
//	@Bean
//	public Step successStep() {
//		return this.stepBuilderFactory.get("successStep")
//				.tasklet(successTasklet())
//				.build();
//	}
//
//	@Bean
//	public Step failureStep() {
//		return this.stepBuilderFactory.get("failureStep")
//				.tasklet(failTasklet())
//				.build();
//	}
//
//	@Bean
//	public JobExecutionDecider decider() {
//		return new RandomDecider();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(ConditionalJob.class, args);
//	}
}
