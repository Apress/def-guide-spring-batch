/*
 * Copyright 2018 the original author or authors.
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
package com.apress.batch.chapter10.batch;

import com.apress.batch.chapter10.domain.CustomerAddressUpdate;
import com.apress.batch.chapter10.domain.CustomerContactUpdate;
import com.apress.batch.chapter10.domain.CustomerNameUpdate;
import com.apress.batch.chapter10.domain.CustomerUpdate;

import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.classify.Classifier;

/**
 * @author Michael Minella
 */
public class CustomerUpdateClassifier implements Classifier<CustomerUpdate, ItemWriter<? super CustomerUpdate>> {

	private final JdbcBatchItemWriter<CustomerUpdate> recordType1ItemWriter;
	private final JdbcBatchItemWriter<CustomerUpdate> recordType2ItemWriter;
	private final JdbcBatchItemWriter<CustomerUpdate> recordType3ItemWriter;

	public CustomerUpdateClassifier(JdbcBatchItemWriter<CustomerUpdate> recordType1ItemWriter, JdbcBatchItemWriter<CustomerUpdate> recordType2ItemWriter, JdbcBatchItemWriter<CustomerUpdate> recordType3ItemWriter) {
		this.recordType1ItemWriter = recordType1ItemWriter;
		this.recordType2ItemWriter = recordType2ItemWriter;
		this.recordType3ItemWriter = recordType3ItemWriter;
	}

	@Override
	public ItemWriter<? super CustomerUpdate> classify(CustomerUpdate classifiable) {

		if(classifiable instanceof CustomerNameUpdate) {
			return recordType1ItemWriter;
		}
		else if(classifiable instanceof CustomerAddressUpdate) {
			return recordType2ItemWriter;
		}
		else if(classifiable instanceof CustomerContactUpdate) {
			return recordType3ItemWriter;
		}
		else {
			throw new IllegalArgumentException("Invalid type: " + classifiable.getClass().getCanonicalName());
		}
	}
}
