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
package com.example.Chapter06;

/**
 * @author Michael Minella
 */
//@EnableBatchProcessing
//@SpringBootApplication
public class QuartzJobConfiguration {
//
//	@Configuration
//	public class BatchConfiguration {
//
//		@Autowired
//		private JobBuilderFactory jobBuilderFactory;
//
//		@Autowired
//		private StepBuilderFactory stepBuilderFactory;
//
//		@Bean
//		public Job job() {
//			return this.jobBuilderFactory.get("job")
//					.incrementer(new RunIdIncrementer())
//					.start(step1())
//					.build();
//		}
//
//		@Bean
//		public Step step1() {
//			return this.stepBuilderFactory.get("step1")
//					.tasklet((stepContribution, chunkContext) -> {
//						System.out.println("step1 ran!");
//						return RepeatStatus.FINISHED;
//					}).build();
//		}
//	}
//
//	public static void main(String[] args) {
//		SpringApplication.run(QuartzJobConfiguration.class, args);
//	}
}
