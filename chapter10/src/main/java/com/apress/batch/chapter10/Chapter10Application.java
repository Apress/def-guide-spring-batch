package com.apress.batch.chapter10;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Chapter10Application {

	public static void main(String[] args) {
		String[] realArgs = {"customerUpdateFile=file:///Users/mminella/Documents/IntelliJWorkspace/def-guide-spring-batch/chapter10/src/main/resources/data/customer_update_shuffled.csv",
		"transactionFile=file:///Users/mminella/Documents/IntelliJWorkspace/def-guide-spring-batch/chapter10/src/main/resources/data/transactions.xml",
		"outputDirectory=file:///Users/mminella/Documents/IntelliJWorkspace/def-guide-spring-batch/chapter10/target/statements/"};
//		String [] realArgs = {
//				"customerUpdateFile=file:\\Users\\mminella\\IdeaProjects\\def-guide-spring-batch\\chapter10\\src\\main\\resources\\data\\customer_update_shuffled.csv",
//				"transactionFile=file:\\Users\\mminella\\IdeaProjects\\def-guide-spring-batch\\chapter10\\src\\main\\resources\\data\\transactions.xml"
//		};
		SpringApplication.run(Chapter10Application.class, realArgs);
	}
}
