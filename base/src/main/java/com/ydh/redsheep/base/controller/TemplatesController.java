package com.ydh.redsheep.base.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @author: yangdehong
 * @version: 2017/9/13.
 */
@Controller
@RequestMapping("templates")
public class TemplatesController {

    @GetMapping(value = "myTemp")
    public String myTemp(){
        return "index";
    }

    @PostMapping(value = "upload")
    public String upload(@RequestPart("filename") MultipartFile filename){
        try {
            filename.transferTo(new File("/Users/yangdehong/"+filename.getOriginalFilename()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "index";
    }

}
