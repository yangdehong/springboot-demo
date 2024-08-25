package com.ydh.redsheep.database.service;

import com.github.pagehelper.PageInfo;
import com.ydh.redsheep.database.entity.po.UserPO;

import java.util.List;

/**
 * (User)表服务接口
 *
 * @author makejava
 * @since 2024-08-25 16:37:54
 */
public interface UserService {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserPO queryById(Long id);

    /**
     * 分页查询
     *
     * @param userPO        筛选条件
     * @return 查询结果
     */
    PageInfo<UserPO> queryByPage(UserPO userPO);

    /**
     * 新增数据
     *
     * @param userPO 实例对象
     * @return 实例对象
     */
    UserPO insert(UserPO userPO);

    /**
     * 修改数据
     *
     * @param userPO 实例对象
     * @return 实例对象
     */
    UserPO update(UserPO userPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     */
    boolean deleteById(Long id);

    void tx();
    void tx2();

    List<UserPO> findAll();

}
