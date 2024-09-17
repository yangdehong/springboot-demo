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

    /**
     * （一般用于查询）主要针对方法配置，能够根据方法的请求参数对其结果进行缓存。如果没有缓存就先调用方法，再将结果缓存起来。如果已经有缓存那么这个方法就不会调用了。
     * 缓存ttl默认是24h，要设置ttl就需要做一些其他配置
     * **1、cacheNames/value**：指定缓存的名字，缓存使用CacheManager管理多个缓存组件Cache，这些Cache组件就是根据这个名字进行区分的。
     *      对缓存的真正CRUD操作在Cache中定义，每个缓存组件Cache都有自己唯一的名字，通过cacheNames或者value属性指定，
     *      相当于是将缓存的键值对进行分组，缓存的名字是一个数组，也就是说可以将一个缓存键值对分到多个组里面
     * **2、key**：缓存数据时的key的值，默认是使用方法参数的值，可以使用SpEL表达式计算key的值
     * **3、keyGenerator**：缓存的生成策略，和key二选一，都是生成键的，keyGenerator可自定义
     * **4、cacheManager**：指定缓存管理器(如ConcurrentHashMap、Redis等)
     * **5、cacheResolver** 和cacheManager功能一样，和cacheManager二选一
     * **6、condition** 指定缓存的条件(满足什么条件时才缓存)，可用SpEL表达式(如#id>0，表示当入参id大于0时才缓存)
     * **7、unless**：否定缓存，即满足unless指定的条件时，方法的结果不进行缓存，使用unless时可以在调用的方法获取到结果之后再进行判断(如#result==null，表示如果结果为null时不缓存)
     * **8、sync** 是否使用异步模式进行缓存
     *
     */
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

    /**
     * （一般用于更新）保证方法被调用，又希望结果被缓存。缓存就先调用方法，再将结果缓存起来。
     */
    @CachePut(cacheNames = {"user"}, key = "#user.id")
    @Override
    public User update(User user) {
        System.out.println("修改数据库");
        return user;
    }

    /**
     * 清空缓存
     * 1、allEntries：是否清除指定缓存中的所有键值对，默认为false，设置为true时会清除缓存中的所有键值对，与key属性二选一使用
     * 2、beforeInvocation：在@CacheEvict注解的方法调用之前清除指定缓存，默认为false，
     * 即在方法调用之后清除缓存，设置为true时则会在方法调用之前清除缓存(在方法调用之前还是之后清除缓存的区别在于方法调用时是否会出现异常，
     *      若不出现异常，这两种设置没有区别，若出现异常，设置为在方法调用之后清除缓存将不起作用，因为方法调用失败了)
     */
    @CacheEvict(cacheNames = {"user"}, key = "#id")
    @Override
    public void delete(Long id) {
        System.out.println("删除数据库");
    }
}
