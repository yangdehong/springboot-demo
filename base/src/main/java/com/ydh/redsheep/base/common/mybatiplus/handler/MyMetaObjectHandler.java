package com.ydh.redsheep.base.common.mybatiplus.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

/**
* 自动填充
* @author : yangdehong
* @date : 2021/4/5 10:41
*/
@Component
public class MyMetaObjectHandler implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {
        Object version = getFieldValByName("version", metaObject);
        if (null == version) {
            //字段为空，可以进行填充
            setFieldValByName("version", 1, metaObject);
        }
        Object deleted = getFieldValByName("deleted", metaObject);
        if (null == deleted) {
            //字段为空，可以进行填充
            setFieldValByName("deleted", 0, metaObject);
        }
    }

    @Override
    public void updateFill(MetaObject metaObject) {
    }

}
