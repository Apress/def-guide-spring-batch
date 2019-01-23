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
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLStreamException;

import org.springframework.batch.item.xml.StaxWriterCallback;
import org.springframework.stereotype.Component;

/**
 * @author Michael Minella
 */
@Component
public class CustomerXmlHeaderCallback implements StaxWriterCallback {

	@Override
	public void write(XMLEventWriter writer) throws IOException {
		XMLEventFactory factory = XMLEventFactory.newInstance();

		try {
			writer.add(factory.createStartElement("", "", "identification"));
			writer.add(factory.createStartElement("", "", "author"));
			writer.add(factory.createAttribute("name", "Michael Minella"));
			writer.add(factory.createEndElement("", "", "author"));
			writer.add(factory.createEndElement("", "", "identification"));
		} catch (XMLStreamException xmlse) {
			System.err.println("An error occured: " + xmlse.getMessage());
			xmlse.printStackTrace(System.err);
		}
	}
}
