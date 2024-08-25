package com.ydh.redsheep.database;

import com.ydh.redsheep.database.mapper.UserMapper;
import com.ydh.redsheep.database.entity.po.UserPO;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@SpringBootTest
public class UserTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void curd() {
        // 插入
        UserPO user = new UserPO();
        user.setId(99L);
        user.setAge(18);
        user.setEmail("test@ydh.cn");
        user.setName("ydh");
        user.setBirthDay(LocalDateTime.now());
        userMapper.insert(user);
//        // 根据id修改，更新不为null的字段
//        User user = new User();
//        user.setId(6L); //主键
//        user.setAge(21); //更新的字段
//        userMapper.updateById(user);
//        // 根据条件更新
//        User user = new User();
//        user.setAge(22); //更新的字段
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("id", 6);
//        userMapper.update(user, wrapper);
        // 根据 ID 删除
        userMapper.deleteById(9L);
//        // 根据 columnMap 条件，删除记录
//        Map<String, Object> columnMap = new HashMap<>();
//        columnMap.put("age",21);
//        columnMap.put("name","test");
//        userMapper.deleteByMap(columnMap);
//        // 根据 entity 条件，删除记录
//        User user = new User();
//        user.setAge(20);
//        user.setName("ydh");
//        QueryWrapper<User> wrapper = new QueryWrapper<>(user);
//        userMapper.delete(wrapper);
//        // 根据ID 批量删除
//        userMapper.deleteBatchIds(Arrays.asList(1L,10L,20L));
//        // 根据 ID 查询
//        User user = this.userMapper.selectById(2L);
//        System.out.println("result = " + user);
//        //根据id集合批量查询
//        List<User> users = this.userMapper.selectBatchIds(Arrays.asList(2L, 3L, 10L));
//        for (User u : users) {
//            System.out.println(u);
//        }
//        // 根据 entity 条件，查询一条记录
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.eq("name", "jack");
//        User user = this.userMapper.selectOne(wrapper);
//        System.out.println(user);
//        // 根据 Wrapper 条件，查询总记录数
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.gt("age", 23); //年龄大于23岁
//        Integer count = this.userMapper.selectCount(wrapper);
//        System.out.println("count = " + count);
//        // 根据 entity 条件，查询全部记录
//        List<User> users = this.userMapper.selectList(wrapper);
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }
//        // 分页
//        QueryWrapper<User> wrapper = new QueryWrapper<>();
//        wrapper.gt("age", 20); //年龄大于20岁
//        Page<User> page = new Page<>(1,2);
//        //根据条件查询数据
//        IPage<User> iPage = userMapper.selectPage(page, wrapper);
//        System.out.println("数据总条数:" + iPage.getTotal());
//        System.out.println("总页数:" + iPage.getPages());
//        List<User> users = iPage.getRecords();
//        for (User user : users) {
//            System.out.println("user = " + user);
//        }

    }

}
