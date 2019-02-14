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

import com.example.Chapter13.configuration.ImportJobConfiguration;
import com.example.Chapter13.domain.CustomerAddressUpdate;
import com.example.Chapter13.domain.CustomerContactUpdate;
import com.example.Chapter13.domain.CustomerNameUpdate;
import com.example.Chapter13.domain.CustomerUpdate;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.test.MetaDataInstanceFactory;
import org.springframework.batch.test.context.SpringBatchTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.JdbcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.Assert.assertTrue;

/**
 * @author Michael Minella
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ImportJobConfiguration.class,
		CustomerItemValidator.class,
		AccountItemProcessor.class})
@JdbcTest
@EnableBatchProcessing
@SpringBatchTest
public class FlatFileItemReaderTests {

	@Autowired
	private FlatFileItemReader<CustomerUpdate> customerUpdateItemReader;

	public StepExecution getStepExecution() {
		JobParameters jobParameters = new JobParametersBuilder()
				.addString("customerUpdateFile", "classpath:customerUpdateFile.csv")
				.toJobParameters();

		return MetaDataInstanceFactory.createStepExecution(jobParameters);
	}

	@Test
	public void testTypeConversion() throws Exception {
		this.customerUpdateItemReader.open(new ExecutionContext());

		assertTrue(this.customerUpdateItemReader.read() instanceof CustomerAddressUpdate);
		assertTrue(this.customerUpdateItemReader.read() instanceof CustomerContactUpdate);
		assertTrue(this.customerUpdateItemReader.read() instanceof CustomerNameUpdate);
	}

}
