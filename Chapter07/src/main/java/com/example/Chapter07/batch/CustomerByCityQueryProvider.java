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

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.springframework.batch.item.database.orm.AbstractJpaQueryProvider;
import org.springframework.util.Assert;

/**
 * @author Michael Minella
 */
public class CustomerByCityQueryProvider extends AbstractJpaQueryProvider {

	private String cityName;

	public Query createQuery() {
		EntityManager manager = getEntityManager();

		Query query =
				manager.createQuery("select c from Customer " +
						"c where c.city = :city");
		query.setParameter("city", cityName);

		return query;
	}

	public void afterPropertiesSet() throws Exception {
		Assert.notNull(cityName, "City name is required");
	}

	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
}
