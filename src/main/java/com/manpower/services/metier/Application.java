package com.manpower.services.metier;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

/**
 * Created by sbert on 21/06/2014.
 */
@Configuration
//@ComponentScan
@EnableMongoRepositories
@Import({RepositoryRestMvcConfiguration.class, MongoConfiguration.class, SwaggerConfiguration.class})
@EnableAutoConfiguration
public class Application  {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
