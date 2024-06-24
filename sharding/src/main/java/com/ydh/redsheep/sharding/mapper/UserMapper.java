package com.ydh.redsheep.sharding.mapper;

import com.ydh.redsheep.sharding.common.mybatiplus.MyBaseMapper;
import com.ydh.redsheep.sharding.pojo.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
@Mapper
public interface UserMapper extends MyBaseMapper<User> {

    void insertB(User user);

}
