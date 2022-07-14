package com.example.doublesourse.dd;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;
import org.springframework.stereotype.Component;

/**
 * @author weepppp 2022/7/14 13:31
 **/

/**
 * @功能 AbstractRoutingDataSource根据key动态选择数据源类
 */
@Component
public class DynamicDataSource extends AbstractRoutingDataSource {

    DynamicDataSourceProvider dynamicDataSourceProvider;

    public DynamicDataSource(DynamicDataSourceProvider dynamicDataSourceProvider) {
        this.dynamicDataSourceProvider = dynamicDataSourceProvider;
        super.setTargetDataSources(dynamicDataSourceProvider.loadDataSource()); // 把多数据源都设置上
        super.setDefaultTargetDataSource(dynamicDataSourceProvider.loadDataSource().get(DynamicDataSourceProvider.DEFAULT_DATASOURCE_NAME));
    }

    @Override
    protected Object determineCurrentLookupKey() {
        return DynamicDataSourceContextHolder.getDsType();
    }
}
