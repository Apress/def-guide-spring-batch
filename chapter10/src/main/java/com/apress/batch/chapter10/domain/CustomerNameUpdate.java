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
package com.apress.batch.chapter10.domain;

import org.springframework.util.StringUtils;

/**
 * @author Michael Minella
 */
public class CustomerNameUpdate extends CustomerUpdate {

	private final String firstName;

	private final String middleName;

	private final String lastName;

	public CustomerNameUpdate(long customerId, String firstName, String middleName, String lastName) {
		super(customerId);
		this.firstName = StringUtils.hasText(firstName) ? firstName : null;
		this.middleName = StringUtils.hasText(middleName) ? middleName : null;
		this.lastName = StringUtils.hasText(lastName) ? lastName : null;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public String getLastName() {
		return lastName;
	}

	@Override
	public String toString() {
		return "CustomerNameUpdate{" +
				"firstName='" + firstName + '\'' +
				", middleName='" + middleName + '\'' +
				", lastName='" + lastName + '\'' +
				", customerId=" + customerId +
				'}';
	}
}
