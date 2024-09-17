package com.ydh.redsheep.database.common.utils;

import com.github.pagehelper.PageInfo;
import com.ydh.redsheep.database.common.bo.page.IPageable;
import com.ydh.redsheep.database.common.converter.PageConverter;

import java.util.List;
import java.util.function.Function;

import static java.util.stream.Collectors.toList;

public class PageUtil {

    public static <E, R> IPageable<R> pageInfo2Pageable(PageInfo<E> pageInfo, Function<? super E, ? extends R> fun) {
        IPageable<R> pageable = PageConverter.INSTANCE.pageInfo2Pageable(pageInfo);
        List<R> collect = (List<R>) pageInfo.getList().stream().map(obj -> Function.identity()).collect(toList());
        pageable.setDatas(collect);
        return pageable;
    }

}
