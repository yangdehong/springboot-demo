package com.ydh.redsheep.redis.service;

import com.ydh.redsheep.redis.pojo.User;

public interface CacheService {

    User getById(Long id);
    User update(User user);
    void delete(Long id);

}
