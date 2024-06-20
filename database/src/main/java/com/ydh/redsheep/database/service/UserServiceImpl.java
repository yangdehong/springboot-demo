package com.ydh.redsheep.database.service;

import com.ydh.redsheep.database.mapper.UserMapper;
import com.ydh.redsheep.database.pojo.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

//    @Transactional
    @Override
    public void tx() {
        User user = userMapper.selectById(1L);
        user.setAge(user.getAge()+1);
        userMapper.updateById(user);
//        userMapper.findAll();
        tx2();
        int i = 1/0;
    }
    @Transactional
    @Override
    public void tx2() {
        User user = userMapper.selectById(2L);
        user.setAge(user.getAge()+1);
        userMapper.updateById(user);
//        int i = 1/0;
    }


}
