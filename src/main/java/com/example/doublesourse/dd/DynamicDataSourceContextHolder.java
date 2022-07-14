package com.example.doublesourse.dd;

/**
 * @author weepppp 2022/7/14 13:37
 **/

/**
 * @功能 把请求的数据源key信息存到本地线程类，保证单个请求查询的一直是同一个数据源
 */
public class DynamicDataSourceContextHolder {

    private static final ThreadLocal<String> CONTEXT_HOLDER =  new ThreadLocal<>();

    public static void setDsType(String dsType){
        CONTEXT_HOLDER.set(dsType);
    }

    public static String getDsType(){
        return CONTEXT_HOLDER.get();
    }

    public static void removeDsType(){
        CONTEXT_HOLDER.remove();
    }

}
