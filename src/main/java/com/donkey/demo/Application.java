package com.donkey.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by qixin-lvxincao on 2018/5/24.
 */
@SpringBootApplication
@EnableAsync
@Transactional
@MapperScan("com.donkey.demo.dao")
public class Application {
    // 服务启动入口
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);


    }
}
