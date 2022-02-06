package com.ydh.redsheep.database.common.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
*
* @author : yangdehong
* @date : 2022/2/6 10:57
*/
public class RoutingDataSource extends AbstractRoutingDataSource {
    @Override
    protected Object determineCurrentLookupKey() {
        return RoutingDataSourceContext.getDataSourceRoutingKey();
    }
}