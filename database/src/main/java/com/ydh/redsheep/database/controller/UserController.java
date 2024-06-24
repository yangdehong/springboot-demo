package com.ydh.redsheep.database.controller;

import com.ydh.redsheep.database.common.aop.RoutingWith;
import com.ydh.redsheep.database.common.config.RoutingDataSourceContext;
import com.ydh.redsheep.database.mapper.UserMapper;
import com.ydh.redsheep.database.pojo.User;
import com.ydh.redsheep.database.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.time.LocalDateTime;
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
    @Resource
    private UserService userService;

    @GetMapping("get")
    public User get(){
        User user = userMapper.selectById(2L);
        User user2 = new User();
        user2.setId(99L);
        user2.setAge(18);
        user2.setEmail("test@ydh.cn");
        user2.setName("ydh");
        user2.setBirthDay(LocalDateTime.now());
        userMapper.insert(user2);
        return user;
    }

    @GetMapping("tx")
    public void tx(){
        userService.tx();
    }

    @RoutingWith("masterDataSource")
    @GetMapping("/findAllM")
    public List<User> findAllProductM() {
        List<User> all = userMapper.findAll();
        return all;
    }
    @RoutingWith("slaveDataSource")
    @GetMapping("/findAllS")
    public List<User> findAllProductS() {
        List<User> all = userMapper.findAll();
        return all;
    }

}
