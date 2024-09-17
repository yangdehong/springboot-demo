package com.ydh.redsheep.database.common.converter;

import com.github.pagehelper.PageInfo;
import com.ydh.redsheep.database.common.bo.page.Pageable;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PageConverter {

    PageConverter INSTANCE = Mappers.getMapper(PageConverter.class);

    Pageable pageInfo2Pageable(PageInfo pageInfo);

}
