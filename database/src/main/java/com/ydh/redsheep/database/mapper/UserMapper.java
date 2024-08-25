package com.ydh.redsheep.database.mapper;

import com.ydh.redsheep.database.entity.po.UserPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (User)表数据库访问层
 *
 * @author makejava
 * @since 2024-08-25 16:37:51
 */
public interface UserMapper {

    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    UserPO queryById(@Param("id") Long id);

    /**
     * 查询指定行数据
     *
     * @param userPO     查询条件
     * @return 对象列表
     */
    List<UserPO> queryAllByLimit(@Param("entity") UserPO userPO);

    /**
     * 新增数据
     *
     * @param userPO 实例对象
     * @return 影响行数
     */
    int insert(@Param("entity") UserPO userPO);

    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<UserPO> entities);

    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<User> 实例对象列表
     * @return 影响行数
     * @throws org.springframework.jdbc.BadSqlGrammarException 入参是空List的时候会抛SQL语句错误的异常，请自行校验入参
     */
    int insertOrUpdateBatch(@Param("entities") List<UserPO> entities);

    /**
     * 修改数据
     *
     * @param userPO 实例对象
     * @return 影响行数
     */
    int update(@Param("entity") UserPO userPO);

    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(@Param("id") Long id);

    List<UserPO> findAll();

}

