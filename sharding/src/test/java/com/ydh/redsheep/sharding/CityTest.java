package com.ydh.redsheep.sharding;

import com.ydh.redsheep.sharding.mapper.CityMapper;
import com.ydh.redsheep.sharding.mapper.UserDetailMapper;
import com.ydh.redsheep.sharding.mapper.UserMapper;
import com.ydh.redsheep.sharding.pojo.City;
import com.ydh.redsheep.sharding.pojo.User;
import com.ydh.redsheep.sharding.pojo.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
public class CityTest {

    @Resource
    private CityMapper cityMapper;

    @Test
    public void curd() {
        City city = new City();
        city.setName("温州");
        city.setProvince("浙江");
        cityMapper.insert(city);
    }

}
