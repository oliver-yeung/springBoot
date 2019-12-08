package com.oliveryn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication //当前包及其子包下所有文件中的类
@MapperScan("com.oliveryn.mapper")
public class Application {
    //springBoot项目通过此main函数启动

    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
