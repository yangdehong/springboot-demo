package com.ydh.redsheep.base.pojo;

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/13.
 */
@Data
@ToString
@Component
@ConfigurationProperties(prefix = "person")
//@PropertySource("classpath:test.properties") // 可以加载自定义文件
public class PersonYml {

    private String height;
    private String weight;
    private String name;
    private String content;
    private List hobby;       //爱好
    private String[] family; //家庭成员
    private Map map;
    private Pet pet;          //宠物


}
