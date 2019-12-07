package com.oliveryn.service;

import com.oliveryn.mapper.UserMapper;
import com.oliveryn.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public User queryById(Long id){
        return userMapper.selectByPrimaryKey(id);
    }

    public void add(User user){
        userMapper.insert(user);
    }

    public void delete(Object key){
        userMapper.deleteByPrimaryKey(key);
    }

    public void updateById(User user){
        userMapper.updateByPrimaryKey(user);
    }
}
