package com.ydh.redsheep.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ydh.redsheep.sharding.common.mybatiplus.MyBaseMapper;
import com.ydh.redsheep.sharding.pojo.User;
import com.ydh.redsheep.sharding.pojo.UserDetail;
import org.apache.ibatis.annotations.Mapper;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
@Mapper
public interface UserDetailMapper extends BaseMapper<UserDetail> {

}
