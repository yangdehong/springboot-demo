package com.ydh.redsheep.base.mapper;

import com.ydh.redsheep.base.common.mybatiplus.MyBaseMapper;
import com.ydh.redsheep.base.pojo.User;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
public interface UserMapper extends MyBaseMapper<User> {

    User findById(Long id);

//    void insertB(User user);

}
