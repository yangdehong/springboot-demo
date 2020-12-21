package com.ydh.redsheep.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
*
* @author : yangdehong
* @date : 2020/12/20 10:28
*/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    private Integer id;
    private String username;
    private String password;
    private String birthday;

    public User(String username) {
        this.username = username;
    }
}
