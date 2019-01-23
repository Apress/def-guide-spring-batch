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
package com.apress.batch.chapter9.batch;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import com.apress.batch.chapter9.domain.Customer;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.batch.item.file.FlatFileFooterCallback;
import org.springframework.stereotype.Component;

/**
 * @author Michael Minella
 */
@Component
@Aspect
public class CustomerRecordCountFooterCallback implements FlatFileFooterCallback {

	private int itemsWrittenInCurrentFile = 0;

	@Override
	public void writeFooter(Writer writer) throws IOException {
		writer.write("This file contains " +
				itemsWrittenInCurrentFile + " items");
	}

	@Before("execution(* org.springframework.batch.item.file.FlatFileItemWriter.write(..))")
	public void beforeWrite(JoinPoint joinPoint) {
		List<Customer> items = (List<Customer>) joinPoint.getArgs()[0];

		this.itemsWrittenInCurrentFile += items.size();
	}

	@Before("execution(* org.springframework.batch.item.file.FlatFileItemWriter.open(..))")
	public void resetCounter() {
		this.itemsWrittenInCurrentFile = 0;
	}
}
