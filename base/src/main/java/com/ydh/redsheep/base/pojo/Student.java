package com.ydh.redsheep.base.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
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
@Table(name = "student")
public class Student implements Serializable {

    @Id
    @GeneratedValue(generator = "JDBC")
    private Integer id;
    private String name;

}
