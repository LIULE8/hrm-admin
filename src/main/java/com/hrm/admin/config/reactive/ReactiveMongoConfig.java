package com.hrm.admin.config.reactive;

import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

/**
 * @author LIULE9
 * @create 12/03/2019
 */
@Configuration
public class ReactiveMongoConfig {
  public @Bean MongoClient reactiveMongoClient() {
    return MongoClients.create("mongodb://localhost");
  }

  public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
    return new ReactiveMongoTemplate(reactiveMongoClient(), "hrmadmin");
  }

//  public @Bean ReactiveMongoDatabaseFactory reactiveMongoDatabaseFactory() {
//    return new SimpleReactiveMongoDatabaseFactory(
//        MongoClients.create("mongodb://localhost:27017"), "hrmadmin");
//  }
//
//  public @Bean ReactiveMongoTemplate reactiveMongoTemplate() {
//    return new ReactiveMongoTemplate(reactiveMongoDatabaseFactory());
//  }
}
