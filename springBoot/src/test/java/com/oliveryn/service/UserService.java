package com.oliveryn.service;

import com.oliveryn.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserService {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Test
    public void queryById(){
        Long a = 6L;
        userServiceImpl.queryById(a);
    }

    @Test
    public void add(){
        User user = new User();
        user.setName("oliver");
        user.setAge(20);
        user.setPassword("123321");
        userServiceImpl.add(user);
    }

    @Test
    public void delete(){
        userServiceImpl.delete(13);
    }

    @Test
    public void update(){
        User user = new User();
        user.setUserName("oliver_yeung");
        user.setId(14L);
        userServiceImpl.updateById(user);
    }
}
