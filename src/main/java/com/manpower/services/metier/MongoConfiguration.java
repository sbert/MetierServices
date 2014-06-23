package com.manpower.services.metier;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoURI;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

/**
 * Created by sbert on 21/06/2014.
 */

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    @Value("${mongo.url}")
    private String url;

    @Value("${mongo.db}")
    private String databaseName;

    @Override
    protected String getDatabaseName() {
        return databaseName;
    }

    @Override
    public Mongo mongo() throws Exception {
        return new MongoClient(url);
    }

}
