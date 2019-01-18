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

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.step.job.DefaultJobParametersExtractor;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Michael Minella
 */
@EnableBatchProcessing
@SpringBootApplication
public class JobJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

	@Bean
	public Tasklet loadStockFile() {
		return (contribution, chunkContext) -> {
			System.out.println("The stock file has been loaded");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Tasklet loadCustomerFile() {
		return (contribution, chunkContext) -> {
			System.out.println("The customer file has been loaded");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Tasklet updateStart() {
		return (contribution, chunkContext) -> {
			System.out.println("The start has been updated");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Tasklet runBatchTasklet() {
		return (contribution, chunkContext) -> {
			System.out.println("The batch has been run");
			return RepeatStatus.FINISHED;
		};
	}

	@Bean
	public Job preProcessingJob() {
		return this.jobBuilderFactory.get("preProcessingJob")
				.start(loadFileStep())
				.next(loadCustomerStep())
				.next(updateStartStep())
				.build();
	}

	@Bean
	public Job conditionalStepLogicJob() {
		return this.jobBuilderFactory.get("conditionalStepLogicJob")
				.start(intializeBatch())
				.next(runBatch())
				.build();
	}

	@Bean
	public Step intializeBatch() {
		return this.stepBuilderFactory.get("initalizeBatch")
				.job(preProcessingJob())
				.parametersExtractor(new DefaultJobParametersExtractor())
				.build();
	}

	@Bean
	public Step loadFileStep() {
		return this.stepBuilderFactory.get("loadFileStep")
				.tasklet(loadStockFile())
				.build();
	}

	@Bean
	public Step loadCustomerStep() {
		return this.stepBuilderFactory.get("loadCustomerStep")
				.tasklet(loadCustomerFile())
				.build();
	}

	@Bean
	public Step updateStartStep() {
		return this.stepBuilderFactory.get("updateStartStep")
				.tasklet(updateStart())
				.build();
	}

	@Bean
	public Step runBatch() {
		return this.stepBuilderFactory.get("runBatch")
				.tasklet(runBatchTasklet())
				.build();
	}

	public static void main(String[] args) {
		SpringApplication.run(HelloWorldJob.class, args);
	}
}
