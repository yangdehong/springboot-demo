package com.ydh.redsheep.database.controller;

import com.ydh.redsheep.database.common.aop.RoutingWith;
import com.ydh.redsheep.database.common.config.RoutingDataSourceContext;
import com.ydh.redsheep.database.mapper.UserMapper;
import com.ydh.redsheep.database.pojo.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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

    @RoutingWith("masterDataSource")
    @GetMapping("/findAllM")
    public String findAllProductM() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
        return "ydh";
    }
    @RoutingWith("slaveDataSource")
    @GetMapping("/findAllS")
    public String findAllProductS() {
        List<User> all = userMapper.findAll();
        System.out.println(all);
        return "ydh2";
    }

}
