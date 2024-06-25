package com.ydh.redsheep.redis.pojo;

import lombok.Data;

import java.time.LocalDateTime;

/**
*
* @author : yangdehong
* @date : 2020/12/20 10:28
*/
@Data
public class User implements java.io.Serializable {

    private Long id;
    private String name;
    private Integer age;
    private String email;

    private LocalDateTime birthDay;

    private Integer version;

    private Integer isDeleted;

}
