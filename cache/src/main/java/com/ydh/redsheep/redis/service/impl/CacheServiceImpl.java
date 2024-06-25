package com.ydh.redsheep.redis.service.impl;

import com.ydh.redsheep.redis.pojo.User;
import com.ydh.redsheep.redis.service.CacheService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class CacheServiceImpl implements CacheService {

    @Cacheable(cacheNames = {"user"}, key = "#id", condition = "#id > 0", unless = "#result == null")
    @Override
    public User getById(Long id){
        User user = new User();
        user.setId(id);
        user.setName("红羊");
        user.setAge(35);
        user.setEmail("3435748@qq.com");
        user.setBirthDay(LocalDateTime.now());
        user.setVersion(1);
        user.setIsDeleted(0);
        System.out.println("查询数据库");
        return user;
    }

    @CachePut(cacheNames = {"user"}, key = "#user.id")
    @Override
    public void update(User user) {
        System.out.println("修改数据库");
    }

    @CacheEvict(cacheNames = {"user"}, key = "#id")
    @Override
    public void delete(Long id) {
        System.out.println("删除数据库");
    }
}
