package com.ydh.redsheep.database.common.converter;

import com.ydh.redsheep.database.entity.po.UserPO;
import com.ydh.redsheep.database.entity.vo.UserVO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

/**
*
* @author : yangdehong
* @date : 2024/9/17 14:53
*/
@Mapper
public interface UserConverter {

    UserConverter INSTANCE = Mappers.getMapper(UserConverter.class);

    UserVO userPO2UserVO(UserPO user);
    List<UserVO> userPOs2UserVOs(List<UserPO> users);
    UserPO userVO2UserPO(UserVO user);
    List<UserPO> userVOs2UserPOs(List<UserVO> users);

}
