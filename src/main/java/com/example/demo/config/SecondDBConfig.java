package com.example.demo.config;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableMongoRepositories(
        basePackages = {
                "com.example.demo.repositorySecond"
        }
)
public class SecondDBConfig {

    @Value("${spring.db2.datasource.uri}")
    private String mongoUri;

    @Bean(name = "dataSourceEmployee")
    public MongoDatabaseFactory dataSource() {
        return new SimpleMongoClientDatabaseFactory(mongoUri);
    }

    @Bean(name = "mongoTemplate")
    public MongoTemplate mongoTemplate(@Qualifier("dataSourceEmployee") MongoDatabaseFactory databaseFactory) {
        return new MongoTemplate(databaseFactory);
    }

}
