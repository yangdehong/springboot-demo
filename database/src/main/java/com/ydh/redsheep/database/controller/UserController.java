package com.ydh.redsheep.database.controller;

import com.ydh.redsheep.database.mapper.UserMapper;
import com.ydh.redsheep.database.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/13.
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @GetMapping("get")
    public User get(){
        User user = userMapper.selectById(2L);
        return user;
    }

}
