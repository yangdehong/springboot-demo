package com.ydh.redsheep.sharding.pojo;

import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

/**
*
* @author : yangdehong
* @date : 2020/12/20 10:28
*/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@TableName("user_detail")
public class UserDetail {

//    @TableId(type = IdType.INPUT) //指定id类型为自增长，可以在yml中配置全局策略
    private Long id;
    private Long userId;
    private String context;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer isDeleted;

}
