package com.ydh.redsheep.base.service;


import com.ydh.redsheep.base.pojo.User;

import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
public interface UserService {

    List<User> list();

    void insert();
}
