package com.baizhi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@MapperScan("com.baizhi.dao")
@SpringBootApplication //
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args) {
        //启动springboot
        SpringApplication.run(Application.class, args);
    }

}
