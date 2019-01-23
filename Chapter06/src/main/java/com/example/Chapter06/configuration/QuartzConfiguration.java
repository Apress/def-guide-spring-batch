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
package com.example.Chapter06.configuration;

import com.example.Chapter06.quartz.BatchScheduledJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Michael Minella
 */
@Configuration
public class QuartzConfiguration {

	@Bean
	public JobDetail quartzJobDetail() {
		return JobBuilder.newJob(BatchScheduledJob.class)
				.storeDurably()
				.build();
	}

	@Bean
	public Trigger jobTrigger() {
		SimpleScheduleBuilder scheduleBuilder = SimpleScheduleBuilder.simpleSchedule()
				.withIntervalInSeconds(5).withRepeatCount(4);

		return TriggerBuilder.newTrigger()
				.forJob(quartzJobDetail())
				.withSchedule(scheduleBuilder)
				.build();
	}
}

