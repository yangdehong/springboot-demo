package com.ydh.redsheep;

import com.ydh.redsheep.base.pojo.yml.PersonYml;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PersonTests {

    @Resource
    private PersonYml personYml;

    @Test
    public void test(){
        System.out.println(personYml);
    }

}
