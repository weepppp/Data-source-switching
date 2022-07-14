package com.example.doublesourse.dd;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author weepppp 2022/7/14 13:14
 **/

/**
 * @功能 AbstractRoutingDataSource动态获取数据源工具类需要 根据map的key名字获取value数据源
 * 所以我们配置一个封装接口和封装转换类，把从配置文件中读到的map格式转换成AbstractRoutingDataSource需要的map格式
 */
@Component
@EnableConfigurationProperties(DynamicDataSourceProperties.class)
public class YmlDynamicDataSourceProvider implements DynamicDataSourceProvider {

    @Autowired
    DynamicDataSourceProperties dynamicDataSourceProperties;

    @Override
    public Map<Object, Object> loadDataSource() {
        Map<Object, Object> map = new HashMap<>(dynamicDataSourceProperties.getDs().size());
        Map<String, Map<String, String>> ds = dynamicDataSourceProperties.getDs();
        Set<String> keySet = ds.keySet();
        try {
            for (String key : keySet) {
                Map<String, String> daMap = ds.get(key);
                DataSource dataSource = DruidDataSourceFactory.createDataSource(daMap);
                map.put(key, dataSource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }
}
