package com.oliveryn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.oliveryn.mapper")
public class Application {
    //springBoot项目通过此main函数启动

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
