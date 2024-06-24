package com.ydh.redsheep.sharding;

import com.ydh.redsheep.sharding.mapper.UserMapper;
import com.ydh.redsheep.sharding.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class TestMasterSlave {

    @Resource
    private UserMapper userMapper;

    @Test
    public void testAdd(){
        User user = new User();
        user.setAge(99);
        user.setEmail("testms@ydh.cn");
        user.setName("ydhms");
        user.setBirthDay(new Date());
        userMapper.insert(user);
    }

    @Test
    public void testFind(){
//        List<User> list = userMapper.findAll();
//        System.out.println(list.size());
        User user = userMapper.selectById(3L);
        System.out.println(user);
    }

}
