package com.ydh.redsheep.base.mapper;

import com.ydh.redsheep.base.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.cursor.Cursor;
import tk.mybatis.mapper.common.Mapper;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/22.
 */
public interface UserMapper extends Mapper<User> {

    Cursor<User> scan();

}
