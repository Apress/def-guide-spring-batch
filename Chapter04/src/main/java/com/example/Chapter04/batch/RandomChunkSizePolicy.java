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
package com.example.Chapter04.batch;

import java.util.Random;

import org.springframework.batch.repeat.CompletionPolicy;
import org.springframework.batch.repeat.RepeatContext;
import org.springframework.batch.repeat.RepeatStatus;

/**
 * @author Michael Minella
 */
public class RandomChunkSizePolicy implements CompletionPolicy {

	private int chunksize;
	private int totalProcessed;
	private Random random = new Random();

	@Override
	public boolean isComplete(RepeatContext context,
			RepeatStatus result) {

		if(RepeatStatus.FINISHED == result) {
			return true;
		}
		else {
			return isComplete(context);
		}
	}

	@Override
	public boolean isComplete(RepeatContext context) {
		return this.totalProcessed >= chunksize;
	}

	@Override
	public RepeatContext start(RepeatContext parent) {
		this.chunksize = random.nextInt(20);
		this.totalProcessed = 0;

		System.out.println("The chunk size has been set to " +
				this.chunksize);

		return parent;
	}

	@Override
	public void update(RepeatContext context) {
		this.totalProcessed++;
	}
}
