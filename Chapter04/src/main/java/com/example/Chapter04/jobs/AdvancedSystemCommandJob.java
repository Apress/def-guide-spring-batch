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
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Michael Minella
 */
@EnableBatchProcessing
@SpringBootApplication
public class AdvancedSystemCommandJob {

	@Autowired
	private JobBuilderFactory jobBuilderFactory;

	@Autowired
	private StepBuilderFactory stepBuilderFactory;

//	@Bean
//	public Job job() {
//		return this.jobBuilderFactory.get("systemCommandJob")
//				.start(systemCommandStep())
//				.build();
//	}
//
//	@Bean
//	public Step systemCommandStep() {
//		return this.stepBuilderFactory.get("systemCommandStep")
//				.tasklet(systemCommandTasklet())
//				.build();
//	}
//
//	@Bean
//	public SystemCommandTasklet systemCommandTasklet() {
//		SystemCommandTasklet tasklet = new SystemCommandTasklet();
//
//		tasklet.setCommand("touch tmp.txt");
//		tasklet.setTimeout(5000);
//		tasklet.setInterruptOnCancel(true);
//
//		// Change this directory to something appropriate for your environment
//		tasklet.setWorkingDirectory("/Users/mminella/spring-batch");
//
//		tasklet.setSystemProcessExitCodeMapper(touchCodeMapper());
//		tasklet.setTerminationCheckInterval(5000);
//		tasklet.setTaskExecutor(new SimpleAsyncTaskExecutor());
//		tasklet.setEnvironmentParams(new String[] {
//				"JAVA_HOME=/java",
//				"BATCH_HOME=/Users/batch"});
//
//		return tasklet;
//	}
//
//	@Bean
//	public SimpleSystemProcessExitCodeMapper touchCodeMapper() {
//		return new SimpleSystemProcessExitCodeMapper();
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(AdvancedSystemCommandJob.class, args);
//	}
}
