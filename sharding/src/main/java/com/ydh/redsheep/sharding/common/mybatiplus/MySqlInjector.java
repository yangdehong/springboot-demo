package com.ydh.redsheep.sharding.common.mybatiplus;

import com.baomidou.mybatisplus.core.injector.AbstractMethod;
import com.baomidou.mybatisplus.core.injector.DefaultSqlInjector;

import java.util.List;

/**
* 自定义sql注入器
* @author : yangdehong
* @date : 2021/4/4 13:15
*/
public class MySqlInjector extends DefaultSqlInjector {

    /**
     * 如果只需增加方法，保留MP自带方法
     * 可以super.getMethodList() 再add
     * @return
     */
    @Override
    public List<AbstractMethod> getMethodList(Class clazz) {
        List<AbstractMethod> methodList = super.getMethodList(clazz);
        methodList.add(new FindAll());
        return methodList;
    }



}
