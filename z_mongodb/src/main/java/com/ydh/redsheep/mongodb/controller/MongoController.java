package com.ydh.redsheep.mongodb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/28.
 */
@RestController
@RequestMapping("mongo")
public class MongoController {

    @Autowired
    private MongoTemplate mongoTemplate;

    @RequestMapping("mongo")
    public String mongo(){

        List list = mongoTemplate.findAll(Object.class, "persons");

        return list.toString();
    }

}
