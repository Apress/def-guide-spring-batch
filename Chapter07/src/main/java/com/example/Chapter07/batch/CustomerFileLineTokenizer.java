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

/**
 * @author Michael Minella
 */
import java.util.ArrayList;
import java.util.List;

import org.springframework.batch.item.file.transform.DefaultFieldSetFactory;
import org.springframework.batch.item.file.transform.FieldSet;
import org.springframework.batch.item.file.transform.FieldSetFactory;
import org.springframework.batch.item.file.transform.LineTokenizer;

public class CustomerFileLineTokenizer implements LineTokenizer {

	private String delimiter = ",";
	private String[] names = new String[] {"firstName",
			"middleInitial",
			"lastName",
			"address",
			"city",
			"state",
			"zipCode"};

	private FieldSetFactory fieldSetFactory = new DefaultFieldSetFactory();

	public FieldSet tokenize(String record) {

		String[] fields = record.split(delimiter);

		List<String> parsedFields = new ArrayList<>();

		for (int i = 0; i < fields.length; i++) {
			if (i == 4) {
				parsedFields.set(i - 1,
						parsedFields.get(i - 1) + " " + fields[i]);
			} else {
				parsedFields.add(fields[i]);
			}
		}

		return fieldSetFactory.create(parsedFields.toArray(new String [0]),
						names);
	}
}
