package com.ydh.redsheep.base.service.impl;

import com.ydh.redsheep.base.mapper.UserMapper;
import com.ydh.redsheep.base.pojo.User;
import com.ydh.redsheep.base.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> list() {
        return userMapper.list();
    }

    @Transactional
    @Override
    public void insert() {
        userMapper.insert(new User("天"));
        List<String> list = new ArrayList<>();
        list.get(1);
        userMapper.insert(new User("地"));
    }
}
