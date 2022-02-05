package com.ydh.redsheep.database.mapper;

import com.ydh.redsheep.database.common.mybatiplus.MyBaseMapper;
import com.ydh.redsheep.database.pojo.User;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
public interface UserMapper extends MyBaseMapper<User> {

    void insertB(User user);

}
