package com.order;

import com.mongodb.MongoClientURI;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends  AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "heroku_xfd4gndr";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        MongoClientURI uri  = new MongoClientURI("mongodb://heroku_xfd4gndr:jv4kpn4tdr4923pbdi95k7h5aj@ds139446.mlab.com:39446/heroku_xfd4gndr");

        return new MongoClient(uri);    }

}

