package com.example.doublesourse.dd;

import javax.sql.DataSource;
import java.util.Map;

/**
 * @author weepppp 2022/7/14 13:08
 **/

/**
 * @功能 AbstractRoutingDataSource动态获取数据源工具类需要 根据map的key名字获取value数据源
 * 所以我们配置一个封装接口和封装转换类，把从配置文件中读到的map格式转换成AbstractRoutingDataSource需要的map格式
 */
public interface DynamicDataSourceProvider {
    String DEFAULT_DATASOURCE_NAME = "master";
    Map<Object, Object> loadDataSource();
}
