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

import com.example.Chapter07.domain.Customer;

import org.springframework.batch.item.ExecutionContext;
import org.springframework.batch.item.ItemStreamException;
import org.springframework.batch.item.file.ResourceAwareItemReaderItemStream;
import org.springframework.core.io.Resource;

/**
 * @author Michael Minella
 */
public class CustomerFileReader implements ResourceAwareItemReaderItemStream<Customer> {

	private Object curItem = null;

	private ResourceAwareItemReaderItemStream<Object> delegate;

	public CustomerFileReader(ResourceAwareItemReaderItemStream<Object> delegate) {
		this.delegate = delegate;
	}

	public Customer read() throws Exception {
		if(curItem == null) {
			curItem = delegate.read();
		}

		Customer item = (Customer) curItem;
		curItem = null;

//		if(item != null) {
//			item.setTransactions(new ArrayList<>());
//
//			while(peek() instanceof Transaction) {
//				item.getTransactions().add((Transaction) curItem);
//				curItem = null;
//			}
//		}

		return item;
	}

	private Object peek() throws Exception {
		if (curItem == null) {
			curItem = delegate.read();
		}
		return curItem;
	}

	public void close() throws ItemStreamException {
		delegate.close();
	}

	public void open(ExecutionContext arg0) throws ItemStreamException {
		delegate.open(arg0);
	}

	public void update(ExecutionContext arg0) throws ItemStreamException {
		delegate.update(arg0);
	}

	@Override
	public void setResource(Resource resource) {
		this.delegate.setResource(resource);
	}
}
