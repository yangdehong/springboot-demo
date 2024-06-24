//package com.ydh.redsheep.sharding.controller;
//
//import com.ydh.redsheep.sharding.mapper.UserMapper;
//import com.ydh.redsheep.sharding.pojo.User;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import javax.annotation.Resource;
//import java.util.List;
//
///**
// * @description:
// * @author: yangdehong
// * @version: 2017/9/13.
// */
//@RestController
//@RequestMapping("user")
//public class UserController {
//
//    @Resource
//    private UserMapper userMapper;
//
//    @GetMapping("save")
//    public User save(){
//        User user = userMapper.selectById(2L);
//        return user;
//    }
//
//    @GetMapping("/findAllM")
//    public List<User> findAllProductM() {
//        List<User> all = userMapper.findAll();
//        return all;
//    }
//
//}
