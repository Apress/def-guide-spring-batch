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
package com.example.Chapter13.batch;

import java.io.IOException;
import java.io.Writer;

import org.springframework.batch.item.file.FlatFileHeaderCallback;

/**
 * @author Michael Minella
 */
public class StatementHeaderCallback implements FlatFileHeaderCallback {

	public void writeHeader(Writer writer) throws IOException {
		writer.write(String.format("%120s\n", "Customer Service Number"));
		writer.write(String.format("%120s\n", "(800) 867-5309"));
		writer.write(String.format("%120s\n", "Available 24/7"));
		writer.write("\n");
	}

}