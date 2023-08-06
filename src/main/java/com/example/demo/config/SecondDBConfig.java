package com.example.demo.config;

import jakarta.persistence.EntityManagerFactory;
import java.util.HashMap;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
        entityManagerFactoryRef = "entityManagerFactoryEmployee",
        basePackages = {
                "com.example.demo.repositorySecond"
        }
)
public class SecondDBConfig {

    @Bean(name = "dataSourceEmployee")
    @ConfigurationProperties(prefix = "spring.db2.datasource")
    public DataSource dataSource() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "entityManagerFactoryEmployee")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory(
            EntityManagerFactoryBuilder builder, @Qualifier("dataSourceEmployee") DataSource dataSource) {
        HashMap<String, Object> properties = new HashMap<>();
        properties.put("hibernate.hbm2ddl.auto", "update");

        return builder.dataSource(dataSource)
                .properties(properties)
                .packages("com.example.demo.modelSecond")
                .persistenceUnit("db2")
                .build();
    }

    @Bean(name = "transactionManagerEmployee")
    public PlatformTransactionManager transactionManager(@Qualifier("entityManagerFactoryEmployee")
                                                         EntityManagerFactory entityManagerFactory) {
        return new JpaTransactionManager(entityManagerFactory);
    }

}
