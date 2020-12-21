package com.ydh.redsheep.base.mapper;

import com.ydh.redsheep.base.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
public interface UserMapper {

    List<User> list();
    void insert(@Param("model") User user);
}
