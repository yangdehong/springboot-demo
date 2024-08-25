package com.ydh.redsheep.database.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ydh.redsheep.database.mapper.UserMapper;
import com.ydh.redsheep.database.entity.po.UserPO;
import com.ydh.redsheep.database.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * (User)表服务实现类
 *
 * @author makejava
 * @since 2024-08-25 16:37:54
 */
@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    @Override
    public UserPO queryById(Long id) {
        return this.userMapper.queryById(id);
    }

    /**
     * 分页查询
     *
     * @param userPO        筛选条件
     * @return 查询结果
     */
    @Override
    public PageInfo<UserPO> queryByPage(UserPO userPO) {
        PageHelper.startPage(2, 3);
        List<UserPO> userPOS = userMapper.queryAllByLimit(userPO);
        PageInfo<UserPO> pageInfo = new PageInfo<>(userPOS);

        return pageInfo;
    }

    /**
     * 新增数据
     *
     * @param userPO 实例对象
     * @return 实例对象
     */
    @Override
    public UserPO insert(UserPO userPO) {
        this.userMapper.insert(userPO);
        return userPO;
    }

    /**
     * 修改数据
     *
     * @param userPO 实例对象
     * @return 实例对象
     */
    @Override
    public UserPO update(UserPO userPO) {
        this.userMapper.update(userPO);
        return this.queryById(userPO.getId());
    }

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Long id) {
        return this.userMapper.deleteById(id) > 0;
    }


    @Transactional
    @Override
    public void tx() {
        UserPO user = userMapper.queryById(1L);
        user.setAge(user.getAge()+1);
        userMapper.update(user);
//        userMapper.findAll();
        tx2();
//        int i = 1/0;
    }
    @Transactional
    @Override
    public void tx2() {
        UserPO user = userMapper.queryById(2L);
        user.setAge(user.getAge()+1);
        userMapper.update(user);
        int i = 1/0;
    }

    @Override
    public List<UserPO> findAll() {
        return userMapper.findAll();
    }
}
