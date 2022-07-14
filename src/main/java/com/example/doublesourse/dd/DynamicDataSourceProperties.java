package com.example.doublesourse.dd;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author weepppp 2022/7/14 13:03
 **/

/**
 * @功能 自定义配置文件需要被自定义配置类读取
 */
@ConfigurationProperties(prefix = "spring.datasource")
public class DynamicDataSourceProperties {
    private String type;
    private String driverClassName;
    private Map<String, Map<String,String>> ds;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public Map<String, Map<String, String>> getDs() {
        return ds;
    }

    public void setDs(Map<String, Map<String, String>> ds) {
        this.ds = ds;
    }
}
