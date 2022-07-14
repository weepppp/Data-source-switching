package com.example.doublesourse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackages = "com.example.doublesourse.mapper")
@SpringBootApplication
public class DoublesourseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DoublesourseApplication.class, args);
    }

}
