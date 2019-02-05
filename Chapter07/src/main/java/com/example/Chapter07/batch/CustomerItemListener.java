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
package com.example.Chapter07.batch;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.springframework.batch.core.annotation.OnReadError;
import org.springframework.batch.item.file.FlatFileParseException;

/**
 * @author Michael Minella
 */
public class CustomerItemListener  {

	private static final Log logger = LogFactory.getLog(CustomerItemListener.class);

	@OnReadError
	public void onReadError(Exception e) {
		if(e instanceof FlatFileParseException) {
			FlatFileParseException ffpe = (FlatFileParseException) e;

			StringBuilder errorMessage = new StringBuilder();
			errorMessage.append("An error occured while processing the " +
					ffpe.getLineNumber() +
					" line of the file.  Below was the faulty " +
					"input.\n");
			errorMessage.append(ffpe.getInput() + "\n");

			logger.error(errorMessage.toString(), ffpe);
		} else {
			logger.error("An error has occurred", e);
		}
	}
}
