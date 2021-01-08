package com.ydh.redsheep;

import com.ydh.redsheep.base.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserTests {

    @Resource
    private UserService userService;

    @Test
    public void list(){
        log.debug("============"+userService.list());
    }

    @Test
    public void txTest(){
        userService.insert();
    }

}
