package com.oliveryn.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    //SpringBoot和Redis整合时 在ioc容器中心存了RedisTemplate和StringRedisTemplate
    @Autowired
    private RedisTemplate redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    @Test
    public void test1(){
        redisTemplate.opsForValue().set("str","zhangsan",1L, TimeUnit.DAYS);  //设置数据的存活时间
        redisTemplate.opsForValue().set("str","zhangsan");  //当前redis命令封装的方法
        //redisTemplate.boundValueOps("str").set("heima");//面向对象封装的方法
        System.out.println("str = "+redisTemplate.opsForValue().get("str"));
    }
}
