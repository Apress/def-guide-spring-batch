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

/**
 * @author Michael Minella
 */
public class CustomerContactUpdate extends CustomerUpdate {

	private final String emailAddress;

	private final String homePhone;

	private final String cellPhone;

	private final String workPhone;

	private final Integer notificationPreferences;

	public CustomerContactUpdate(long customerId, String emailAddress, String homePhone, String cellPhone, String workPhone, Integer notificationPrefernces) {
		super(customerId);
		this.emailAddress = emailAddress;
		this.homePhone = homePhone;
		this.cellPhone = cellPhone;
		this.workPhone = workPhone;
		this.notificationPreferences = notificationPrefernces;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getHomePhone() {
		return homePhone;
	}

	public String getCellPhone() {
		return cellPhone;
	}

	public String getWorkPhone() {
		return workPhone;
	}

	public Integer getNotificationPreferences() {
		return notificationPreferences;
	}
}
