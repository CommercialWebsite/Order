package com.order;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;

@Configuration
public class MongoConfig extends  AbstractMongoConfiguration {

    @Override
    public String getDatabaseName() {
        return "CommercialWebsite";
    }

    @Override
    @Bean
    public Mongo mongo() throws Exception {
       // mongodb://heroku_xfd4gndr:jv4kpn4tdr4923pbdi95k7h5aj@ds139446.mlab.com:39446/heroku_xfd4gndr
        //127.0.0.1
        return new MongoClient("mongodb://heroku_xfd4gndr:jv4kpn4tdr4923pbdi95k7h5aj@ds139446.mlab.com:39446/heroku_xfd4gndr");
    }

}

