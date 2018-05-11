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

import javax.annotation.PostConstruct;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.batch.core.configuration.BatchConfigurationException;
import org.springframework.batch.core.configuration.annotation.BatchConfigurer;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.explore.support.JobExplorerFactoryBean;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.repository.support.JobRepositoryFactoryBean;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

/**
 * @author Michael Minella
 */
@Component
public class JpaBatchConfigurer implements BatchConfigurer {

	private DataSource dataSource;
	private EntityManagerFactory entityManagerFactory;
	private JobRepository jobRepository;
	private PlatformTransactionManager transactionManager;
	private JobLauncher jobLauncher;
	private JobExplorer jobExplorer;

	public JpaBatchConfigurer(DataSource dataSource, EntityManagerFactory entityManagerFactory) {
		this.dataSource = dataSource;
		this.entityManagerFactory = entityManagerFactory;
	}

	@Override
	public JobRepository getJobRepository() throws Exception {
		return this.jobRepository;
	}

	@Override
	public PlatformTransactionManager getTransactionManager() throws Exception {
		return this.transactionManager;
	}

	@Override
	public JobLauncher getJobLauncher() throws Exception {
		return this.jobLauncher;
	}

	@Override
	public JobExplorer getJobExplorer() throws Exception {
		return this.jobExplorer;
	}

	@PostConstruct
	public void initialize() {

		try {
			JpaTransactionManager transactionManager = new JpaTransactionManager(entityManagerFactory);
			transactionManager.afterPropertiesSet();

			this.transactionManager = transactionManager;

			this.jobRepository = createJobRepository();
			this.jobExplorer = createJobExplorer();
			this.jobLauncher = createJobLauncher();

		}
		catch (Exception e) {
			throw new BatchConfigurationException(e);
		}
	}

	private JobLauncher createJobLauncher() throws Exception {
		SimpleJobLauncher jobLauncher = new SimpleJobLauncher();

		jobLauncher.setJobRepository(this.jobRepository);
		jobLauncher.afterPropertiesSet();

		return jobLauncher;
	}

	private JobExplorer createJobExplorer() throws Exception {
		JobExplorerFactoryBean jobExplorerFactoryBean = new JobExplorerFactoryBean();

		jobExplorerFactoryBean.setDataSource(this.dataSource);
		jobExplorerFactoryBean.afterPropertiesSet();

		return jobExplorerFactoryBean.getObject();
	}

	private JobRepository createJobRepository() throws Exception {
		JobRepositoryFactoryBean jobRepositoryFactoryBean = new JobRepositoryFactoryBean();

		jobRepositoryFactoryBean.setDataSource(this.dataSource);
		jobRepositoryFactoryBean.setTransactionManager(this.transactionManager);
		jobRepositoryFactoryBean.afterPropertiesSet();

		return jobRepositoryFactoryBean.getObject();
	}
}
