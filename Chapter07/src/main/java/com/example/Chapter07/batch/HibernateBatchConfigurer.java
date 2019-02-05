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

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.hibernate.SessionFactory;

import org.springframework.batch.core.configuration.annotation.DefaultBatchConfigurer;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
//@Component
public class HibernateBatchConfigurer extends DefaultBatchConfigurer {

	private DataSource dataSource;
	private SessionFactory sessionFactory;
	private PlatformTransactionManager transactionManager;

	public HibernateBatchConfigurer(DataSource dataSource, EntityManagerFactory entityManagerFactory) {
		super(dataSource);
		this.dataSource = dataSource;
		this.sessionFactory = entityManagerFactory.unwrap(SessionFactory.class);
		this.transactionManager = new HibernateTransactionManager(this.sessionFactory);
	}

	@Override
	public PlatformTransactionManager getTransactionManager() {
		return this.transactionManager;
	}
}
