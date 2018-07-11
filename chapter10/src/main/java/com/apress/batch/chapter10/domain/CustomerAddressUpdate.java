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
public class CustomerAddressUpdate extends CustomerUpdate {

	private final String address1;

	private final String address2;

	private final String city;

	private final String state;

	private final String postalCode;

	public CustomerAddressUpdate(long customerId, String address1, String address2, String city, String state, String postalCode) {
		super(customerId);
		this.address1 = StringUtils.hasText(address1) ? address1 : null;
		this.address2 = StringUtils.hasText(address2) ? address2 : null;
		this.city = StringUtils.hasText(city) ? city : null;
		this.state = StringUtils.hasText(state) ? state : null;
		this.postalCode = StringUtils.hasText(postalCode) ? postalCode : null;
	}

	public String getAddress1() {
		return address1;
	}

	public String getAddress2() {
		return address2;
	}

	public String getCity() {
		return city;
	}

	public String getState() {
		return state;
	}

	public String getPostalCode() {
		return postalCode;
	}
}
