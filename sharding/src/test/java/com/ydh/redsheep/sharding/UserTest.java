package com.ydh.redsheep.sharding;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ydh.redsheep.sharding.mapper.UserDetailMapper;
import com.ydh.redsheep.sharding.mapper.UserMapper;
import com.ydh.redsheep.sharding.pojo.User;
import com.ydh.redsheep.sharding.pojo.UserDetail;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.Date;

@SpringBootTest
public class UserTest {

    @Resource
    private UserMapper userMapper;
    @Resource
    private UserDetailMapper userDetailMapper;

    @Test
    public void curd() {

        IPage<UserDetail> userDetailIPage = userDetailMapper.selectPage(new Page<>(1, 1), null);
        Page<UserDetail> userDetailPage = new Page<>(1, 1);

        for (int i = 0; i < 2; i++) {
            User user = new User();
            user.setAge(1+i);
            user.setEmail("test"+i+"@ydh.cn");
            user.setName("ydh"+i);
            user.setBirthDay(new Date());
            userMapper.insert(user);
            UserDetail userDetail = new UserDetail();
            userDetail.setUserId(user.getId());
            userDetail.setContext("哇哈哈哈发的"+i);
            userDetailMapper.insert(userDetail);
        }

    }

}
