package com.oliveryn.controller;

import com.oliveryn.mapper.UserMapper;
import com.oliveryn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    //@Autowired
    //private UserMapper userMapper;
    @GetMapping("findAll")
    public List<User> findAll(){
        //List<User> users = userMapper.findAll();
        //return users;
        return null;
    }
}
