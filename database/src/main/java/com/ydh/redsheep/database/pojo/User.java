package com.ydh.redsheep.database.pojo;

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
@TableName("user")
public class User {

//    @TableId(type = IdType.ASSIGN_ID) //指定id类型为雪花算法
//    @TableId(type = IdType.AUTO) //指定id类型为自增长，可以在yml中配置全局策略
    private Long id;
    private String name;
    private Integer age;
    private String email;

//    @TableField(value = "birthday", // 如果表名和entity名字不一致，可以设置
//            exist = false,    // 表中不存在的字段设置
//            select = false,    // 查询的时候不返回
//            fill = FieldFill.INSERT, // 自动填充字段的时候
//            numericScale = "4" // 小数保留的位数
//    )
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime birthDay;

    @TableField(fill = FieldFill.INSERT)
    @Version
    private Integer version;

    @TableField(fill = FieldFill.INSERT)
    @TableLogic
    private Integer deleted;

}
