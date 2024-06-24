package com.ydh.redsheep.sharding.common.mybatiplus;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* 对MP的BaseMapper扩展
* @author : yangdehong
* @date : 2021/4/4 13:15
*/
public interface MyBaseMapper<T> extends BaseMapper<T> {

    List<T> findAll();

}
