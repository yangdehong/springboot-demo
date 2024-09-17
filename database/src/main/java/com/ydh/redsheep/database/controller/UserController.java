package com.ydh.redsheep.database.controller;

import com.github.pagehelper.PageInfo;
import com.ydh.redsheep.database.common.aop.RoutingWith;
import com.ydh.redsheep.database.common.bo.Result;
import com.ydh.redsheep.database.common.bo.page.IPageable;
import com.ydh.redsheep.database.common.bo.page.Pageable;
import com.ydh.redsheep.database.common.converter.PageConverter;
import com.ydh.redsheep.database.common.converter.UserConverter;
import com.ydh.redsheep.database.common.utils.PageUtil;
import com.ydh.redsheep.database.entity.po.UserPO;
import com.ydh.redsheep.database.entity.vo.UserVO;
import com.ydh.redsheep.database.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2024-08-25 16:37:51
 */
@RestController
@RequestMapping("user")
public class UserController {
    /**
     * 服务对象
     */
    @Resource
    private UserService userService;

    /**
     * 分页查询
     *
     * @param userPO        筛选条件
     * @return 查询结果
     */
    @GetMapping("queryByPage")
    public Result<IPageable<UserVO>> queryByPage(UserPO userPO) {
        PageInfo<UserPO> pageInfo = userService.queryByPage(userPO);
        Pageable pageable = PageConverter.INSTANCE.pageInfo2Pageable(pageInfo);
        pageable.setDatas(pageInfo.getList().stream().map(UserConverter.INSTANCE::userPO2UserVO).collect(Collectors.toList()));
        return Result.success(pageable);
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("queryById")
    public Result<UserPO> queryById(@RequestParam("id") Long id) {
        return Result.success(userService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @return 新增结果
     */
    @GetMapping("add")
    public Result<Void> add() {
        UserPO userPO = new UserPO();
        userPO.setId(97L);
        userPO.setAge(18);
        userPO.setEmail("test@ydh.cn");
        userPO.setName("ydh");
        userPO.setBirthDay(LocalDateTime.now());
        userService.insert(userPO);
        return Result.success();
    }

    /**
     * 编辑数据
     *
     * @return 编辑结果
     */
    @GetMapping("edit")
    public Result<Void> edit() {
        UserPO userPO = userService.queryById(1L);
        userPO.setAge(88);
        userService.update(userPO);
        return Result.success();
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping("deleteById")
    public Result<Void> deleteById(Long id) {
        userService.deleteById(id);
        return Result.success();
    }

    @GetMapping("tx")
    public void tx(){
        userService.tx();
    }

    @RoutingWith("masterDataSource")
    @GetMapping("/findAllM")
    public List<UserPO> findAllProductM() {
        return userService.findAll();
    }

    @RoutingWith("slaveDataSource")
    @GetMapping("/findAllS")
    public List<UserPO> findAllProductS() {
        return userService.findAll();
    }

}

