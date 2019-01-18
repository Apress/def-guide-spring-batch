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

import java.util.concurrent.Callable;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Michael Minella
 */
@EnableBatchProcessing
@SpringBootApplication
public class CallableTaskletConfiguration {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

//	@Bean
//	public Job callableJob() {
//		return this.jobBuilderFactory.get("callableJob")
//				.start(callableStep())
//				.build();
//	}
//
//	@Bean
//	public Step callableStep() {
//		return this.stepBuilderFactory.get("callableStep")
//				.tasklet(tasklet())
//				.build();
//	}

	@Bean
	public Callable<RepeatStatus> callableObject() {
		return () -> {
			System.out.println("This was executed in another thread");

			return RepeatStatus.FINISHED;
		};
	}

//	@Bean
//	public CallableTaskletAdapter tasklet() {
//		CallableTaskletAdapter callableTaskletAdapter =
//				new CallableTaskletAdapter();
//
//		callableTaskletAdapter.setCallable(callableObject());
//
//		return callableTaskletAdapter;
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(CallableTaskletConfiguration.class, args);
//	}
}
