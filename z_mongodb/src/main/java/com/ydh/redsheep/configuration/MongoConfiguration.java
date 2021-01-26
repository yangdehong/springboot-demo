package com.ydh.redsheep.configuration;

import com.mongodb.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class MongoConfiguration extends AbstractMongoConfiguration {

    private String primaryHost = "172.16.131.10";
    private String secondaryHost = "172.16.131.10";
    private Integer port = 27017;
    private String dbName = "ydh";
    private String username = "ydh";
    private String password = "123456";
    private int nodeType = 0;
    private String replicaSet = "mgset-xxxxx";

    @Bean
    @Primary
    @Override
    public MongoTemplate mongoTemplate() {
        // 调用mongoClient()而不是createMongoClient()，因为mongoClient()用@Bean注解，生成的是单例，
        // 可以供该方法和子类的mongoDbFactory()方法调用，不再生成新的MongoClient对象。而用createMongoClient()
        // 方法时，每次调用都会生成新的MongoClient
        MongoClient client = mongoClient();
        MongoTemplate mongoTemplate = new MongoTemplate(client, dbName);
        mongoTemplate.setReadPreference(client.getReadPreference());
        return mongoTemplate;
    }

    @Bean
    @Override
    public MongoClient mongoClient() {
        return createMonoClient();
    }


    @Override
    protected String getDatabaseName() {
        return "ydh";
    }

    private MongoClient createMonoClient() {
        MongoClient mongoClient;
        if (false) {
            mongoClient = multiNode();
        } else {
            mongoClient = singleNode();
        }
        return mongoClient;
    }

    private MongoClient singleNode() {
        MongoClient mongoClient;
        MongoCredential credential = MongoCredential.createScramSha1Credential(username, dbName, password.toCharArray());
        MongoClientOptions options = MongoClientOptions.builder()
                .connectionsPerHost(300)
                .maxConnectionIdleTime(6000)
                .threadsAllowedToBlockForConnectionMultiplier(10)
                .readPreference(ReadPreference.nearest())
                .build();
        List<ServerAddress> addresses = new ArrayList<>();
        ServerAddress address = new ServerAddress(primaryHost, port);
        addresses.add(address);
        mongoClient = new MongoClient(addresses, credential, options);

        return mongoClient;
    }

    private MongoClient multiNode() {
        MongoClientURI connectionString = new MongoClientURI("mongodb://" + username + ":" + password + "@"
                + primaryHost + ":" + port + "," + secondaryHost + ":" + port
                + "/" + dbName + "?replicaSet=" + replicaSet + "&readPreference=secondaryPreferred");
        return new MongoClient(connectionString);
    }

}
