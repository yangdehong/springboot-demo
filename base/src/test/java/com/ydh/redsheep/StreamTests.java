//package com.ydh.redsheep;
//
//import com.ydh.redsheep.base.mapper.UserMapper;
//import com.ydh.redsheep.base.pojo.User;
//import com.ydh.redsheep.base.service.UserService;
//import com.ydh.redsheep.base.common.util.SteamUtils;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.ibatis.cursor.Cursor;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.TransactionManager;
//
//import javax.annotation.Resource;
//import java.util.Random;
//
//@Slf4j
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class StreamTests {
//
//    @Resource
//    private UserService userService;
//
//    @Test
//    public void test() {
//        userService.scan();
//    }
//    @Test
//    public void test2() {
//        SteamUtils.handleItem(3, ()->userService.list(), (i, user)->{
//            System.out.println(i + "=====" + user);
//        });
//    }
//
//
//}
