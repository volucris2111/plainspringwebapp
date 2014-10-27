
package com.aysidisi.projectbrowsergamespring.config;

import javax.inject.Inject;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@PropertySource("classpath:services.properties")
@Configuration
@Profile("default")
public class MongoDataSourceConfiguration
{
	
	@Inject
	Environment environment;
	
	@Bean(name = "local")
	public MongoDbFactory mongoDbFactoryLocal() throws Exception
	{
		String dbName = environment.getProperty("mongo.db");
		String host = environment.getProperty("mongo.host");
		Mongo mongo = new MongoClient(host);
		return new SimpleMongoDbFactory(mongo, dbName);
	}
}