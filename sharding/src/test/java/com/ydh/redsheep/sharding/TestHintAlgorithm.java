package com.ydh.redsheep.sharding;

import com.ydh.redsheep.sharding.mapper.UserMapper;
import com.ydh.redsheep.sharding.pojo.User;
import org.apache.shardingsphere.api.hint.HintManager;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
public class TestHintAlgorithm {

    @Resource
    private UserMapper userMapper;

    @Test
    public void test1(){
        HintManager hintManager = HintManager.getInstance();
        hintManager.setDatabaseShardingValue(0L); //强制路由到ds${xx%2}
        List<User> list = userMapper.findAll();
        System.out.println(list.size());
    }

}
