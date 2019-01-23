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
package com.example.Chapter06.batch;

import com.example.Chapter06.domain.Transaction;

import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.ItemStreamReader;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.file.transform.FieldSet;

/**
 * @author Michael Minella
 */
public class TransactionReader implements ItemStreamReader<Transaction> {

	private ItemStreamReader<FieldSet> fieldSetReader;
	private int recordCount = 0;
	private int expectedRecordCount = 0;

	private StepExecution stepExecution;

	public TransactionReader(ItemStreamReader<FieldSet> fieldSetReader) {
		this.fieldSetReader = fieldSetReader;
	}

	public Transaction read() throws Exception {
		return process(fieldSetReader.read());
	}

	private Transaction process(FieldSet fieldSet) {
		if(this.recordCount == 25) {
			throw new ParseException("This isn't what I hoped to happen");
		}

		Transaction result = null;

		if(fieldSet != null) {
			if(fieldSet.getFieldCount() > 1) {
				result = new Transaction();
				result.setAccountNumber(fieldSet.readString(0));
				result.setTimestamp(
						fieldSet.readDate(1,
								"yyyy-MM-DD HH:mm:ss"));
				result.setAmount(fieldSet.readDouble(2));

				recordCount++;
			} else {
				expectedRecordCount = fieldSet.readInt(0);

				if(expectedRecordCount != this.recordCount) {
					this.stepExecution.setTerminateOnly();
				}
			}
		}

		return result;
	}

	public void setFieldSetReader(ItemStreamReader<FieldSet> fieldSetReader) {
		this.fieldSetReader = fieldSetReader;
	}

//	@AfterStep
//	public ExitStatus afterStep(StepExecution execution) {
//		if(recordCount == expectedRecordCount) {
//			return execution.getExitStatus();
//		} else {
//			return ExitStatus.STOPPED;
//		}
//	}

	@BeforeStep
	public void beforeStep(StepExecution execution) {
		this.stepExecution = execution;
	}

	@Override
	public void open(ExecutionContext executionContext) throws ItemStreamException {
		this.fieldSetReader.open(executionContext);
	}

	@Override
	public void update(ExecutionContext executionContext) throws ItemStreamException {
		this.fieldSetReader.update(executionContext);
	}

	@Override
	public void close() throws ItemStreamException {
		this.fieldSetReader.close();
	}
}
