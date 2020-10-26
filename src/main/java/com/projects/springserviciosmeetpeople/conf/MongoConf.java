package com.projects.springserviciosmeetpeople.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories(basePackages = "com.projects.springserviciosmeetpeople.repository")
public class MongoConf extends AbstractMongoClientConfiguration{

	@Override
	protected String getDatabaseName() {
		return "meet-people-database";
	}

}
