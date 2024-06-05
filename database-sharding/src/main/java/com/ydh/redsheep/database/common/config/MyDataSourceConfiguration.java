package com.ydh.redsheep.database.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

/**
*
* @author : yangdehong
* @date : 2022/2/6 10:55
*/
@Slf4j
@Configuration
public class MyDataSourceConfiguration {

    /**
     * Master data source.
     */
    @Bean("masterDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.master")
    DataSource masterDataSource() {
        log.info("create master datasource...");
        return DataSourceBuilder.create().build();
    }
    /**
     * Slave data source.
     */
    @Bean("slaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.druid.slave")
    DataSource slaveDataSource() {
        log.info("create slave datasource...");
        return DataSourceBuilder.create().build();
    }

    @Bean
    @Primary
    DataSource primaryDataSource(@Autowired @Qualifier("masterDataSource") DataSource masterDataSource,
            @Autowired @Qualifier("slaveDataSource") DataSource slaveDataSource){
        log.info("create routing datasource...");
        Map<Object, Object> map = new HashMap<>();
        map.put("masterDataSource", masterDataSource);
        map.put("slaveDataSource", slaveDataSource);
        RoutingDataSource routing = new RoutingDataSource();
        routing.setTargetDataSources(map);
        routing.setDefaultTargetDataSource(masterDataSource);
        return routing;
    }

}
